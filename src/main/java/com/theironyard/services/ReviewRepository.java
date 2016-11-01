package com.theironyard.services;

import com.theironyard.entities.Review;
import org.springframework.data.repository.CrudRepository;

public interface ReviewRepository extends CrudRepository<Review, Integer> {
}
