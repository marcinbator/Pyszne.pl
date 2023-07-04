package com.example.pyszne_pl_2.repositories;

import com.example.pyszne_pl_2.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

    User getUserByUsername(String username);

}
