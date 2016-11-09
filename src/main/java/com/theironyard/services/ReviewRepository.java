package com.theironyard.services;

import com.theironyard.entities.Review;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by halleyfroeb on 11/9/16.
 */
public interface ReviewRepository extends CrudRepository<Review, Integer> {
}
