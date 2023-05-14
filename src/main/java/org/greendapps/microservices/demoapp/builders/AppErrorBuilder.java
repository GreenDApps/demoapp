package org.greendapps.microservices.demoapp.builders;

import java.util.ArrayList;
import java.util.List;

import org.greendapps.microservices.demoapp.dtos.errors.AppError;

public class AppErrorBuilder {

    private int status;
    private String message;
    private List<String> details;

    private AppErrorBuilder() {
    }

    public static AppErrorBuilder newInstance() {
        return new AppErrorBuilder();
    }

    public AppError build() {
        AppError appError = new AppError();
        appError.setStatus(this.status);
        appError.setMessage(this.message);
        appError.setDetails(this.details);

        return appError;
    }

    public AppErrorBuilder status(int status) {
        this.status = status;

        return this;
    }

    public AppErrorBuilder message(String message) {
        this.message = message;

        return this;
    }

    public AppErrorBuilder addDetail(String detail) {
        if (this.details == null)
            this.details = new ArrayList<>();

        this.details.add(detail);

        return this;
    }

}
