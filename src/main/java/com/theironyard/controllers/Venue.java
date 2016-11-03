package com.theironyard.controllers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by jakefroeb on 11/2/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Venue
{
    private String comment_count;

    private String trackback_count;

    private String city_name;

    private String region_abbr;

    private String venue_name;

    private String image;

    private String country_abbr2;

    private String country_name;

    private String url;

    private String venue_type;

    private String id;

    private String region_name;

    private String country_abbr;

    private String timezone;

    private String created;

    private String address;

    private String description;

    private String link_count;

    private String name;

    private String postal_code;

    private String owner;

    private String geocode_type;

    private String longitude;

    private String latitude;

    private String event_count;

    public String getComment_count ()
    {
        return comment_count;
    }

    public void setComment_count (String comment_count)
    {
        this.comment_count = comment_count;
    }

    public String getTrackback_count ()
    {
        return trackback_count;
    }

    public void setTrackback_count (String trackback_count)
    {
        this.trackback_count = trackback_count;
    }

    public String getCity_name ()
    {
        return city_name;
    }

    public void setCity_name (String city_name)
    {
        this.city_name = city_name;
    }

    public String getRegion_abbr ()
    {
        return region_abbr;
    }

    public void setRegion_abbr (String region_abbr)
    {
        this.region_abbr = region_abbr;
    }

    public String getVenue_name ()
    {
        return venue_name;
    }

    public void setVenue_name (String venue_name)
    {
        this.venue_name = venue_name;
    }

    public String getImage ()
{
    return image;
}

    public void setImage (String image)
    {
        this.image = image;
    }

    public String getCountry_abbr2 ()
    {
        return country_abbr2;
    }

    public void setCountry_abbr2 (String country_abbr2)
    {
        this.country_abbr2 = country_abbr2;
    }

    public String getCountry_name ()
    {
        return country_name;
    }

    public void setCountry_name (String country_name)
    {
        this.country_name = country_name;
    }

    public String getUrl ()
    {
        return url;
    }

    public void setUrl (String url)
    {
        this.url = url;
    }

    public String getVenue_type ()
    {
        return venue_type;
    }

    public void setVenue_type (String venue_type)
    {
        this.venue_type = venue_type;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getRegion_name ()
    {
        return region_name;
    }

    public void setRegion_name (String region_name)
    {
        this.region_name = region_name;
    }

    public String getCountry_abbr ()
    {
        return country_abbr;
    }

    public void setCountry_abbr (String country_abbr)
    {
        this.country_abbr = country_abbr;
    }

    public String getTimezone ()
{
    return timezone;
}

    public void setTimezone (String timezone)
    {
        this.timezone = timezone;
    }

    public String getCreated ()
{
    return created;
}

    public void setCreated (String created)
    {
        this.created = created;
    }

    public String getAddress ()
    {
        return address;
    }

    public void setAddress (String address)
    {
        this.address = address;
    }

    public String getDescription ()
{
    return description;
}

    public void setDescription (String description)
    {
        this.description = description;
    }

    public String getLink_count ()
    {
        return link_count;
    }

    public void setLink_count (String link_count)
    {
        this.link_count = link_count;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getPostal_code ()
    {
        return postal_code;
    }

    public void setPostal_code (String postal_code)
    {
        this.postal_code = postal_code;
    }

    public String getOwner ()
    {
        return owner;
    }

    public void setOwner (String owner)
    {
        this.owner = owner;
    }

    public String getGeocode_type ()
    {
        return geocode_type;
    }

    public void setGeocode_type (String geocode_type)
    {
        this.geocode_type = geocode_type;
    }

    public String getLongitude ()
    {
        return longitude;
    }

    public void setLongitude (String longitude)
    {
        this.longitude = longitude;
    }

    public String getLatitude ()
    {
        return latitude;
    }

    public void setLatitude (String latitude)
    {
        this.latitude = latitude;
    }

    public String getEvent_count ()
    {
        return event_count;
    }

    public void setEvent_count (String event_count)
    {
        this.event_count = event_count;
    }


    @Override
    public String toString()
    {
        return "ClassPojo [comment_count = "+comment_count+", trackback_count = "+trackback_count+", city_name = "+city_name+", region_abbr = "+region_abbr+", venue_name = "+venue_name+", image = "+image+", country_abbr2 = "+country_abbr2+", country_name = "+country_name+", url = "+url+", venue_type = "+venue_type+", id = "+id+", region_name = "+region_name+", country_abbr = "+country_abbr+", timezone = "+timezone+", created = "+created+", address = "+address+", description = "+description+", link_count = "+link_count+", name = "+name+", postal_code = "+postal_code+", owner = "+owner+", geocode_type = "+geocode_type+", longitude = "+longitude+", latitude = "+latitude+", event_count = "+event_count+"]";
    }

    public Venue(String venue_name, String address, String city_name, String region_abbr, String postal_code, String url ){
        this.venue_name = venue_name;
        this.address = address;
        this.city_name = city_name;
        this.region_abbr = region_abbr;
        this.postal_code = postal_code;
        this.url = url;
    }

    public Venue() {
    }
}
