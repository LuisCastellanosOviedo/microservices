package com.rest.services.restmicroservicesartifact.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {

    @GetMapping("/v1/Person")
    public PersonV1 personV1(){
        return new PersonV1("Bob Charlie");
    }

    //localhost:8080/person/param?version=1
    @GetMapping(value = "/person/param",params = "version=1")
    public PersonV1 personV1Param(){
        return new PersonV1("Bob Charlie");
    }

    @GetMapping(value = "/person/header",headers = "X-API-VERSION=1")
    public PersonV1 personV1Header(){
        return new PersonV1("Bob Charlie");
    }

    //localhost:8080/person/param?version=2
    @GetMapping(value = "/person/param",params = "version=2")
    public PersonV2 personV2Param(){
        return new PersonV2(new Name("Bob","Charlie"));
    }

    @GetMapping(value = "/person/header",headers = "X-API-VERSION=2")
    public PersonV2 personV2Header(){
        return new PersonV2(new Name("Bob","Charlie"));
    }


    @GetMapping("/v2/Person")
    public PersonV2 personV2(){
        return new PersonV2(new Name("Bob","Charlie"));
    }


}
