package com.theironyard.JsonObjects.Event;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by jakefroeb on 11/8/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Event {
    private String name;
    private String type;
    private String id;
    private String url;
    private Dates dates;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Dates getDates() {
        if(dates== null)
            return new Dates();
        else
        return dates;
    }

    public void setDates(Dates dates) {
        this.dates = dates;
    }
}
