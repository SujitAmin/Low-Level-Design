package com.example.restfulwebservices.user.controller;

import com.example.restfulwebservices.user.exception.UserNotFoundException;
import com.example.restfulwebservices.user.dao.User;
import com.example.restfulwebservices.user.repository.UserRepository;
import com.example.restfulwebservices.user.service.UserDaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.inject.Inject;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//important
import java.lang.reflect.Field;

@Validated
@RestController
public class UserController {

    @Inject
    private UserDaoService userDaoService;
    @Inject
    private UserRepository userRepository;

    public UserController(UserDaoService userDaoService) {
        this.userDaoService = userDaoService;
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userDaoService.findAllUsers();
    }

    @GetMapping("/users/paginated")
    public Page<User> retrieveAllUsers(
            @RequestParam(value = "page", defaultValue = "0", required = false) int page,
            @RequestParam(value = "size", defaultValue = "10", required = false) int size,
            @RequestParam(value = "sort", defaultValue = "name", required = false) String sort,
            @RequestParam(value = "direction", defaultValue = "desc", required = false) String direction){
        List<String> validFields = Stream.of(User.class.getDeclaredFields())
                .map(Field::getName)
                .collect(Collectors.toList());

        // Validate the sort parameter
        if (!validFields.contains(sort)) {
            throw new IllegalArgumentException("Invalid sort parameter: " + sort);

        }
        Sort sortOrder = Sort.by(Sort.Direction.fromString(direction), sort);
        Pageable pageable = PageRequest.of(page, size, sortOrder);
        return userRepository.findAll(pageable);

    }
    @GetMapping("/users/{id}")
    // @ApiOperation(value = "Finds Users by id",
    //          notes = "Also returns a link to retrieve all users with rel - all-users")
    public User getUserById(@PathVariable int id) {
        User user = userDaoService.findUserById(id);
        if (user == null) {
            throw new UserNotFoundException("User not found id-"+id);
        }
        //"all-users", SERVER_PATH + "/users"
        //retrieveAllUsers

        return user;
    }

    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        User savedUser = userDaoService.addUser(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(location).body(savedUser);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id) {
        User user = userDaoService.deleteById(id);
        if (user != null) {
            userDaoService.deleteById(id);
        } else {
            throw new UserNotFoundException("id-" + id);
        }
    }
}
