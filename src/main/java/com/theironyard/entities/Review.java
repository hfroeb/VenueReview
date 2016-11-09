package com.theironyard.entities;

import javax.persistence.*;

/**
 * Created by halleyfroeb on 11/9/16.
 */
@Entity
@Table(name = "reviews")
public class Review {

    @Id
    @GeneratedValue
    int id;

    @Column(nullable = false)
    String text;

    @Column
    int rating;

    @ManyToOne
    User user;

    @Column(nullable = false)
    int apiKey;

    public Review(String text, int rating, User user, int apiKey) {
        this.text = text;
        this.rating = rating;
        this.user = user;
        this.apiKey = apiKey;
    }

    public Review() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getApiKey() {
        return apiKey;
    }

    public void setApiKey(int apiKey) {
        this.apiKey = apiKey;
    }
}
