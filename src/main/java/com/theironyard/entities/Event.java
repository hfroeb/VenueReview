package com.theironyard.entities;
import javax.persistence.*;

@Entity
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue
    int id;

    @Column(nullable = false)
    String eventName;

    @Column(nullable = false)
    String artists;

    @Column(nullable = false)
    String timeDate;

    @Column(nullable = false)
    String eventUrl;

    @Column(nullable = false)
    int eventRating;

    @ManyToOne
    Review eventReviews;

    @Column(nullable = false)
    Venue venue;

    public Event(String eventName, String artists, String timeDate, String eventUrl, int eventRating, Review eventReviews, Venue venue) {
        this.eventName = eventName;
        this.artists = artists;
        this.timeDate = timeDate;
        this.eventUrl = eventUrl;
        this.eventRating = eventRating;
        this.eventReviews = eventReviews;
        this.venue = venue;
    }

    public Event() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getArtists() {
        return artists;
    }

    public void setArtists(String artists) {
        this.artists = artists;
    }

    public String getTimeDate() {
        return timeDate;
    }

    public void setTimeDate(String timeDate) {
        this.timeDate = timeDate;
    }

    public String getEventUrl() {
        return eventUrl;
    }

    public void setEventUrl(String eventUrl) {
        this.eventUrl = eventUrl;
    }

    public int getEventRating() {
        return eventRating;
    }

    public void setEventRating(int eventRating) {
        this.eventRating = eventRating;
    }

    public Review getEventReviews() {
        return eventReviews;
    }

    public void setEventReviews(Review eventReviews) {
        this.eventReviews = eventReviews;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }
}
