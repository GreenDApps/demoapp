package org.greendapps.microservices.demoapp.deserializers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.greendapps.microservices.demoapp.dtos.activities.apidata.Activities;
import org.greendapps.microservices.demoapp.dtos.activities.apidata.Activity;
import org.greendapps.microservices.demoapp.dtos.activities.apidata.MetaData;
import org.greendapps.microservices.demoapp.dtos.activities.apidata.Results;
import org.greendapps.microservices.demoapp.dtos.activities.apidata.SearchParameters;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import jakarta.ws.rs.WebApplicationException;

public class ActivitiesDeserializer extends StdDeserializer<Activities> {

    private static final long serialVersionUID = 1L;

    public ActivitiesDeserializer() {
        this(null);
    }

    protected ActivitiesDeserializer(Class<Activities> vc) {
        super(vc);
    }

    @Override
    public Activities deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
        try {
            JsonNode activitiesNode = p.getCodec().readTree(p);
            JsonNode metaDataNode = activitiesNode.get(Constants.JSON_NODE_KEY_METADATA);
            JsonNode recDataNode = activitiesNode.get(Constants.JSON_NODE_KEY_RECDATA);
            Activities activities = new Activities();
            activities.setMetaData(this.metaData(metaDataNode));
            activities.setRecData(this.recData(recDataNode));

            return activities;
        } catch (Exception e) {
            throw new WebApplicationException();
        }
    }

    private MetaData metaData(JsonNode metaDataNode) {
        if (metaDataNode == null)
            return new MetaData();

        Results results = new Results();
        SearchParameters searchParameters = new SearchParameters();

        JsonNode resultsNode = metaDataNode.get(Constants.JSON_NODE_KEY_RESULTS);
        if (resultsNode != null) {
            results.setCurrentCount(NodeHandler.integerOrNull(resultsNode, Constants.JSON_FIELD_KEY_CURRENT_COUNT));
            results.setTotalCount(NodeHandler.integerOrNull(resultsNode, Constants.JSON_FIELD_KEY_TOTAL_COUNT));
        }

        JsonNode searchParametersNode = metaDataNode.get(Constants.JSON_NODE_KEY_SEARCH_PARAMETERS);
        if (searchParametersNode != null) {
            searchParameters.setLimit(NodeHandler.integerOrNull(searchParametersNode, Constants.JSON_FIELD_KEY_LIMIT));
            searchParameters
                    .setOffset(NodeHandler.integerOrNull(searchParametersNode, Constants.JSON_FIELD_KEY_OFFSET));
            searchParameters.setQuery(NodeHandler.stringOrNull(searchParametersNode, Constants.JSON_FIELD_KEY_QUERY));
        }

        return new MetaData(results, searchParameters);
    }

    private List<Activity> recData(JsonNode recDataNode) {
        if (recDataNode == null)
            return new ArrayList<>();

        List<Activity> activityList = new ArrayList<>();
        for (JsonNode n : recDataNode) {
            Activity activity = new Activity();
            activity.setActivityId(NodeHandler.integerOrNull(n, Constants.JSON_FIELD_KEY_ACTIVITY_ID));
            activity.setActivityLevel(NodeHandler.integerOrNull(n, Constants.JSON_FIELD_KEY_ACTIVITY_LEVEL));
            activity.setActivityName(NodeHandler.stringOrNull(n, Constants.JSON_FIELD_KEY_ACTIVITY_NAME));
            activity.setActivityParentId(NodeHandler.integerOrNull(n, Constants.JSON_FIELD_KEY_ACTIVITY_PARENT_ID));
            activityList.add(activity);
        }

        return activityList;
    }

}
