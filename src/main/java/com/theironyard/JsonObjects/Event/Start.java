package com.theironyard.JsonObjects.Event;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by jakefroeb on 11/8/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Start {
    public String localDate;
    public String localTime;

    public String getLocalDate() {
        if (localDate == null){
            return "";
        }
        return localDate;
    }

    public void setLocalDate(String localDate) {
        this.localDate = localDate;
    }

    public String getLocalTime() {
        return localTime;
    }

    public void setLocalTime(String localTime) {
        this.localTime = localTime;
    }
}
