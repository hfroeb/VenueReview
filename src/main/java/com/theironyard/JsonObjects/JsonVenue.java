package com.theironyard.JsonObjects;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class JsonVenue {
    private JsonVenue2 venues;

    public JsonVenue2 getVenues() {
        return venues;
    }

    public void setVenues(JsonVenue2 venues) {
        this.venues = venues;
    }


}



