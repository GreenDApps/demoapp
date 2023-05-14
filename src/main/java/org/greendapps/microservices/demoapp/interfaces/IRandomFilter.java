package org.greendapps.microservices.demoapp.interfaces;

import org.greendapps.microservices.demoapp.exceptions.customs.FilterException;

public interface IRandomFilter {

    public void apply();

    default void throwFilterException() {
        throw new FilterException("");
    }

}
