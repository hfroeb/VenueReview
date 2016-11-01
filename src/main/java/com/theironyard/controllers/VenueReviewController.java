package com.theironyard.controllers;

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
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by halleyfroeb on 11/1/16.
 * User(String username, String password, String email)
 * Review(User author, int eventfulKey, String reviewText, int rating)
 */
@Controller
public class VenueReviewController {
    @Autowired
    UserRepository users;

    @Autowired
    ReviewRepository reviews;

    @RequestMapping(path = "/search", method = RequestMethod.POST)
    public String search(Model model, HttpSession session, String userInput) throws IOException {

        String jsonResults = "";
        if (userInput.contains(" ")) {
        }
        String encoded = URLEncoder.encode(userInput, "UTF-8");
        URL url = new URL("http://api.eventful.com/rest/venues/search?...&keywords=Restaurant&location=San+Diego")
                //http://api.eventful.com/json/events/search?...&location=San+Diego
        //http://api.eventful.com/rest/venues/search?...&keywords=Restaurant&location=San+Diego
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(String username, String password, String email, HttpSession session) throws Exception {
        User user = users.findFirstByUsername(username);
        if (user == null) {
            user = new User(username, PasswordStorage.createHash(password), email);
            users.save(user);
        } else if (!PasswordStorage.verifyPassword(password, user.getPassword())) {
            throw new Exception("wrong password");
        }
        session.setAttribute("username", username);
        return "redirect:/";
    }

    @RequestMapping(path = "/logout")
    public String logout(HttpSession session) throws IOException {
        session.invalidate();
        return "redirect:/";
    }

}
