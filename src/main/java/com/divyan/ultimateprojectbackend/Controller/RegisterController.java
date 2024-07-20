package com.divyan.ultimateprojectbackend.Controller;

import com.divyan.ultimateprojectbackend.Model.User;
import com.divyan.ultimateprojectbackend.Repository.MyUserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class RegisterController {
    private final PasswordEncoder passwordEncoder;
    private final MyUserRepository myUserRepository;

    public RegisterController(PasswordEncoder passwordEncoder, MyUserRepository myUserRepository) {
        this.passwordEncoder = passwordEncoder;
        this.myUserRepository = myUserRepository;
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping(value = "/saveuser", consumes = "application/x-www-form-urlencoded")
    public String saveUserFromForm(@RequestParam String username, @RequestParam String password, @RequestParam String roles) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        user.setRoles(roles);
        myUserRepository.save(user);
        return "user";
    }
}
