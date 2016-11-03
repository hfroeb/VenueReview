package com.theironyard.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
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


    @RequestMapping(path = "/", method = RequestMethod.GET)
        public String get(HttpSession session, Model model)throws Exception{

        String jsonResults = (String) session.getAttribute("jsonResults");
        if( jsonResults == null || jsonResults.equals("")){
            model.addAttribute("jsonResults", "");

        }else {

            ObjectMapper mapper = new ObjectMapper();
            JsonVenue searchResults = mapper.readValue(jsonResults,JsonVenue.class);
            Venue[] venue = searchResults.getVenues().getVenue();
            Venue venue1 = venue[0];
            String venues = venue1.toString();
            model.addAttribute("jsonResults", venues);
        }
        return "home";
    }

    @RequestMapping(path = "/search", method = RequestMethod.POST)
    public String search(HttpSession session, String userInput) throws IOException {

        String jsonResults = "";
        if (userInput.contains(" ")) {
        }
//        String encoded = URLEncoder.encode(userInput, "UTF-8");


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



}
