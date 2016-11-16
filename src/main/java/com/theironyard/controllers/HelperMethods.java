package com.theironyard.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.theironyard.DisplayEvent;
import com.theironyard.DisplayVenue;
import com.theironyard.JsonObjects.Event.Event;
import com.theironyard.JsonObjects.Event.Image;
import com.theironyard.JsonObjects.Event.JsonEvent;
import com.theironyard.JsonObjects.Venue.Json1;
import com.theironyard.JsonObjects.Venue.Venue;

import com.theironyard.entities.Review;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Logger;

/**
 * Created by jakefroeb on 11/9/16.
 */

public class HelperMethods {

    private static final Logger LOGGER = Logger.getLogger(HelperMethods.class.getName());
    static Map<String, String> env = System.getenv();

    static String APIKEY = env.get("TICKETMASTER_APIKEY");

   // static String APIKEY = "IKno8NgrFkeJFS7hALKb9ol4o7wrZGfJ";

    public static List<DisplayVenue> createDisplayVenue(Venue[] venues) {
        List<DisplayVenue> showVenueList = new ArrayList<>();
        for (Venue venue : venues) {
            String id = venue.getId();

            String venue_name = venue.getName();
            if (venue_name == null) {
                venue_name = "venue name not found";
            }
            String address = venue.getAddress().getLine1();
            if (address == null) {
                address = "address not found";
            }
            String city_name = venue.getCity().getName();
            if (city_name == null) {
                city_name = "city not found";
            }
            String region_abbr = venue.getState().getStateCode();
            if (region_abbr == null) {
                region_abbr = "state abbr. not found";
            }
            String postal_code = venue.getPostalCode();
            if (postal_code == null) {
                postal_code = "zip code not found";
            }
            String url = venue.getUrl();
            if (url == null) {
                url = "url not found";
            }
            DisplayVenue showVenue = new DisplayVenue(id, venue_name, address, city_name, region_abbr, postal_code, url);
            showVenueList.add(showVenue);
        }
        return showVenueList;
    }

    public static Event[] retrieveEvents(String id) throws Exception {
        LOGGER.info("APIKEY=" + APIKEY);
        String jsonEventResults = "";
        String urlString = String.format("https://app.ticketmaster.com/discovery/v2/events.json?venueId=" + id + "&apikey=" + APIKEY);
        URL url = new URL(urlString);

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();
        int responseCode = conn.getResponseCode();
        if (responseCode != 200) {
            throw new RuntimeException("ERROR Http ResponseCode: " + responseCode);
        } else {
            Scanner scanner = new Scanner(url.openStream());
            while (scanner.hasNext()) {
                jsonEventResults += scanner.nextLine();
            }
            scanner.close();
        }
        ObjectMapper mapper = new ObjectMapper();
        JsonEvent searchResults = mapper.readValue(jsonEventResults, JsonEvent.class);
        Event[] events = searchResults.get_embedded().getEvents();
        return events;
    }

    public static List<DisplayEvent> createDisplayEventList(Event[] events) throws ParseException {
        List<DisplayEvent> displayEvents = new ArrayList<>();
        for (Event event : events) {
            String name = event.getName();
            if (name == null) {
                name = "name not found";
            }
            String type = event.getType();
            if (type == null) {
                type = "type not found";
            }
            String startDate = event.getDates().getStart().getLocalDate();
            if (startDate.equals("")) {
                startDate = "date not found";
            } else {
                startDate = convertDate(startDate);
            }
            String time = event.getDates().getStart().getLocalTime();
            if (time == null || time.equals("")) {
                time = "start time not found";
            } else {
                time = convertTime(time);
            }

            String eventUrl = event.getUrl();
            if (eventUrl == null) {
                eventUrl = "url not found";
            }
            Image image = event.getImages().get(0);
            if (image == null) {
                image = new Image();
            }
            String imageUrl = image.getUrl();
            if (imageUrl == null) {
                imageUrl = "image not found";
            }
            DisplayEvent displayEvent = new DisplayEvent(name, type, startDate, time, eventUrl, imageUrl);
            displayEvents.add(displayEvent);
        }
        return displayEvents;
    }

    public static int getAverageRating(List<Review> displayReviews) {
        int averageRating = 0;
        for (Review review : displayReviews) {
            int rating = review.getRating();
            averageRating += rating;
        }
        return averageRating;
    }

    public static Venue[] retrieveVenues(String input) throws Exception {
        String jsonResults = "";
        String encoded = URLEncoder.encode(input, "UTF-8");
        String urlString = String.format("https://app.ticketmaster.com/discovery/v2/venues.json?keyword="
                + encoded + "&apikey=" + APIKEY);
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();
        int responseCode = conn.getResponseCode();
        if (responseCode != 200) {
            throw new RuntimeException("ERROR Http ResponseCode: " + responseCode);
        } else {
            Scanner scanner = new Scanner(url.openStream());
            while (scanner.hasNext()) {
                jsonResults += scanner.nextLine();
            }
            scanner.close();
        }
        ObjectMapper mapper = new ObjectMapper();
        Json1 searchResults = mapper.readValue(jsonResults, Json1.class);
        Venue[] venues = searchResults.get_embedded().getVenues();
        return venues;
    }
    public static String convertTime(String time){
        String displayTime;
        String[] columns = time.split(":");
        String standardTime1 = columns[0] + columns[1];
        int standardTime = (Integer.parseInt(standardTime1));
        if (standardTime == 1200){
            displayTime = "12:00 PM";
        }
        else if (standardTime == 2400){
            displayTime = "12:00 AM";
        }
        else if (standardTime > 1200) {
            standardTime = standardTime - 1200;
            displayTime = Integer.toString(standardTime);
            if (displayTime.length() > 3) {
                displayTime = displayTime.substring(0, 2) + ":" + displayTime.substring(2, displayTime.length());
                displayTime = displayTime + " PM";
            } else {
                displayTime = displayTime.substring(0, 1) + ":" + displayTime.substring(1, displayTime.length());
                displayTime = displayTime + " PM";
            }
        }
        else {
            displayTime = Integer.toString(standardTime);
            if (displayTime.length() > 3) {
                displayTime = displayTime.substring(0, 2) + ":" + displayTime.substring(2, displayTime.length());
                displayTime = displayTime + " AM";
            } else {
                displayTime = displayTime.substring(0, 1) + ":" + displayTime.substring(1, displayTime.length());
                displayTime = displayTime + " AM";
            }
    }
    return displayTime;
}
    public static String convertDate(String date) throws ParseException {
        String[] columns = date.split("-");
        String dateFormat = columns[2] + "/" + columns[1] + "/" + columns[0];
        SimpleDateFormat newDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date1 = newDateFormat.parse(dateFormat);
        newDateFormat.applyPattern("EEEE, MMM d, yyyy");
        String newDate = newDateFormat.format(date1);
        return newDate;
    }

    public static String starReview(int rating){
        String starRating;
        switch (rating) {
            case 1: {
                starRating = "★☆☆☆☆";
                break;
            }
            case 2: {
                starRating = "★★☆☆☆";
                break;
            }
            case 3: {
                starRating = "★★★☆☆";
                break;
            }
            case 4: {
                starRating = "★★★★☆";
                break;
            }
            case 5: {
                starRating = "★★★★★";
                break;
            }
            default: starRating = "";
        }
        return starRating;
    }
}

