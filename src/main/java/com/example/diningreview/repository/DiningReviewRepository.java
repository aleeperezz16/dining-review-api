package com.example.diningreview.repository;

import com.example.diningreview.model.DiningReview;
import com.example.diningreview.model.Status;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DiningReviewRepository extends CrudRepository<DiningReview, Long> {
    List<DiningReview> findAllByStatus(Status status);
    List<DiningReview> findAllByRestaurantIdAndStatus(long restaurantId, Status status);
}
