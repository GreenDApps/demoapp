package org.greendapps.microservices.demoapp.dtos.activities.apidata;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Activities {

    @JsonIgnore
    private MetaData metaData;

    private List<Activity> recData;

    /**
     * @return Activities return the activities
     */
    public Activities() {
    }

    /**
     * @return Activities return the activities
     * @param recData the recData to set
     */
    public Activities(MetaData metaData, List<Activity> recData) {
        this.metaData = metaData;
        this.recData = recData;
    }

    /**
     * @return MetaData return the metaData
     */
    public MetaData getMetaData() {
        return metaData;
    }

    /**
     * @param metaData the metaData to set
     */
    public void setMetaData(MetaData metaData) {
        this.metaData = metaData;
    }

    /**
     * @return List<Activity> return the recData
     */
    public List<Activity> getRecData() {
        return recData;
    }

    /**
     * @param recData the recData to set
     */
    public void setRecData(List<Activity> recData) {
        this.recData = recData;
    }

}
