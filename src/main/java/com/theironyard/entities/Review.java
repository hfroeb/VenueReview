package com.theironyard.entities;

import javax.persistence.*;

/**
 * Created by halleyfroeb on 11/1/16.
 */
@Entity
@Table(name = "reviews")
public class Review {
    @Id
    @GeneratedValue
    int id;

    @ManyToOne
    User author;

    @ManyToOne
    int eventfulKey;

    @Column(nullable = false)
    String reviewText;

    @Column(nullable = false)
    int rating;

    public Review(User author, int eventfulKey, String reviewText, int rating) {
        this.author = author;
        this.eventfulKey = eventfulKey;
        this.reviewText = reviewText;
        this.rating = rating;
    }

    public Review() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public int getEventfulKey() {
        return eventfulKey;
    }

    public void setEventfulKey(int eventfulKey) {
        this.eventfulKey = eventfulKey;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
