package com.tusker.restfulwebservicesstarter.service;

import com.tusker.restfulwebservicesstarter.exception.UserNotFoundException;
import com.tusker.restfulwebservicesstarter.model.User;
import com.tusker.restfulwebservicesstarter.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Component
public class UserJpaService {

    private final UserRepository userRepository;

    public UserJpaService( UserRepository userRepository ) {
        this.userRepository = userRepository;
    }


    public List<User> findAllUsers(){
        return userRepository.findAll();
    }

    // find user by id
    public Optional<User> findUserById( int id ){
        Optional<User> user = userRepository.findById( id );
        if( user.isPresent() ) return user;
        else throw new UserNotFoundException( "id - " + id );
    }

    // save new user
    public User addNewUser( User user ){
        userRepository.save( user );
        return user;
    }

    public void removeUser( int id ){
        userRepository.deleteById( id );
    }
}
