package com.theironyard.JsonObjects;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class JsonVenue1
{
    private String city_name;

    private String region_abbr;

    private String venue_name;

    private String url;

    private String id;

    private String region_name;

    private String address;

    private String postal_code;


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


    public String getUrl ()
    {
        return url;
    }

    public void setUrl (String url)
    {
        this.url = url;
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


    public String getAddress ()
    {
        return address;
    }

    public void setAddress (String address)
    {
        this.address = address;
    }


    public String getPostal_code ()
    {
        return postal_code;
    }

    public void setPostal_code (String postal_code)
    {
        this.postal_code = postal_code;
    }


    public JsonVenue1(String id, String venue_name, String address, String city_name, String region_abbr, String postal_code, String url ){
        this.id = id;
        this.venue_name = venue_name;
        this.address = address;
        this.city_name = city_name;
        this.region_abbr = region_abbr;
        this.postal_code = postal_code;
        this.url = url;
    }

    public JsonVenue1() {
    }
}
