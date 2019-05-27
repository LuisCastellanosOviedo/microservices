package com.rest.services.restmicroservicesartifact.hellorestcontroller;

import com.rest.services.restmicroservicesartifact.hellorestcontroller.domain.HelloWorldBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
public class HelloWorldController {

    @Autowired
    private MessageSource messageSource;


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

    @RequestMapping(method = RequestMethod.GET,path = "/hello-world-intenationalization")
    public String helloWorldIntenationalization(@RequestHeader(name = "Accept-Language",required = false) Locale locale){
        return messageSource.getMessage("good.morning.message",null, locale);
    }

    @RequestMapping(method = RequestMethod.GET,path = "/hello-world-IntenationalizationContextHolder")
    public String helloWorldIntenationalizationContextHolder(){
        return messageSource.getMessage("good.morning.message",null, LocaleContextHolder.getLocale());
    }
}
