//package com.restaurant.Controller;
//
//import com.restaurant.model.Admin;
//import com.restaurant.repository.AdminRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//
//import java.util.Optional;
//
//public class AdminController {
//
//    @Autowired(required = true)
//    private AdminRepo repo;
//
//    @GetMapping("/login")
//    public String login(Model model) {
//        Admin admin = new Admin();
//        model.addAttribute("admin", admin);
//        return "login";
//    }
//
//    @PostMapping("/login")
//    public String login(@ModelAttribute("admin") Admin admin) {
//
//        String email = admin.getEmail();
//        Optional <Admin> userdata = repo.findById(email);
//
//        if (admin.getPassword().equals(userdata.get().getPassword())) {
//            return "/adminpage.html";
//        }
//
//        else {
//            return "registration";
//        }
//
//
//
//
//    }
//}
