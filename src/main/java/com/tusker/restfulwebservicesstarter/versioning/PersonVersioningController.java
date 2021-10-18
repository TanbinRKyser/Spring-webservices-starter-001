package com.tusker.restfulwebservicesstarter.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {

    @GetMapping("/v1/Person")
    public PersonV1 personV1(){
        return new PersonV1( "Charlene Gautlier" );
    }

    @GetMapping("/v2/Person")
    public PersonV2 personV2(){
        return new PersonV2( new Name( "Charlene", "Gautier") );
    }

    @GetMapping(value = "/person/param", params = "version=1")
    public PersonV1 paramV1(){
        return new PersonV1( "Charlene Gautier" );
    }

    @GetMapping(value = "/person/param", params = "version=2")
    public PersonV2 paramV2(){
        return new PersonV2( new Name( "Charlene", "Gautier") );
    }

    @GetMapping(value = "/person/header", headers = "X_API_VERSION=1")
    public PersonV1 headerV1(){
        return new PersonV1( "Charlene Gautier" );
    }

    @GetMapping(value = "/person/header", headers = "X_API_VERSION=2")
    public PersonV2 headerV2(){
        return new PersonV2( new Name( "Charlene", "Gautier") );
    }

    @GetMapping(value = "/person/produces", produces = "application/tusker.org.app-v1+json" )
    public PersonV1 producesV1(){
        return new PersonV1( "Charlene Gautier" );
    }

    @GetMapping(value = "/person/produces", produces = "application/tusker.org.app-v2+json" )
    public PersonV2 producesV2(){
        return new PersonV2( new Name( "Charlene", "Gautier") );
    }
}
