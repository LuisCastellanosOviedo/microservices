package com.rest.services.restmicroservicesartifact.hellorestcontroller.domain.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;


// h2 console --> http://localhost:8080/h2-console
// jdbc url jdbc:h2:mem:testdb
@ApiModel(description = "details from a user")
@Entity
public class User {

    @Id
    @GeneratedValue
    private Integer id;

    @Size(min = 2,message = "Name should have al least 2 characters")
    @ApiModelProperty(notes = "Only 2 characters")
    private String name;

    @Past
    @ApiModelProperty(notes = "Brithday should be in past")
    private Date birthDate;

    @OneToMany(mappedBy = "user")
    private List<Post> posts;

    public User() {
    }

    public User(Integer id, String name, Date birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}
