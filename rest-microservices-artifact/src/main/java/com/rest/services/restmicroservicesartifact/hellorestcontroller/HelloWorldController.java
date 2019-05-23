package com.rest.services.restmicroservicesartifact.hellorestcontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    //http://localhost:8080/hello-world
    @RequestMapping(method = RequestMethod.GET,path = "/hello-world-maven")
    public String helloWorld(){
        return "Hello World-maven";
    }

    //http://localhost:8080/hello-world-get-mapping
    @GetMapping(path = "/hello-world-get-mapping-maven")
    public String helloWorldGetMapping(){
        return "hello world get mapping-maven";
    }
}