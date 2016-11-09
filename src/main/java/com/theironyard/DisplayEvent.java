package com.theironyard;

/**
 * Created by jakefroeb on 11/8/16.
 *
 */
public class DisplayEvent {
    public String name;
    public String type;
    public String startDate;
    public String time;
    public String url;

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

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public DisplayEvent() {

    }

    public DisplayEvent(String name, String type, String startDate, String time, String url) {

        this.name = name;
        this.type = type;
        this.startDate = startDate;
        this.time = time;
        this.url = url;
    }
}
