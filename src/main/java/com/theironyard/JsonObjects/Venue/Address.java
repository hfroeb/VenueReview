package com.theironyard.JsonObjects.Venue;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by jakefroeb on 11/8/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Address {
    private String line1;

    public String getLine1() {
        if (line1 == null) {
            return "";
        }
        else
        return line1;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }
}
