package com.tusker.restfulwebservicesstarter.controller;

import com.tusker.restfulwebservicesstarter.model.User;
import com.tusker.restfulwebservicesstarter.service.UserJpaService;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class UserJpaController {

    private final UserJpaService userJpaService;

    public UserJpaController( UserJpaService userJpaService ){
        this.userJpaService = userJpaService;
    }

    // retrieve all users
    @GetMapping("/jpa/users")
    List<User> findAllUsers(){
        return userJpaService.findAllUsers();
    }

    // retrieve user by id
    @GetMapping("/jpa/users/{id}")
    EntityModel<Optional<User>> findUserById( @PathVariable int id ){

        var resource = EntityModel.of( userJpaService.findUserById( id ) );

        WebMvcLinkBuilder linkTo = WebMvcLinkBuilder.linkTo( WebMvcLinkBuilder
            .methodOn( this.getClass() )
            .findAllUsers() );

        resource.add( linkTo.withRel( "all-users" ) );

        return resource;
    }

    @PostMapping("/jpa/users")
    ResponseEntity<Object> addNewUser( @Valid @RequestBody User user ){

        User newUser = userJpaService.addNewUser( user );

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path( "/{id}" )
                .buildAndExpand( newUser.getId() )
                .toUri();

        return ResponseEntity.created( uri ).build();
    }

    @DeleteMapping("/jpa/users/{id}")
    void removeUser( @PathVariable int id ) {
        userJpaService.removeUser( id );
    }
}
