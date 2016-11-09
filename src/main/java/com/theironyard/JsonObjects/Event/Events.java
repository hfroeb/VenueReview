package com.theironyard.JsonObjects.Event;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Events {
    private Event[] events;

    public Event[] getEvents() {
        if(events==null){
            events=new Event[1];
            events[0]=new Event();
        }
        return events;
    }

    public void setEvents(Event[] events) {
        this.events = events;
    }
}
