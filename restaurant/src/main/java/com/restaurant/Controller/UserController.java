package com.restaurant.Controller;

import com.restaurant.repository.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class UserController {
    private final ProductRepository productRepository;

    public UserController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

//    @RequestMapping(value = {"/dashboard"}, method = RequestMethod.GET)
//    public String homePage(){
//        return "user/dashboard";
//    }

    @GetMapping(value = {"/dashboard"})
    public String listProduct(Model model){
        model.addAttribute("products", productRepository.findAll());


        return "user/dashboard";
    }
}
