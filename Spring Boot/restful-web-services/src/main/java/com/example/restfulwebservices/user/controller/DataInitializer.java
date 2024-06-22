package com.example.restfulwebservices.user.controller;


import com.example.restfulwebservices.user.dao.User;
import com.example.restfulwebservices.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.Date;
import java.util.stream.IntStream;

@Component
public class DataInitializer implements CommandLineRunner {

    @Inject
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        // Check if the table is empty
        if (userRepository.count() <= 5) {
            // Create and save 10,000 users
            IntStream.rangeClosed(1, 10000).forEach(i -> {
                User user = new User(i, "User" + i, new Date());
                userRepository.save(user);
            });
        }
    }
}
