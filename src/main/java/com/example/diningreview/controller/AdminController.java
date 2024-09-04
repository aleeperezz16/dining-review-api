package com.example.diningreview.controller;

import com.example.diningreview.model.AdminReviewAction;
import com.example.diningreview.model.Restaurant;
import com.example.diningreview.model.Review;
import com.example.diningreview.model.ReviewStatus;
import com.example.diningreview.repository.RestaurantRepository;
import com.example.diningreview.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {
    private final ReviewRepository reviewRepository;
    private final RestaurantRepository restaurantRepository;

    @GetMapping("/pending-reviews")
    public List<Review> getPendingReviews() {
        return reviewRepository.findAllByStatus(ReviewStatus.PENDING);
    }

    @PutMapping("/review-action/{id}")
    public void acceptReview(@PathVariable Long id, @RequestBody AdminReviewAction action) {
        Optional<Review> reviewOptional = reviewRepository.findById(id);
        if (reviewOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Review not found");
        }

        if (ObjectUtils.isEmpty(action.getApproved())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Approved is empty");
        }

        Review review = reviewOptional.get();
        review.setStatus(action.getApproved() ? ReviewStatus.APPROVED : ReviewStatus.REJECTED);

        if (action.getApproved()) {
        }

        reviewRepository.save(review);
    }
}
