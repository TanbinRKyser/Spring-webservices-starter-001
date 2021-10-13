package com.tusker.restfulwebservicesstarter.controller;

import com.tusker.restfulwebservicesstarter.service.HelloWorldBean;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWorldController {

    @RequestMapping(method = RequestMethod.GET, path = "/hello-world")
    public String helloWorld(){
        return "Hello World";
    }

    @GetMapping("/hello-world-bean")
    public HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("Hello World");
    }

    @GetMapping("/hello-world/{name}")
    public HelloWorldBean helloWorldBean( @PathVariable String name ){
        return new HelloWorldBean( "Hello World " + name );
    }


}
