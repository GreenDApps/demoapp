package org.greendapps.microservices.demoapp.dtos.activities.apidata;

import org.greendapps.microservices.demoapp.deserializers.Constants;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Activity {

    public static final Activity RECOVER = new Activity(0, 0, "", 0);

    @JsonProperty(value = Constants.JSON_FIELD_KEY_ACTIVITY_ID)
    private Integer activityId;

    @JsonProperty(value = Constants.JSON_FIELD_KEY_ACTIVITY_LEVEL)
    private Integer activityLevel;

    @JsonProperty(value = Constants.JSON_FIELD_KEY_ACTIVITY_NAME)
    private String activityName;

    @JsonProperty(value = Constants.JSON_FIELD_KEY_ACTIVITY_PARENT_ID)
    private Integer activityParentId;

    /**
     * @return Activity return the activity
     */
    public Activity() {
    }

    /**
     * @return Activity return the activity
     * @param activityId       the activityId to set
     * @param activityLevel    the activityLevel to set
     * @param activityName     the activityName to set
     * @param activityParentId the activityParentId to set
     */
    public Activity(Integer activityId, Integer activityLevel, String activityName, Integer activityParentId) {
        this.activityId = activityId;
        this.activityLevel = activityLevel;
        this.activityName = activityName;
        this.activityParentId = activityParentId;
    }

    /**
     * @return Integer return the activityId
     */
    public Integer getActivityId() {
        return activityId;
    }

    /**
     * @param activityId the activityId to set
     */
    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    /**
     * @return Integer return the activityLevel
     */
    public Integer getActivityLevel() {
        return activityLevel;
    }

    /**
     * @param activityLevel the activityLevel to set
     */
    public void setActivityLevel(Integer activityLevel) {
        this.activityLevel = activityLevel;
    }

    /**
     * @return String return the activityName
     */
    public String getActivityName() {
        return activityName;
    }

    /**
     * @param activityName the activityName to set
     */
    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    /**
     * @return Integer return the activityParentId
     */
    public Integer getActivityParentId() {
        return activityParentId;
    }

    /**
     * @param activityParentId the activityParentId to set
     */
    public void setActivityParentId(Integer activityParentId) {
        this.activityParentId = activityParentId;
    }

}
