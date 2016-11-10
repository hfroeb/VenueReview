package com.theironyard.JsonObjects.Event;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class JsonEvent {
   private Events _embedded;

    public Events get_embedded() {
        if(_embedded== null)
            return new Events();
        else
        return _embedded;
    }

    public void set_embedded(Events _embedded) {
        this._embedded = _embedded;
    }
}
