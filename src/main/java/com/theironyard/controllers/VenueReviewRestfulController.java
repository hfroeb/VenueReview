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

    @CrossOrigin
    @RequestMapping(path = "/adminLogin", method = RequestMethod.GET)
    public User adminLogin(@RequestParam("email") String email, @RequestParam("password") String password, HttpSession session) {
        List<User> admins = users.findAllByAdmin(true);
        for (User user : admins) {
            if (email.equals(user.getEmail()) && password.equals(user.getPassword())) {
                session.setAttribute("admin", user.getAdmin());
                return user;
            }
        }
        return null;
    }

    @CrossOrigin
    @RequestMapping(path = "/users", method = RequestMethod.GET)
    public List<User> getUsers(HttpSession session) {
        List<User> retrievedUsers = (List<User>) users.findAll();
        return retrievedUsers;
    }

    @CrossOrigin
    @RequestMapping(path = "/reviews", method = RequestMethod.GET)
    public List<Review> getReviews(HttpSession session) {
        List<Review> reviewList = (List<Review>) reviews.findAll();
        return reviewList;
    }

    @CrossOrigin
    @RequestMapping(path = "/delete-user", method = RequestMethod.DELETE)
    public void deleteUser(@RequestParam("id") Integer id, HttpSession session) {
        {
            users.delete(id);
        }
    }

    @CrossOrigin
    @RequestMapping(path = "/delete-review", method = RequestMethod.DELETE)
    public void deleteReview(@RequestParam("id") Integer id, HttpSession session) {
        reviews.delete(id);

    }

    @CrossOrigin
    @RequestMapping(path = "/approve-review", method = RequestMethod.POST)
    public void approveReview(@RequestParam("id") Integer id, HttpSession session) {
        Review review = reviews.findOne(id);
        review.setApproved(true);
        reviews.save(review);
    }

//    @CrossOrigin
//    @RequestMapping(path="/adminLogout", method = RequestMethod.POST)
//    public void logout(HttpSession session){
//        session.invalidate();
//    }
//}
}
