package com.rest.services.restmicroservicesartifact.hellorestcontroller.domain.user;

import com.rest.services.restmicroservicesartifact.hellorestcontroller.domain.user.excpetion.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;

import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

@RestController
public class UserResource {

    @Autowired
    private UserDaoService userDaoService;

    @GetMapping("/users")
    public List<User> retrieveAllUsers(){
        return userDaoService.findAll();
    }


    @GetMapping("/users/{id}")
    public Resource<User> retrieveUser(@PathVariable int id){
        User user = userDaoService.findOne(id);

        if(user == null ){
           throw new UserNotFoundException("id --> "+id);
        }

        Resource<User>  resource = new Resource<>(user);

        ControllerLinkBuilder linkTo =  linkTo(methodOn(this.getClass()).retrieveAllUsers());

        resource.add(linkTo.withRel("all-users"));



        return resource;
    }

    @PostMapping("/users")
    public ResponseEntity createUser(@Valid @RequestBody User user){
        User userSaved = userDaoService.save(user);

        URI location =  ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(userSaved.getId())
                .toUri();

        return ResponseEntity.created(location).build();

    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id ){
        User userDeleted = userDaoService.deleteById(id);

        if(userDeleted == null ){
            throw new UserNotFoundException("id --> "+id);
        }
    }
}
