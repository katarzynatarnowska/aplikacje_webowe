package com.restaurant.Controller;


import com.restaurant.model.User;
import org.springframework.stereotype.Controller;

import com.restaurant.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.restaurant.repository.ProductRepository;
import com.restaurant.model.Product;

import jakarta.validation.Valid;
import java.util.List;

@Controller
public class AuthController {

    @Autowired
    UserService userService;
    @Autowired
    private ProductRepository productRepository;

    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public String login(){
        return "auth/login";
    }

    @RequestMapping(value = {"/register"}, method = RequestMethod.GET)
    public String register(Model model){
        model.addAttribute("user", new User());
        return "auth/register";
    }

    @RequestMapping(value = {"/register"}, method = RequestMethod.POST)
    public String registerUser(Model model, @Valid User user, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            model.addAttribute("successMessage", "User registered successfully!");
            model.addAttribute("bindingResult", bindingResult);
            return "auth/register";
        }
        List<Object> userPresentObj = userService.isUserPresent(user);
        if((Boolean) userPresentObj.get(0)){
            model.addAttribute("successMessage", userPresentObj.get(1));
            return "auth/register";
        }

        userService.saveUser(user);
        model.addAttribute("successMessage", "User registered successfully!");
        return "auth/login";
    }
    @GetMapping(value = {"/"})
    public String listProduct(Model model){
        model.addAttribute("products", productRepository.findAll());


        return "homepage";
    }
}