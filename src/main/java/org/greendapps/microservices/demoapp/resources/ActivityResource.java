package org.greendapps.microservices.demoapp.resources;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.greendapps.microservices.demoapp.annotations.ActivityMaxId;
import org.greendapps.microservices.demoapp.business.apidata.ActivityBusiness;
import org.greendapps.microservices.demoapp.dtos.activities.apidata.Activity;
import org.greendapps.microservices.demoapp.services.ActivityService;
import org.greendapps.microservices.demoapp.utils.RandomUtil;

import io.smallrye.common.annotation.Blocking;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("/activities")
public class ActivityResource {

    @RestClient
    ActivityService activityService;

    @Inject
    ActivityBusiness activityBusiness;

    @GET
    @Path("/special-activity")
    @Blocking
    public Response specialActivity(@QueryParam("name") String name) {

        return Response.ok("A special activity may have been logged").build();
    }

    @GET
    @Path("")
    public Uni<List<Activity>> uniAllActivities() {

        return activityService.getAllAsUni()
                .onItem()
                .transform(e -> e.getRecData())
                .ifNoItem().after(Duration.ofSeconds(1))
                .fail()
                .onFailure()
                .recoverWithItem(new ArrayList<>(List.of(Activity.RECOVER)));
    }

    /*
     * ActivityMaxId annotation avoids maxId value
     * to be out of range considering API data limitations
     */
    @GET
    @Path("/{maxId}")
    @ActivityMaxId
    public Multi<Activity> multiRandomByMaxId(@PathParam("maxId") int max) {

        return Multi.createFrom()
                .ticks()
                .every(Duration.ofSeconds(1))
                .onItem()
                .transformToUni(e -> activityService
                        .getByIdAsUni(RandomUtil.inRange(0, max))
                        .onFailure()
                        .recoverWithItem(Activity.RECOVER))
                .merge();
    }

    @GET
    @Path("/random-filters")
    @Blocking
    public Response randomFilters() {

        if (!activityBusiness.randomFilters())
            return Response.status(Status.FORBIDDEN)
                    .entity("Forbidden")
                    .build();

        return Response.ok("Successful").build();
    }

}
