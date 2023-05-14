package org.greendapps.microservices.demoapp.exceptions.customs;

import org.greendapps.microservices.demoapp.exceptions.AppException;

import jakarta.ws.rs.core.Response.Status;

public class FilterException extends AppException {

    public FilterException(String errorMessage) {
        super(Status.fromStatusCode(418), errorMessage);
    }

}
