package com.example.diningreview.repository;

import com.example.diningreview.model.Review;
import com.example.diningreview.model.Status;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReviewRepository extends CrudRepository<Review, Long> {
    List<Review> findAllByStatus(Status status);
    List<Review> findAllByRestaurantIdAndStatus(Long restaurantId, Status status);
}
