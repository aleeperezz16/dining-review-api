package com.example.diningreview.controller;

import com.example.diningreview.model.User;
import com.example.diningreview.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping(name = "/user")
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;

    @GetMapping
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/{displayName}")
    public User getUserByDisplayName(@PathVariable String displayName) {
        Optional<User> userOptional = userRepository.findByDisplayName(displayName);
        if (userOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        return userOptional.get();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody User user) {
        Optional<User> userOptional = userRepository.findByDisplayName(user.getDisplayName());
        if (userOptional.isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }

        userRepository.save(user);
    }

    @PutMapping("/{displayName}")
    public void updateUser(@PathVariable String displayName, @RequestBody User user) {
        Optional<User> userOptional = userRepository.findByDisplayName(displayName);
        if (userOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        userRepository.save(user);
    }

    @DeleteMapping("/{displayName}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable String displayName) {
        Optional<User> userOptional = userRepository.findByDisplayName(displayName);
        if (userOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        userRepository.delete(userOptional.get());
    }
}
