package com.theironyard.controllers;

import com.theironyard.DisplayEvent;
import com.theironyard.DisplayVenue;
import com.theironyard.JsonObjects.Event.Event;
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
import java.util.ArrayList;
import java.util.List;

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
    public String get(HttpSession session, Model model) throws Exception {
        Venue[] venues = (Venue[]) session.getAttribute("venues");
        if (venues==null){
            return "home";
        }
        List<DisplayVenue> showVenueList = HelperMethods.createDisplayVenue(venues);
        User user = users.findFirstByEmail((String) session.getAttribute("email"));
        session.setAttribute("venueList", showVenueList);
        model.addAttribute("user", user);
        model.addAttribute("venueList", showVenueList);
        return "home";
    }


    @RequestMapping(path = "/search", method = RequestMethod.POST)
    public String search(HttpSession session, String userInput) throws Exception {
        Venue[] venues = HelperMethods.retrieveVenues(userInput);
        session.setAttribute("userInput", userInput);
        session.setAttribute("venues", venues);
        return "redirect:/";
    }

    @RequestMapping(path = "/venue-page", method = RequestMethod.GET)
    public String venueReviews(HttpSession session, Model model) throws Exception {
        List<DisplayVenue> showVenueList = (List) session.getAttribute("venueList");
        DisplayVenue currentVenue = new DisplayVenue();
        String id = (String) session.getAttribute("id");
        for (DisplayVenue venue : showVenueList) {
            if (id.equals(venue.id)) {
                currentVenue = venue;
            }
        }

        Event[] events = HelperMethods.retrieveEvents(id);
        List<DisplayEvent> eventDisplayList = HelperMethods.createDisplayEventList(events);
        User user = users.findFirstByEmail((String) session.getAttribute("email"));
        List<Review> displayReviews = reviews.findAllByVenueId(id);
        List<Review> displayReviewStars = new ArrayList<>();
        for (Review review: displayReviews){
            int rating = review.getRating();
            String starRating = HelperMethods.starReview(rating);
            Review review1 = new Review(review.getText(), review.getRating(), review.getUser(), review.getVenueId(), starRating);
            displayReviewStars.add(review1);
        }
        int averageRating = HelperMethods.getAverageRating(displayReviews);
        String averageStarRating = "";
        if(displayReviews.size()==0){averageStarRating= "";}
        else {
            averageRating = averageRating / displayReviews.size();
            averageStarRating = HelperMethods.starReview(averageRating);
        }
        model.addAttribute("userInput", session.getAttribute("userInput"));
        model.addAttribute("averageRating", averageStarRating);
        model.addAttribute("user", user);
        model.addAttribute("reviews", displayReviewStars);
        model.addAttribute("events", eventDisplayList);
        model.addAttribute("venue", currentVenue);
        return "/venue-page";
    }


    @RequestMapping(path = "/create-review", method = RequestMethod.POST)
    public String createReview(HttpSession session, String rating, String text, Model model) {
        String email = (String) session.getAttribute("email");
        User user = users.findFirstByEmail(email);
        String id = (String) session.getAttribute("id");
        Review review = new Review(text, Integer.parseInt(rating), user, id);
        reviews.save(review);
        return "redirect:/venue-page";
    }

    @RequestMapping(path = "/venue-page", method = RequestMethod.POST)
    public String venuePage(HttpSession session, String id) {
        System.out.println(id);
        session.setAttribute("id", id);
        return "redirect:/venue-page";
    }

    @RequestMapping(path = "/registration", method = RequestMethod.GET)
    public String registration() {
        return "/registration";
    }

    @RequestMapping(path = "/sign-up", method = RequestMethod.POST)
    public String signUp() {
        return "redirect:/registration";
    }

    @RequestMapping(path = "/create-user", method = RequestMethod.POST)
    public String createUser(String name, String password, String email) throws Exception {
        User user = users.findFirstByEmail(email);
        User nameCheck = users.findFirstByName(name);
        if (user != null) {
            warning = "email already has an account";
        } else if (nameCheck != null) {
            warning = "name has been taken";
        } else {
            user = new User(name, PasswordStorage.createHash(password), email);
            users.save(user);
        }
        return "redirect:/";
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(HttpSession session, String email, String password, String route) throws Exception {
        User user = users.findFirstByEmail(email);
        if (user == null) {
            System.out.println("no user with that email");
        } else if (!PasswordStorage.verifyPassword(password, user.getPassword())) {
            System.out.println("incorrect password");
        } else {
            session.setAttribute("email", email);
        }
        return "redirect:" + route;
    }

    @RequestMapping(path = "/logout", method = RequestMethod.POST)
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

    @RequestMapping(path = "/home", method = RequestMethod.POST)
    public String returnHome(){
        return "home";
    }
}
