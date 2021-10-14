package com.tusker.restfulwebservicesstarter.controller;

import com.tusker.restfulwebservicesstarter.model.User;
import com.tusker.restfulwebservicesstarter.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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


    @PostMapping("/users")
    ResponseEntity<Object> addNewUser( @RequestBody User user ){
        User newUser = userService.addNewUser( user );
        // return a status
        // /user/{id} -> newUser.getId();
        URI uri = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path( "/{id}" )
                    .buildAndExpand( newUser.getId() )
                    .toUri();

        return ResponseEntity.created( uri ).build();
    }
}
