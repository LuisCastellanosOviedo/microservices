package com.rest.services.restmicroservicesartifact.hellorestcontroller.domain.user;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Component
public class UserDaoService {

    private static List<User> users = new ArrayList<>();

    private static int usersCount = 3;

    static {
        users.add(new User(1,"jack",new Date()));
        users.add(new User(2,"Adam",new Date()));
        users.add(new User(3,"Luis",new Date()));
    }

    public List<User> findAll(){
        return users;
    }

    public User save(User user){
        if(user.getId()==null){
            user.setId(++usersCount);
        }
        users.add(user);

        return user;
    }

    public User findOne(int id){
        return users.stream().filter(a -> a.getId()== id).findFirst().orElse(null);
    }

    public User deleteById(int id){
        User userTodelete = findOne(id);

        users.removeIf(a -> a.getId()== id);

        return userTodelete;
    }
}
