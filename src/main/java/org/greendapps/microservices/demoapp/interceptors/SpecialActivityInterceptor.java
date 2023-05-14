package org.greendapps.microservices.demoapp.interceptors;

import org.greendapps.microservices.demoapp.business.specials.SpecialActivityBusiness;
import org.greendapps.microservices.demoapp.dtos.activities.specials.IndoorActivityDto;
import org.greendapps.microservices.demoapp.dtos.activities.specials.SpecialActivityDto;
import org.greendapps.microservices.demoapp.dtos.activities.specials.IndoorActivityDto.IndoorActivityEnum;
import org.jboss.logging.Logger;
import org.jboss.resteasy.reactive.server.ServerRequestFilter;

import jakarta.inject.Inject;
import jakarta.ws.rs.container.ContainerRequestContext;

public class SpecialActivityInterceptor {

    @Inject
    Logger logger;

    @ServerRequestFilter
    public void getFilter(ContainerRequestContext context) {

        if (context.getUriInfo().getPath().contains("special-activity")) {

            try {
                String name = context.getUriInfo()
                        .getQueryParameters()
                        .get("name")
                        .get(0);

                SpecialActivityDto specialActivityDto = null;
                switch (name.toUpperCase()) {
                    case "AMPHITHEATER":
                    case "MUSEUM":
                        specialActivityDto = SpecialActivityBusiness.create(
                                name,
                                Boolean.TRUE,
                                IndoorActivityDto.class);
                        if (specialActivityDto != null)
                            ((IndoorActivityDto) specialActivityDto).setSpecialType(IndoorActivityEnum.EDUCATION);
                        break;

                    case "BADMINTON":
                    case "ARCHERY":
                        specialActivityDto = SpecialActivityBusiness.create(
                                name,
                                Boolean.FALSE,
                                IndoorActivityDto.class);
                        if (specialActivityDto != null)
                            ((IndoorActivityDto) specialActivityDto).setSpecialType(IndoorActivityEnum.SPARE_TIME);
                        break;

                    default:
                }

                if (specialActivityDto instanceof IndoorActivityDto)
                    logger.info("SPECIAL_ACTIVITY - " + ((IndoorActivityDto) specialActivityDto).toString());

            } catch (Exception e) {
                logger.error("An error has occured");
            }

        }

    }

}
