package org.greendapps.microservices.demoapp.services;

import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.greendapps.microservices.demoapp.dtos.activities.apidata.Activities;
import org.greendapps.microservices.demoapp.dtos.activities.apidata.Activity;

import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("/v1")
@RegisterRestClient(configKey = "activities-api")
@ClientHeaderParam(name = "apikey", value = "${ridb.auth-key}")
@ClientHeaderParam(name = "accept", value = "application/json")
public interface ActivityService {

    @GET
    @Path("/activities")
    Uni<Activities> getAllAsUni();

    @GET
    @Path("/activities/{id}")
    Uni<Activity> getByIdAsUni(@PathParam("id") int id);

}
