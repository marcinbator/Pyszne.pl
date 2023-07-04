package com.example.pyszne_pl_2.repositories;

import com.example.pyszne_pl_2.models.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<MyUser, String> {

    MyUser getUserByUsername(String username);

}
