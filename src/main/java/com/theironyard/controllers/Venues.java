package com.theironyard.controllers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.theironyard.controllers.Venue;

/**
 * Created by jakefroeb on 11/2/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Venues
{
    private Venue[] venue;

    public Venue[] getVenue ()
    {
        return venue;
    }

    public void setVenue (Venue[] venue)
    {
        this.venue = venue;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [venue = "+venue+"]";
    }
}