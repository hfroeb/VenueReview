package com.theironyard.JsonObjects.Venue;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *
 * Created by jakefroeb on 11/8/16.
 * {
 "_embedded": {
 "venues": [
 {
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
