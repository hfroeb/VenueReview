package com.theironyard.JsonObjects.Venue;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *
 * Created by jakefroeb on 11/8/16.
 */
@JsonIgnoreProperties (ignoreUnknown = true)
public class Json1 {
    private Venues _embedded;

    public Venues get_embedded() {

        return _embedded;
    }

    public void set_embedded(Venues _embedded) {
        this._embedded = _embedded;
    }
}
