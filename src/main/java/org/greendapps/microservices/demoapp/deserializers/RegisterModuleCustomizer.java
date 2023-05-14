package org.greendapps.microservices.demoapp.deserializers;

import org.greendapps.microservices.demoapp.dtos.activities.apidata.Activities;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

import io.quarkus.jackson.ObjectMapperCustomizer;
import jakarta.inject.Singleton;

@Singleton
public class RegisterModuleCustomizer implements ObjectMapperCustomizer {

    @Override
    public void customize(ObjectMapper objectMapper) {
        objectMapper.registerModule(this.addDeserializers());
    }

    private SimpleModule addDeserializers() {
        SimpleModule module = new SimpleModule();
        module.addDeserializer(Activities.class, new ActivitiesDeserializer());

        return module;
    }

}
