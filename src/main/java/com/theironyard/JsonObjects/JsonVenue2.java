package com.theironyard.JsonObjects;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class JsonVenue2
{
    private JsonVenue1[] venue;

    public JsonVenue1[] getVenue ()
    {
        return venue;
    }

    public void setVenue (JsonVenue1[] venue)
    {
        this.venue = venue;
    }

}