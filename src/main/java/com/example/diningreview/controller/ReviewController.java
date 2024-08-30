package com.example.diningreview.controller;

import com.example.diningreview.model.Review;
import com.example.diningreview.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping(name = "/reviews")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewRepository reviewRepository;

    @GetMapping
    public Iterable<Review> getAllDiningReviews() {
        return reviewRepository.findAll();
    }

    @GetMapping("/{id}")
    public Review getDiningReviewById(@PathVariable long id) {
        Optional<Review> diningReviewOptional = reviewRepository.findById(id);
        if (diningReviewOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        return diningReviewOptional.get();
    }
}
