package com.rest.services.restmicroservicesartifact.hellorestcontroller.domain.user.jpa;

import com.rest.services.restmicroservicesartifact.hellorestcontroller.domain.user.Post;
import com.rest.services.restmicroservicesartifact.hellorestcontroller.domain.user.User;
import com.rest.services.restmicroservicesartifact.hellorestcontroller.domain.user.UserDaoService;
import com.rest.services.restmicroservicesartifact.hellorestcontroller.domain.user.excpetion.UserNotFoundException;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class UserJPAResource {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/jpa/users")
    public List<User> retrieveAllUsers(){
        return userRepository.findAll();
    }


    @GetMapping("/jpa/users/{id}")
    public Resource<User> retrieveUser(@PathVariable int id){
        Optional<User> user = userRepository.findById(id);

        if(!user.isPresent() ){
            throw new UserNotFoundException("id --> "+id);
        }

        Resource<User>  resource = new Resource<>(user.get());

        ControllerLinkBuilder linkTo =  linkTo(methodOn(this.getClass()).retrieveAllUsers());

        resource.add(linkTo.withRel("all-users"));



        return resource;
    }

    @PostMapping("/jpa/users")
    public ResponseEntity createUser(@Valid @RequestBody User user){
        User userSaved = userRepository.save(user);

        URI location =  ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(userSaved.getId())
                .toUri();

        return ResponseEntity.created(location).build();

    }

    @DeleteMapping("/jpa/users/{id}")
    public void deleteUser(@PathVariable int id ){
        userRepository.deleteById(id);
    }

    @GetMapping("/jpa/users/{id}/posts")
    public List<Post> retrievePostFromUser(@PathVariable int id){
        Optional<User> user = userRepository.findById(id);

        if(!user.isPresent() ){
            throw new UserNotFoundException("id --> "+id);
        }
        return user.get().getPosts();

    }

    @PostMapping("/jpa/users/{id}/posts")
    public ResponseEntity createPost(@PathVariable Integer id,@RequestBody Post post){
        Optional<User> userOptional = userRepository.findById(id);

        if(!userOptional.isPresent() ){
            throw new UserNotFoundException("id --> "+id);
        }

        User user = userOptional.get();

        post.setUser(user);

        postRepository.save(post);

        URI location =  ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(post.getId())
                .toUri();


        return ResponseEntity.created(location).build();

    }
}
