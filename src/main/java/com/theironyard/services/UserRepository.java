package com.theironyard.services;

import com.theironyard.entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by jakefroeb on 11/3/16.
 */
public interface UserRepository extends CrudRepository<User,Integer>{
    User findFirstByEmail(String email);
    User findFirstByName(String name);
    List<User> findAllByAdmin(Boolean admin);
}
