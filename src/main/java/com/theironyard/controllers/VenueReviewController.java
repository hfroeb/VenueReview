package com.theironyard.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.theironyard.DisplayEvent;
import com.theironyard.DisplayVenue;
import com.theironyard.JsonObjects.Event.Event;
import com.theironyard.JsonObjects.Event.JsonEvent;
import com.theironyard.JsonObjects.Venue.Json1;
import com.theironyard.JsonObjects.Venue.Venue;
import com.theironyard.entities.Review;
import com.theironyard.entities.User;
import com.theironyard.services.ReviewRepository;
import com.theironyard.services.UserRepository;
import com.theironyard.utilities.PasswordStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by halleyfroeb on 11/1/16.
 * User(String username, String password, String email)
 */
@Controller
public class VenueReviewController {
    public static String warning;
    @Autowired
    UserRepository users;
    @Autowired
    ReviewRepository reviews;

    @RequestMapping(path = "/", method = RequestMethod.GET)
        public String get(HttpSession session, Model model)throws Exception{
        List<DisplayVenue> showVenueList = new ArrayList<>();
        String jsonResults = (String) session.getAttribute("jsonResults");
        if( jsonResults == null || jsonResults.equals("")){
            model.addAttribute("venueList", "");
        }else {

            ObjectMapper mapper = new ObjectMapper();
            Json1 searchResults = mapper.readValue(jsonResults, Json1.class);

            Venue[] venues = searchResults.get_embedded().getVenues();

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
        }
        System.out.println();
            User user = users.findFirstByEmail((String) session.getAttribute("email"));
            session.setAttribute("venueList", showVenueList);
            model.addAttribute("user", user);
            model.addAttribute("venueList", showVenueList);

        return "home";
    }

    @RequestMapping(path = "/search", method = RequestMethod.POST)
    public String search(HttpSession session, String userInput) throws IOException {

        String jsonResults = "";
        if (userInput.contains(" ")) {
        }

        String urlString = String.format("https://app.ticketmaster.com/discovery/v2/venues.json?keyword=" + userInput + "&apikey=IKno8NgrFkeJFS7hALKb9ol4o7wrZGfJ");
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

        session.setAttribute("jsonResults", jsonResults);
        return "redirect:/";
    }
    @RequestMapping(path = "/venue-page", method = RequestMethod.GET)
    public String venueReviews(HttpSession session, Model model) throws Exception {
        String jsonEventResults = "";
        List<DisplayVenue> showVenueList = (List) session.getAttribute("venueList");
        List<DisplayEvent> eventDisplayList = new ArrayList<>();
        DisplayVenue currentVenue = new DisplayVenue();
        String id = (String) session.getAttribute("id");
        System.out.println(id);
        for (DisplayVenue venue : showVenueList) {
            if (id.equals(venue.id)) {
                currentVenue = venue;
            }
        }
        String urlString = String.format("https://app.ticketmaster.com/discovery/v2/events.json?venueId=" + id + "&apikey=IKno8NgrFkeJFS7hALKb9ol4o7wrZGfJ");
        System.out.println(urlString);
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
        if(jsonEventResults.equals("") || jsonEventResults==null){
        }else {
            ObjectMapper mapper = new ObjectMapper();
            JsonEvent searchResults = mapper.readValue(jsonEventResults, JsonEvent.class);
            Event[] events = searchResults.get_embedded().getEvents();
            for (Event event:events) {
                String name = event.getName();
                if (name == null) {
                    name = "name not found";
                }
                String type = event.getType();
                if (type == null) {
                    type = "type not found";
                }
                String startDate = event.getDates().getStart().getLocalDate();
                if (startDate == null) {
                    startDate = "date not found";
                }
                String time = event.getDates().getStart().getLocalTime();
                if (time == null) {
                    time = "start time not found";
                }
                String eventUrl = event.getUrl();
                if (eventUrl == null) {
                    eventUrl = "url not found";
                }
//                String name, String type, String description, String startDate, String time, String endDate, String url
                DisplayEvent displayEvent = new DisplayEvent(name,type,startDate,time,urlString);
                eventDisplayList.add(displayEvent);
                System.out.println(event.getName());
            }
        }
        List<Review> displayReviews = reviews.findAllByVenueId(id);
        model.addAttribute("reviews", displayReviews);
        model.addAttribute("events", eventDisplayList);
        model.addAttribute("venue", currentVenue);
        return "/venue-page";
    }

    @RequestMapping(path = "/create-review", method = RequestMethod.POST)
    public String createReview(HttpSession session, String rating, String text){
        String email = (String) session.getAttribute("email");
        User user = users.findFirstByEmail(email);
        String id = (String) session.getAttribute("id");
        Review review = new Review(text,Integer.parseInt(rating),user,id);
        reviews.save(review);
        return "redirect:/venue-page";
    }
    @RequestMapping(path = "/venue-page", method = RequestMethod.POST)
    public String venuePage(HttpSession session, String id){
        System.out.println(id);
        session.setAttribute("id", id);
        return "redirect:/venue-page";
    }

    @RequestMapping(path = "/registration", method = RequestMethod.GET)
    public String registration(){
        return "/registration";
    }

    @RequestMapping(path = "/sign-up", method = RequestMethod.POST)
    public String signUp(){
        return "redirect:/registration";
    }

    @RequestMapping(path = "/create-user", method = RequestMethod.POST)
    public String createUser(String name,String password,String email)throws Exception{
        User user = users.findFirstByEmail(email);
        User nameCheck = users.findFirstByName(name);
        if(user != null){
            warning = "email already has an account";
        }else if (nameCheck != null) {
            warning = "name has been taken";
        }else{
                user = new User(name,PasswordStorage.createHash(password),email);
                users.save(user);
            }

        return "redirect:/";
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(HttpSession session, String email, String password)throws Exception{
        System.out.println("logging in");
        User user = users.findFirstByEmail(email);
        if(user == null){
            System.out.println( "no user with that email");
        }else if (!PasswordStorage.verifyPassword(password, user.getPassword())){
            System.out.println("incorrect password");
        }else {
            System.out.println("user added");
            session.setAttribute("email", email);
        }
        return "redirect:/";
    }

    @RequestMapping(path = "/logout", method = RequestMethod.POST)
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }



}
