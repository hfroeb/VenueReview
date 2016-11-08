package com.theironyard.JsonObjects.Venue;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by jakefroeb on 11/8/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class City {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
