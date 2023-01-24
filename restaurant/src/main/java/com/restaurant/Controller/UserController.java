package com.restaurant.Controller;

import com.restaurant.repository.UserRepo;
import com.restaurant.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import com.restaurant.model.UserLogin;

@Controller
public class UserController {


    @Autowired(required = true)
    private UserRepo repo;

    @GetMapping("/login")
    public String login(Model model) {
        UserLogin userLogin = new UserLogin();
        model.addAttribute("user", userLogin);
        return "/login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("user") UserLogin userLogin) {

        String email = userLogin.getEmail();
        Optional<UserLogin> userdata = repo.findById(email);

        if(userLogin.getPassword().equals(userdata.get().getPassword())) {
            return "home";
        } else {
            return "/error.html";
        }




    }
}
