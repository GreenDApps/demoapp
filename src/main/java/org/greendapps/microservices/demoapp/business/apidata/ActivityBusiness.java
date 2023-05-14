package org.greendapps.microservices.demoapp.business.apidata;

import org.greendapps.microservices.demoapp.exceptions.customs.FilterException;
import org.greendapps.microservices.demoapp.interfaces.IRandomFilter;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Instance;
import jakarta.inject.Inject;

@ApplicationScoped
public class ActivityBusiness {

    @Inject
    Instance<IRandomFilter> filters;

    public boolean randomFilters() {

        for (IRandomFilter filter : filters) {
            try {

                filter.apply();
            } catch (FilterException rfe) {

                return false;
            }
        }

        return true;
    }

}
