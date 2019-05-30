package com.rest.services.restmicroservicesartifact.hellorestcontroller.domain.user.jpa;

import com.rest.services.restmicroservicesartifact.hellorestcontroller.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
}
