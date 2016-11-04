package com.theironyard.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.theironyard.JsonObjects.JsonVenue;
import com.theironyard.JsonObjects.JsonVenue1;
import com.theironyard.entities.User;
import com.theironyard.services.UserRepository;
import com.theironyard.utilities.PasswordStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
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
 * Review(User author, int eventfulKey, String reviewText, int rating)
 *
 * http://api.eventful.com/json/events/search?...&location=San+Diego
    http://api.eventful.com/rest/venues/search?...&keywords=Restaurant&location=San+Diego
 */
@Controller
public class VenueReviewController {
    String warning;
    @Autowired
    UserRepository users;

    @RequestMapping(path = "/", method = RequestMethod.GET)
        public String get(HttpSession session, Model model)throws Exception{

        String jsonResults = (String) session.getAttribute("jsonResults");
        if( jsonResults == null || jsonResults.equals("")){
            model.addAttribute("venueList", "");
        }else {

            ObjectMapper mapper = new ObjectMapper();
            JsonVenue searchResults = mapper.readValue(jsonResults,JsonVenue.class);
            JsonVenue1[] venues = searchResults.getVenues().getVenue();
            List<JsonVenue1> showVenueList = new ArrayList<>();
            for (JsonVenue1 venue1: venues){
                String id = venue1.getId();

                String venue_name = venue1.getVenue_name();
                if (venue_name == null){
                    venue_name = "venue name not found";
                }
                String address = venue1.getAddress();
                if (address == null){
                    address = "address not found";
                }
                String city_name = venue1.getCity_name();
                if (city_name == null){
                    city_name = "city not found";
                }
                String region_abbr = venue1.getRegion_abbr();
                if (region_abbr == null){
                    region_abbr = "state abbr. not found";
                }
                String postal_code = venue1.getPostal_code();
                if (postal_code == null){
                    postal_code = "zip code not found";
                }
                String url = venue1.getUrl();
                if (url == null){
                    url = "url not found";
                }
                JsonVenue1 showVenue = new JsonVenue1(id, venue_name, address, city_name, region_abbr, postal_code, url);
                showVenueList.add(showVenue);
            }
            User user = (User) session.getAttribute("user");
            session.setAttribute("venueList", showVenueList);
            model.addAttribute("user", user);
            model.addAttribute("venueList", showVenueList);
        }
        return "home";
    }

    @RequestMapping(path = "/search", method = RequestMethod.POST)
    public String search(HttpSession session, String userInput) throws IOException {

        String jsonResults = "";
        if (userInput.contains(" ")) {
        }

        String urlString = String.format("http://api.eventful.com/json/venues/search?keywords=" + userInput + "&app_key=chMBShbTQXXRkhwb");
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
    @RequestMapping(path = "venue-page", method = RequestMethod.GET)
    public String venueReviews(HttpSession session, Model model) {
        List<JsonVenue1> showVenueList = (List) session.getAttribute("venueList");
        JsonVenue1 currentVenue = new JsonVenue1();
        String id = (String) session.getAttribute("id");
        for (JsonVenue1 venue : showVenueList) {
            if (id.equals(venue.getId())) {
                currentVenue = venue;
            }
        }
        model.addAttribute("venue", currentVenue);
        return "/venue-page";


    }
    @RequestMapping(path = "venue-page", method = RequestMethod.POST)
    public String venuePage(HttpSession session, String id, Model model){
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
    public String createUser(String name,String password,String email){
        User user = users.findFirstByEmail(email);
        if(user != null){
            warning = "email already has an account";
        }else{
            user = new User(name,password,email);
            users.save(user);
        }
        return "redirect:/";
    }
    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(HttpSession session, String email, String password)throws Exception{
        User user = users.findFirstByEmail(email);
        if(user == null){
            warning = "no user with that email";
        }else if (!PasswordStorage.verifyPassword(password, user.getPassword())){
            warning = "incorrect password";
        }else {
            session.setAttribute("user", user);
        }
        return "";
    }
    @RequestMapping(path = "/logout", method = RequestMethod.POST)
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }



}
