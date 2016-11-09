package com.theironyard.JsonObjects.Event;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by jakefroeb on 11/9/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Dates {
    private Start start;

    public Start getStart() {
        if (start == null)
            return new Start();
        else
        return start;
    }

    public void setStart(Start start) {
        this.start = start;
    }
}
