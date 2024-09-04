package com.example.diningreview.controller;

import com.example.diningreview.model.Restaurant;
import com.example.diningreview.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(name = "/restaurants")
@RequiredArgsConstructor
public class RestaurantController {
    private final RestaurantRepository restaurantRepository;

    @GetMapping
    public Iterable<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    @GetMapping("/{id}")
    public Restaurant getRestaurantById(@PathVariable Long id) {
        Optional<Restaurant> restaurantOptional = restaurantRepository.findById(id);
        if (restaurantOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Restaurant not found");
        }

        return restaurantOptional.get();
    }

    @GetMapping("/search")
    public List<Restaurant> searchRestaurants(@RequestParam String zipcode, @RequestParam String allergy) {
        List<Restaurant> restaurants;
        switch (allergy) {
            case "dairy" -> restaurants = restaurantRepository.findAllByZipcodeAndDairyScoreNotNullOrderByDairyScore(zipcode);
            case "egg" -> restaurants = restaurantRepository.findAllByZipcodeAndEggScoreNotNullOrderByEggScore(zipcode);
            case "peanut" -> restaurants = restaurantRepository.findAllByZipcodeAndPeanutScoreNotNullOrderByPeanutScore(zipcode);
            default -> throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid allergy");
        }

        return restaurants;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createRestaurant(@RequestBody Restaurant restaurant) {
        Optional<Restaurant> restaurantOptional = restaurantRepository.findByNameAndZipcode(restaurant.getName(), restaurant.getZipcode());
        if (restaurantOptional.isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Restaurant already exists");
        }

        restaurantRepository.save(restaurant);
    }
}
