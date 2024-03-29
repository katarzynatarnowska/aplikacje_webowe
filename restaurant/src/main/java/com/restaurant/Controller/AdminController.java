package com.restaurant.Controller;

import com.restaurant.model.Product;
import com.restaurant.model.User;
import com.restaurant.repository.OrderRepository;
import com.restaurant.repository.ProductRepository;
import com.restaurant.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.restaurant.service.ProductService;

import java.util.Optional;
import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductService productService;
    @Autowired
    private OrderRepository orderRepository;


    @RequestMapping(path = {"/admin/dashboard"}, method = RequestMethod.GET)
    public String adminHome(){
        return "admin/dashboard";
    }

//    @RequestMapping(value = {"/admin/orders"}, method = RequestMethod.GET)
//    public String adminOrder(){
//        return "admin/orders";
//    }



@GetMapping(value = {"/admin/users"})
public String listUser(Model model){
      model.addAttribute("userlist", userRepository.findAll());

//    List<User> userd = userRepository.findAll();
//       for(User usr:userd){
//          System.out.println("X");
//       }


        return "admin/users";
    }


    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("users") User user) {
        userRepository.save(user);
        return "redirect:/admin/users";
    }


    @GetMapping("/updateUser/{id}")

    public String updateUser(@PathVariable("id") long id, Model model){
        Optional<User> temp=userRepository.findById(id);
        User user=temp.get();
        model.addAttribute("user", user);
        return "admin/updateuser";
    }
    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id")long id){
        userRepository.deleteById(id);

        return "redirect:/admin/users";
    }



//    @GetMapping(value = {"/admin/products"})
//    public String listProduct (Model model){
//
////        for(Product prod: productRepository.findAll() ){
////            System.out.println(prod.getName());
//
//        model.addAttribute("productlist",productRepository.findAll());
//
//        return "admin/products";
//     }

    @GetMapping("/admin/products")
    public String listProduct(HttpServletRequest request, Model model) {

        int page = 0; //default page number is 0 (yes it is weird)
        int size = 5; //default page size is 10

        if (request.getParameter("page") != null && !request.getParameter("page").isEmpty()) {
            page = Integer.parseInt(request.getParameter("page")) - 1;
        }

        if (request.getParameter("size") != null && !request.getParameter("size").isEmpty()) {
            size = Integer.parseInt(request.getParameter("size"));
        }

        model.addAttribute("productlist", productRepository.findAll(PageRequest.of(page, size)));
        return "/admin/products";
    }

    @GetMapping("/saveProductPage")
	public String saveProductPage(Model model) {
        		Product product=new Product();
        		model.addAttribute("product",product);
        	 return "admin/addproduct";
        	}
    @PostMapping("/saveProduct")
	public String saveProduct(@ModelAttribute("product") Product product) {
        		productRepository.save(product);
        		return "redirect:/admin/products";
        	}

     @GetMapping("/updateProduct/{id}")

     public String updateProduct(@PathVariable("id")int id, Model model){
         Product temp=productRepository.findById(id);
        Product product=temp;
         model.addAttribute("product", product);
        return "admin/updateproduct";
     }



     @GetMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable("id")int id){
    productRepository.deleteById(id);

        return "redirect:/admin/products";
     }

//    @GetMapping("/admin/users")
//    public String listUser(HttpServletRequest request, Model model) {
//
//        int page = 0; //default page number is 0 (yes it is weird)
//        int size = 2; //default page size is 10
//
//        if (request.getParameter("page") != null && !request.getParameter("page").isEmpty()) {
//            page = Integer.parseInt(request.getParameter("page")) - 1;
//        }
//
//        if (request.getParameter("size") != null && !request.getParameter("size").isEmpty()) {
//            size = Integer.parseInt(request.getParameter("size"));
//        }
//
//        model.addAttribute("productuser", productRepository.findAll(PageRequest.of(page, size)));
//        return "/admin/users";
//    }

//    @RequestMapping(path = {"/admin/products","/search"})
//    public String search(Model model, HttpSession session, String keyword) {
//        if (keyword != null) {
//            session.setAttribute("productlist", productService.getByKeyword(keyword));
//        } else {
//            session.setAttribute("productlist", productService.getAllProducts(keyword));
//
//        }
//        return "/admin/products";
//    }

    @RequestMapping(path = {"/admin/products","/search"})
    public String search(Product product, Model model, String keyword) {
        if(keyword!=null) {
            List<Product> list = productService.getByKeyword(keyword);
            model.addAttribute("productlist", list);
        }else {
            List<Product> list = productService.getAllProducts(keyword);
            model.addAttribute("productlist", list);}
        return "/admin/searchproducts";
    }


    @GetMapping("/admin/orders")
    public String order(HttpServletRequest request, Model model) {

        int page = 0; //default page number is 0 (yes it is weird)
        int size = 7; //default page size is 10

        if (request.getParameter("page") != null && !request.getParameter("page").isEmpty()) {
            page = Integer.parseInt(request.getParameter("page")) - 1;
        }

        if (request.getParameter("size") != null && !request.getParameter("size").isEmpty()) {
            size = Integer.parseInt(request.getParameter("size"));
        }

        model.addAttribute("order", orderRepository.findAll(PageRequest.of(page, size)));
        return "/admin/orders";
    }

}

