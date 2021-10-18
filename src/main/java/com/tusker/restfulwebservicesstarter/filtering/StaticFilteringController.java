package com.tusker.restfulwebservicesstarter.filtering;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StaticFilteringController {

    @GetMapping("/static-filtering")
    public SomeBean retrieveSomeBean(){
        return new SomeBean( 1, "name", "title", "details" );
    }
    @GetMapping("/static-filtering-list")
    public List<SomeBean> retrieveListBean(){
        return List.of(
                new SomeBean( 2, "name2", "title2", "details2" ),
                new SomeBean( 3, "name3", "title3", "details3" )
        );
    }
}
