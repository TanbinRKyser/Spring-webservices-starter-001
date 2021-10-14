package com.tusker.restfulwebservicesstarter.service;

import com.tusker.restfulwebservicesstarter.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Component
public class UserService {

    private static List<User>  users = new ArrayList<>();
    private static int userCount = 5;

    static {
        users.add( new User( 1, "Tucker", new Date() ));
        users.add( new User( 2, "Pierre", new Date() ));
        users.add( new User( 3, "Maxine", new Date() ));
        users.add( new User( 4, "LaCroix", new Date() ));
        users.add( new User( 5, "Gautier", new Date() ));
    }

    // find all users
    public List<User> findAllUsers(){
        return users;
    }

    // save new user
    public User addNewUser( User user ){
        if( user.getId() == 0 ){
            user.setId( ++userCount );
        }
        users.add( user );
        return user;
    }

    // find user by id
    public User findUserById( int id ){
        for( User user : users ){
            if( user.getId() == id )
                return user;
        }
        return null;
    }

    public User removeUser( int id ){
        Iterator<User> iterator = users.iterator();
        while ( iterator.hasNext() ){
            User user = iterator.next();
            if( user.getId() == id ){
                iterator.remove();
                return user;
            }
        }
        return null;
    }

}
