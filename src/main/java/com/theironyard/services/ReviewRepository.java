package com.theironyard.services;

import com.theironyard.entities.Review;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by halleyfroeb on 11/9/16.
 */
public interface ReviewRepository extends CrudRepository<Review, Integer> {
    List<Review> findAllByVenueId(String venueId);
}
