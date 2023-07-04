package com.example.pyszne_pl_2.services;

import com.example.pyszne_pl_2.models.MyUser;
import com.example.pyszne_pl_2.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        MyUser myUser = userRepository.getUserByUsername(username);

        if (myUser == null) {
            throw new UsernameNotFoundException("Could not find user");
        }

        return User.builder()
                .username(myUser.getUsername())
                .password(myUser.getPassword())
                .build();
    }
}
