package com.theironyard;

/**
 * Created by jakefroeb on 11/8/16.
 */
public class DisplayVenue {
    public String id;
    public String venue_name;
    public String address;
    public String city_name;
    public String region_abbr;
    public String postal_code;
    public String url;

    public DisplayVenue(String id, String venue_name, String address, String city_name, String region_abbr, String postal_code, String url) {
        this.id = id;
        this.venue_name = venue_name;
        this.address = address;
        this.city_name = city_name;
        this.region_abbr = region_abbr;
        this.postal_code = postal_code;
        this.url = url;
    }

    public DisplayVenue() {
    }
}
