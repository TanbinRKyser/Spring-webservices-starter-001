package com.tusker.restfulwebservicesstarter.helloworld;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
public class HelloWorldController {

    private final MessageSource messageSource;

    public HelloWorldController( MessageSource messageSource ) {
        this.messageSource = messageSource;
    }

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

    /*@GetMapping("/hello-world-internationalized")
    public String helloWorldInternationalize(  @RequestHeader(name="Accept-Language", required = false  ) Locale locale ){
        return messageSource.getMessage( "good.morning.message", null , locale );
    }*/

    @GetMapping("/hello-world-internationalized")
    public String helloWorldInternationalize(){
        return messageSource.getMessage( "good.morning.message", null , LocaleContextHolder.getLocale() );
    }


}
