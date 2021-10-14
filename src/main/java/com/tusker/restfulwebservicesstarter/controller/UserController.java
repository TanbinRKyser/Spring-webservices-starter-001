package com.tusker.restfulwebservicesstarter.controller;

import com.tusker.restfulwebservicesstarter.model.User;
import com.tusker.restfulwebservicesstarter.exception.UserNotFoundException;
import com.tusker.restfulwebservicesstarter.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
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
    User findUserById( @PathVariable int id ){
        User userById = userService.findUserById( id );
        if( userById == null ){
            throw new UserNotFoundException( " id - " + id );
        }
        return userById;
    }


    @PostMapping("/users")
    ResponseEntity<Object> addNewUser( @Valid @RequestBody User user ){
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

    @DeleteMapping("/users/{id}")
    ResponseEntity<Object> removeUser( @PathVariable int id ){

        User removeUser = userService.removeUser( id );

        if( removeUser == null ) throw new UserNotFoundException( "id - " + id );

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path( "/{id}" )
                .buildAndExpand( removeUser.getId() )
                .toUri();

        return ResponseEntity.created( uri ).build();
    }
}
