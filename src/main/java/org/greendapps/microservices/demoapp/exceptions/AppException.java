package org.greendapps.microservices.demoapp.exceptions;

import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response.Status;

public class AppException extends WebApplicationException {

    private Status errorStatus;
    private String errorMessage;

    protected AppException(Status errorStatus, String errorMessage) {
        super();
        this.errorStatus = errorStatus;
        this.errorMessage = errorMessage;
    }

    /**
     * @return Status return the errorStatus
     */
    public Status getErrorStatus() {
        return errorStatus;
    }

    /**
     * @param errorStatus the errorStatus to set
     */
    public void setErrorStatus(Status errorStatus) {
        this.errorStatus = errorStatus;
    }

    /**
     * @return String return the errorMessage
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * @param errorMessage the errorMessage to set
     */
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

}
