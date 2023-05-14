package org.greendapps.microservices.demoapp.dtos.activities.apidata;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class MetaData {

    @JsonIgnore
    private Results results;

    @JsonIgnore
    private SearchParameters searchParameters;

    /**
     * @return MetaData return the metaData
     */
    public MetaData() {
    }

    /**
     * @return MetaData return the metaData
     * @param results          the results to set
     * @param searchParameters the searchParameters to set
     */
    public MetaData(Results results, SearchParameters searchParameters) {
        this.results = results;
        this.searchParameters = searchParameters;
    }

    /**
     * @return Results return the results
     */
    public Results getResults() {
        return results;
    }

    /**
     * @param results the results to set
     */
    public void setResults(Results results) {
        this.results = results;
    }

    /**
     * @return SearchParameters return the searchParameters
     */
    public SearchParameters getSearchParameters() {
        return searchParameters;
    }

    /**
     * @param searchParameters the searchParameters to set
     */
    public void setSearchParameters(SearchParameters searchParameters) {
        this.searchParameters = searchParameters;
    }

}
