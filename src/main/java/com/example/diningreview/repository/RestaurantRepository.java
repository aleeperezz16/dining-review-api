package com.example.diningreview.repository;

import com.example.diningreview.model.Restaurant;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface RestaurantRepository extends CrudRepository<Restaurant, Long> {
    Optional<Restaurant> findByNameAndZipcode(String name, String zipcode);
    List<Restaurant> findAllByZipcodeAndEggScoreIsNotNullOrderByEggScoreDesc(String zipcode);
    List<Restaurant> findAllByZipcodeAndPeanutScoreIsNotNullOrderByPeanutScoreDesc(String zipcode);
    List<Restaurant> findAllByZipcodeAndDairyScoreIsNotNullOrderByDairyScoreDesc(String zipcode);
}
