package com.example.pyszne_pl_2.repositories;

import com.example.pyszne_pl_2.models.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;

//Repository that contains DB actions

public interface UserRepository extends JpaRepository<MyUser, Long> { //<ObjectType, IdType>
    MyUser getUserByUsername(String username); //Custom method (JPA based on method name)
}
