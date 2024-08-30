package com.example.diningreview.controller;

import com.example.diningreview.model.Restaurant;
import com.example.diningreview.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

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
    public Restaurant getRestaurantById(@PathVariable long id) {
        Optional<Restaurant> restaurantOptional = restaurantRepository.findById(id);
        if (restaurantOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        return restaurantOptional.get();
    }
}
