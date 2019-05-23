package com.rest.services.restserviceartifact.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

//http://localhost:8080/hello-world-gradle
    @RequestMapping(method = RequestMethod.GET,path = "/hello-world-gradle")
    public String helloWorldGradle(){
        return "hello world Gradle";
    }

    //http://localhost:8080/hello-world-get-mapping-gradle
    @GetMapping(path = "/hello-world-get-mapping-gradle")
    public String helloWorldGetMappingGradle(){
        return "hello world grale get mapping";
    }
}