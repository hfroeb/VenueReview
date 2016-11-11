package com.theironyard.controllers;

import com.theironyard.entities.User;
import com.theironyard.services.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by jakefroeb on 11/11/16.
 */
@RestController
public class VenueReviewRestfulController {

    @Autowired
    UserRepository users;

    @RequestMapping(path="/adminLogin",method = RequestMethod.GET)
    public User adminLogin(@RequestParam("email") String email,@RequestParam("password") String password){
        List<User> admins = users.findAllByAdmin(true);
        for (User user: admins) {
            if(email.equals(user.getEmail())&& password.equals(user.getPassword())){
                return user;
            }
        }
        return null;
    }
    
    @RequestMapping(path="/users", method = RequestMethod.GET)
    public List<User> getUsers(){
        List<User> retrievingUsers = (List<User>) users.findAll();
        return retrievingUsers;
    }












}
