package org.greendapps.microservices.demoapp.dtos.activities.apidata;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Results {

    @JsonIgnore
    private Integer currentCount;

    @JsonIgnore
    private Integer totalCount;

    /**
     * @return Results return the results
     */
    public Results() {
    }

    /**
     * @return Results return the results
     * @param currentCount the currentCount to set
     * @param totalCount   the totalCount to set
     */
    public Results(Integer currentCount, Integer totalCount) {
        this.currentCount = currentCount;
        this.totalCount = totalCount;
    }

    /**
     * @return Integer return the currentCount
     */
    public Integer getCurrentCount() {
        return currentCount;
    }

    /**
     * @param currentCount the currentCount to set
     */
    public void setCurrentCount(Integer currentCount) {
        this.currentCount = currentCount;
    }

    /**
     * @return Integer return the totalCount
     */
    public Integer getTotalCount() {
        return totalCount;
    }

    /**
     * @param totalCount the totalCount to set
     */
    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

}
