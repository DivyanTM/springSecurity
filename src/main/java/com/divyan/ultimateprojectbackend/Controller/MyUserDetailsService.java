package com.divyan.ultimateprojectbackend.Controller;

import com.divyan.ultimateprojectbackend.Model.User;
import com.divyan.ultimateprojectbackend.Repository.MyUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Optional;
@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    MyUserRepository myUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user= myUserRepository.findByUsername(username);
        if(user.isPresent()){
            var userObj=user.get();
            return org.springframework.security.core.userdetails.User.builder()
                    .username(userObj.getUsername())
                    .password(userObj.getPassword())
                    .roles(getRoles(userObj))
                    .build();
        }else{
            throw new UsernameNotFoundException("user not found");
        }

    }
    public String[] getRoles(User myUser){
        if(myUser.getRoles()==null){
            return new String[]{"USER"};
        }
        return myUser.getRoles().split(",");
    }
}
