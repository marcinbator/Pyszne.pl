package com.example.pyszne_pl_2.services;

import com.example.pyszne_pl_2.models.MyUser;
import com.example.pyszne_pl_2.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

//Service that creates MyUser object from DB repository based on its username.

@AllArgsConstructor //Constructor demanding all args
@Service //Service Bean annotation
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserRepository userRepository; //Repository with DB actions

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        MyUser myUser = userRepository.getUserByUsername(username); //New MyUser object creation from DB

        if (myUser == null) {
            throw new UsernameNotFoundException("Could not find user");
        }

        return User.builder()
                .username(myUser.getUsername())
                .password(myUser.getPassword())
                .build(); //Building User (Java) object from MyUser
    }
}
