package org.greendapps.microservices.demoapp.dtos.errors;

import java.util.List;

public class AppError {

    private int status;
    private String message;
    private List<String> details;

    /**
     * @return AppError return the error
     */
    public AppError() {
    }

    /**
     * @return int return the status
     */
    public int getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * @return String return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return List<String> return the details
     */
    public List<String> getDetails() {
        return details;
    }

    /**
     * @param details the details to set
     */
    public void setDetails(List<String> details) {
        this.details = details;
    }

}
