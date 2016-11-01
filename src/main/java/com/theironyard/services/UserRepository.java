package com.theironyard.services;

import com.theironyard.entities.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by halleyfroeb on 11/1/16.
 */
public interface UserRepository extends CrudRepository<User, Integer> {
    User findFirstByUsername(String username);
}
