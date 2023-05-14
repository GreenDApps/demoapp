package org.greendapps.microservices.demoapp.business.specials;

import java.lang.reflect.Constructor;

import org.greendapps.microservices.demoapp.dtos.activities.specials.SpecialActivityDto;

import jakarta.ws.rs.WebApplicationException;

public class SpecialActivityBusiness {

    private SpecialActivityBusiness() {
    }

    public static SpecialActivityDto create(
            String name,
            Boolean isFavoriteOne,
            Class<? extends SpecialActivityDto> clazz) {

        try {
            Constructor<?> constr = clazz.getConstructor(
                    String.class,
                    Boolean.class);

            return clazz.cast(constr.newInstance(name, isFavoriteOne));
        } catch (Exception e) {
            throw new WebApplicationException();
        }

    }

}
