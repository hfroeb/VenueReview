package com.theironyard.controllers;

import com.theironyard.controllers.Venue;

/**
 * Created by jakefroeb on 11/2/16.
 */
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