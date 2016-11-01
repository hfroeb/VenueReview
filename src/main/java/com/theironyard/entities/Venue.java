package com.theironyard.entities;
import javax.persistence.*;

@Entity
@Table(name = "venues")
public class Venue {
    @Id
    @GeneratedValue
    int id;

    @Column(nullable = false)
    String venueName;

    @Column(nullable = false)
    String location;

    @Column(nullable = false)
    String websiteUrl;

    @Column(nullable = false)
    int avgRating;

    @ManyToOne
    Review venueReviews;

    @ManyToOne
    Event events;

    public Venue(String venueName, String location, String websiteUrl, int avgRating, Review venueReviews, Event events) {
        this.venueName = venueName;
        this.location = location;
        this.websiteUrl = websiteUrl;
        this.avgRating = avgRating;
        this.venueReviews = venueReviews;
        this.events = events;
    }

    public Venue() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVenueName() {
        return venueName;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

    public int getAvgRating() {
        return avgRating;
    }

    public void setAvgRating(int avgRating) {
        this.avgRating = avgRating;
    }

    public Review getVenueReviews() {
        return venueReviews;
    }

    public void setVenueReviews(Review venueReviews) {
        this.venueReviews = venueReviews;
    }

    public Event getEvents() {
        return events;
    }

    public void setEvents(Event events) {
        this.events = events;
    }
}
