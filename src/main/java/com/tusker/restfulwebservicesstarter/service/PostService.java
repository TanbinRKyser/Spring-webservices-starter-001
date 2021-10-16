package com.tusker.restfulwebservicesstarter.service;

import com.tusker.restfulwebservicesstarter.model.Post;
import com.tusker.restfulwebservicesstarter.model.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PostService {

    private static List<Post> posts = new ArrayList<>();
    private static int postCount = 3;

    static {
        posts.add( new Post( 1, "Tucker", "The lazy brown fox jumped over the fence" ));
        posts.add( new Post( 2, "John", "The lazy brown fox jumped over the fence" ));
        posts.add( new Post( 3, "Samuel", "The lazy brown fox jumped over the fence" ));
    }

    // retrieve all posts
    // create a post
    // retrieve all the details of a post
}
