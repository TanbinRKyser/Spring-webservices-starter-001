package com.tusker.restfulwebservicesstarter.controller;

import com.tusker.restfulwebservicesstarter.model.User;
import com.tusker.restfulwebservicesstarter.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    public UserController( UserService userService ) {
        this.userService = userService;
    }

    // retrieve all users
    @GetMapping("/users")
    List<User> findAllUsers(){
        return userService.findAllUsers();
    }

    // retrieve user by id
    @GetMapping("/users/{id}")
    User findUserById( @PathVariable long id ){
        return userService.findUserById( id );
    }

}
