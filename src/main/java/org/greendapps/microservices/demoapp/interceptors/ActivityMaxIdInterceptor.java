package org.greendapps.microservices.demoapp.interceptors;

import org.greendapps.microservices.demoapp.annotations.ActivityMaxId;
import org.greendapps.microservices.demoapp.exceptions.customs.MaxIdException;

import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;
import jakarta.ws.rs.WebApplicationException;

@ActivityMaxId
@Interceptor
public class ActivityMaxIdInterceptor {

    private static final int API_EXPECTED_MAX_ID = 128;

    @AroundInvoke
    Object intercept(InvocationContext context) {

        try {
            int requestMaxId = (int) context.getParameters()[0];

            if (requestMaxId <= API_EXPECTED_MAX_ID)
                return context.proceed();

            throw new MaxIdException("ActivityId value must not exceed " + API_EXPECTED_MAX_ID);
        } catch (MaxIdException mie) {
            throw mie;
        } catch (Exception e) {
            throw new WebApplicationException();
        }

    }

}
