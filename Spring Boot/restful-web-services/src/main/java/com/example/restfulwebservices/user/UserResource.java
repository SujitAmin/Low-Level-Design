package com.example.restfulwebservices.user;

import com.example.restfulwebservices.exception.ExceptionResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Date;
import java.util.List;

@Validated
@RestController
public class UserResource {

    @Autowired
    private UserDaoService userDaoService;

    public UserResource(UserDaoService userDaoService) {
        this.userDaoService = userDaoService;
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userDaoService.findAllUsers();
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
