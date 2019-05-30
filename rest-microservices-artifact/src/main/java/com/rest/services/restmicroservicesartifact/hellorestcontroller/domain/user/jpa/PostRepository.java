package com.rest.services.restmicroservicesartifact.hellorestcontroller.domain.user.jpa;

import com.rest.services.restmicroservicesartifact.hellorestcontroller.domain.user.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post,Integer> {
}
