package org.greendapps.microservices.demoapp.exceptions;

import org.greendapps.microservices.demoapp.builders.AppErrorBuilder;
import org.jboss.logging.Logger;

import jakarta.inject.Inject;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class GlobalExceptionMapper implements ExceptionMapper<Exception> {

    @Inject
    Logger logger;

    @Override
    public Response toResponse(Exception e) {
        try {
            Response errorResponse = mapExceptionToResponse(e);

            return Response.fromResponse(errorResponse)
                    .entity(
                            AppErrorBuilder.newInstance()
                                    .status(errorResponse.getStatus())
                                    .message((String) errorResponse.getEntity())
                                    .build())
                    .build();
        } catch (Exception ex) {

            return Response.serverError().build();
        }
    }

    private Response mapExceptionToResponse(Exception e) {
        logger.error(e.getMessage());

        if (e instanceof AppException) {

            return Response
                    .status(((AppException) e).getErrorStatus())
                    .entity(((AppException) e).getErrorMessage())
                    .build();
        } else if (e instanceof NotFoundException) {

            return Response.status(404).entity("Request could not be performed").build();
        } else {

            return Response.serverError().entity("Internal Server Error").build();
        }

    }

}
