package com.theironyard.JsonObjects.Event;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Event {
    private String name;
    private String type;
    private String id;
    private String url;
    private Dates dates;
    private List<Image> images;

    public List<Image> getImages() {
        if (images == null) {
            List<Image> images = new ArrayList<>();
            Image image = new Image();
            images.add(image);
            return images;
        } else
            return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Dates getDates() {
        if (dates == null)
            return new Dates();
        else
            return dates;
    }

    public void setDates(Dates dates) {
        this.dates = dates;
    }
}
