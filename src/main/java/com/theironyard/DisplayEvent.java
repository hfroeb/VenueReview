package com.theironyard;

/**
 * Created by jakefroeb on 11/8/16.
 * {{name}}</h1>

 {{type}}
 <br>
 {{description}}
 <br>
 {{start.localDate}}
 <br>
 Starting time: {{start.localTime}}, Ending Time: {{end.localTime}}
 <br>
 <a href="{{url}}">{{url}}</a> <br>
 */
public class DisplayEvent {
    public String name;
    public String type;
    public String description;
    public String startDate;
    public String time;
    public String endDate;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public DisplayEvent() {

    }

    public DisplayEvent(String name, String type, String description, String startDate, String time, String endDate, String url) {

        this.name = name;
        this.type = type;
        this.description = description;
        this.startDate = startDate;
        this.time = time;
        this.endDate = endDate;
        this.url = url;
    }
}
