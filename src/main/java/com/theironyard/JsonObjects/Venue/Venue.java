package com.theironyard.JsonObjects.Venue;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by jakefroeb on 11/8/16.
 * {
 "name": "Carousel Theatre, Univ of Tennessee",
 "type": "venue",
 "id": "KovZpa9wze",
 "test": false,
 "url": "http://ticketmaster.com/venue/222327",
 "locale": "en-us",
 "postalCode": "37996",
 "timezone": "America/Chicago",
 "city": {
 "name": "Knoxville"
 },
 "state": {
 "name": "Tennessee",
 "stateCode": "TN"
 },
 "country": {
 "name": "United States Of America",
 "countryCode": "US"
 },
 "address": {
 "line1": "1710 Andy Holt Ave"
 },
 "location": {
 "longitude": "-83.92853360",
 "latitude": "35.95530860"
 },
 "markets": [
 {
 "id": "31"
 }
 ],
 "dmas": [
 {
 "id": 236
 },
 {
 "id": 247
 },
 {
 "id": 312
 },
 {
 "id": 343
 }
 ],
 "_links": {
 "self": {
 "href": "/discovery/v2/venues/KovZpa9wze?locale=en-us"
 }
 }
 }
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Venue {
    private String name;
    private String type;
    private String id;
    private String postalCode;
    private City city;
    private State state;
    private Address address;
    private String url;

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

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public City getCity() {
        if(city == null){
            return new City();
        }else
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public State getState() {
        if (state == null)
            return new State();
        else
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Address getAddress() {
        if (address==null)
            return new Address();
        else
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getUrl() {

        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
