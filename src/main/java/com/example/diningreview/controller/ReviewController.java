package com.example.diningreview.controller;

import com.example.diningreview.model.Restaurant;
import com.example.diningreview.model.Review;
import com.example.diningreview.model.User;
import com.example.diningreview.repository.RestaurantRepository;
import com.example.diningreview.repository.ReviewRepository;
import com.example.diningreview.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping(name = "/reviews")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final RestaurantRepository restaurantRepository;

    @GetMapping
    public Iterable<Review> getReviews() {
        return reviewRepository.findAll();
    }

    @GetMapping("/{id}")
    public Review getReview(@PathVariable Long id) {
        Optional<Review> review = reviewRepository.findById(id);
        if (review.isPresent()) {
            return review.get();
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Review not found");
    }

    @PostMapping("/submit")
    @ResponseStatus(HttpStatus.CREATED)
    public void submitReview(@RequestBody Review review) {
        Optional<User> userOptional = userRepository.findByDisplayName(review.getSubmitterName());
        if (userOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }

        Optional<Restaurant> restaurantOptional = restaurantRepository.findById(review.getRestaurantId());
        if (restaurantOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Restaurant not found");
        }

        reviewRepository.save(review);
    }
}
