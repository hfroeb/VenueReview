package com.theironyard.controllers;

import com.theironyard.entities.Review;
import com.theironyard.entities.User;
import com.theironyard.services.ReviewRepository;
import com.theironyard.services.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by jakefroeb on 11/11/16.
 */
@RestController
public class VenueReviewRestfulController {

    @Autowired
    UserRepository users;
    @Autowired
    ReviewRepository reviews;

    @CrossOrigin(origins = "http://localhost:9000")
    @RequestMapping(path="/adminLogin",method = RequestMethod.GET)
    public User adminLogin(@RequestParam("email") String email, @RequestParam("password") String password, HttpSession session){
        List<User> admins = users.findAllByAdmin(true);
        for (User user: admins) {
            if(email.equals(user.getEmail())&& password.equals(user.getPassword())){
                session.setAttribute("user", user);
                return user;
            }
        }
        return null;
    }
    @CrossOrigin
    @RequestMapping(path="/users", method = RequestMethod.GET)
    public List<User> getUsers(HttpSession session){
//        if(session.getAttribute("user")==null){
//            return null;
//        }
        List<User> retrievedUsers = (List<User>) users.findAll();
        return retrievedUsers;
    }

    @RequestMapping(path="/reviews", method = RequestMethod.GET)
    public List<Review> getReviews(HttpSession session){
        if(session.getAttribute("user")==null){
            return null;
        }
        List<Review> reviewList = (List<Review>) reviews.findAll();
        return reviewList;
    }

    @RequestMapping(path="/delete-user", method = RequestMethod.POST)
    public void deleteUser(@RequestParam("id") Integer id,HttpSession session){
        if(session.getAttribute("user")==null){
        }else {
            users.delete(id);
        }
    }

    @RequestMapping(path="/delete-review", method = RequestMethod.POST)
    public void deleteReview(@RequestParam("id") Integer id, HttpSession session){
        if(session.getAttribute("user")==null){

        }else {
            reviews.delete(id);
        }
    }
    @RequestMapping(path="/adminLogout", method = RequestMethod.POST)
    public void logout(HttpSession session){
        session.invalidate();
    }


}
