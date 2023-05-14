package org.greendapps.microservices.demoapp.dtos.activities.apidata;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class SearchParameters {

    @JsonIgnore
    private Integer limit;

    @JsonIgnore
    private Integer offset;

    @JsonIgnore
    private String query;

    /**
     * @return SearchParameters return the searchParameters
     */
    public SearchParameters() {
    }

    /**
     * @return SearchParameters return the searchParameters
     * @param limit  the limit to set
     * @param offset the offset to set
     * @param query  the query to set
     */
    public SearchParameters(Integer limit, Integer offset, String query) {
        this.limit = limit;
        this.offset = offset;
        this.query = query;
    }

    /**
     * @return Integer return the limit
     */
    public Integer getLimit() {
        return limit;
    }

    /**
     * @param limit the limit to set
     */
    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    /**
     * @return Integer return the offset
     */
    public Integer getOffset() {
        return offset;
    }

    /**
     * @param offset the offset to set
     */
    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    /**
     * @return Integer return the query
     */
    public String getQuery() {
        return query;
    }

    /**
     * @param query the query to set
     */
    public void setQuery(String query) {
        this.query = query;
    }

}
