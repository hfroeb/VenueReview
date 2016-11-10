package com.theironyard.JsonObjects.Venue;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by jakefroeb on 11/8/16.
 *
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
