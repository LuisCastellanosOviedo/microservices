package com.rest.services.restmicroservicesartifact.hellorestcontroller;

import com.rest.services.restmicroservicesartifact.hellorestcontroller.domain.HelloWorldBean;
import org.springframework.web.bind.annotation.*;

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

    //http://localhost:8080/hello-world-bean
    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("hello world bean ");
    }

    //http://localhost:8080/hello-world-bean/path-variable/DarkSouls3
    @GetMapping(path = "/hello-world-bean/path-variable/{name}")
    public HelloWorldBean helloWorldBeanPathVariable(@PathVariable String name){
        return new HelloWorldBean(String.format("Hello World Bean , %s",name));
    }
}
