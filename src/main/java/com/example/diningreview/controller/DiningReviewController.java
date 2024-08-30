package com.example.diningreview.controller;

import com.example.diningreview.model.DiningReview;
import com.example.diningreview.repository.DiningReviewRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping(name = "/dining-review")
@AllArgsConstructor
public class DiningReviewController {
    private final DiningReviewRepository diningReviewRepository;

    @GetMapping
    public Iterable<DiningReview> getAllDiningReviews() {
        return diningReviewRepository.findAll();
    }

    @GetMapping("/{id}")
    public DiningReview getDiningReviewById(@PathVariable long id) {
        Optional<DiningReview> diningReviewOptional = diningReviewRepository.findById(id);
        if (diningReviewOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        return diningReviewOptional.get();
    }
}
