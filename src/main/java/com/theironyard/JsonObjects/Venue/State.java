package com.theironyard.JsonObjects.Venue;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by jakefroeb on 11/8/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class State {
    private String name;
    private String stateCode;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

}
