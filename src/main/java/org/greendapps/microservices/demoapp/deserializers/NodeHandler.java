package org.greendapps.microservices.demoapp.deserializers;

import com.fasterxml.jackson.databind.JsonNode;

import jakarta.ws.rs.WebApplicationException;

public class NodeHandler {

    private NodeHandler() {
    }

    public static String stringOrNull(JsonNode node, String fieldName) {
        JsonNode value = node.get(fieldName);
        if (value == null)
            return null;
        if (!value.isTextual())
            throw new WebApplicationException();

        return value.asText();
    }

    public static Integer integerOrNull(JsonNode node, String fieldName) {
        JsonNode value = node.get(fieldName);
        if (value == null)
            return null;
        if (!value.isInt())
            throw new WebApplicationException();

        return value.asInt();
    }

}
