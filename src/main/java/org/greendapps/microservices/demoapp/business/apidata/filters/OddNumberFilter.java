package org.greendapps.microservices.demoapp.business.apidata.filters;

import org.greendapps.microservices.demoapp.interfaces.IRandomFilter;
import org.greendapps.microservices.demoapp.utils.RandomUtil;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class OddNumberFilter implements IRandomFilter {

    @Override
    public void apply() {
        int random = RandomUtil.inRange(0, 10);

        if (random % 2 != 0)
            this.throwFilterException();
    }

}
