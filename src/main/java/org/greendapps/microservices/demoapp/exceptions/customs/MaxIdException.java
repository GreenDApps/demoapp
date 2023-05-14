package org.greendapps.microservices.demoapp.exceptions.customs;

import org.greendapps.microservices.demoapp.exceptions.AppException;

import jakarta.ws.rs.core.Response.Status;

public class MaxIdException extends AppException {

    public MaxIdException(String errorMessage) {
        super(Status.BAD_REQUEST, errorMessage);
    }

}
