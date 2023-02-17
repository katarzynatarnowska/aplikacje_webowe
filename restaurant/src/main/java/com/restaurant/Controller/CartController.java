package com.restaurant.Controller;

import com.restaurant.model.*;
import com.restaurant.service.CartService;
import com.restaurant.service.OrderDetailService;
import com.restaurant.service.OrderService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.restaurant.service.ProductService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CartController {


    @Autowired
    private CartService cartService;
    @Autowired
    private ProductService productService;

    @Autowired
    private OrderDetailService orderDetailService;

    @Autowired
    private OrderService orderService;

    @GetMapping("/user/cart/{id}")
    public String cart(@PathVariable("id") int id, HttpSession session, Model model) {
        session.setAttribute("product", productService.getProductById(id));
        Cart cart = new Cart();
        model.addAttribute("cart", cart);
        return "/user/cart";
    }


    @PostMapping("/cartproduct")
    public String cartProduct(@RequestParam("quantity") int quantity, HttpSession session) {
        Cart cart = new Cart();
        Product product = (Product) session.getAttribute("product");
        cart.setPrice(product.getPrice() * quantity);
        cart.setName(product.getName());
        cart.setQuantity(quantity);
        cart.setIdProducts(product.getId());
        cartService.saveCart(cart);
        return "redirect:/user/shoppingcart";
    }

    @GetMapping("/user/shoppingcart")
    public String showCart(Model model, HttpSession session) {

        List<Cart> cartProduct = cartService.getAllCart();
        if (!cartProduct.isEmpty()) {
            model.addAttribute("cartProduct", cartProduct);
            model.addAttribute("action", session.getAttribute("action"));
            session.setAttribute("action", null);
            return "/user/shoppingcart";

            }else{
                return "redirect:/dashboard#menu";

            }

            }



    @PostMapping("/order")
    public String order(HttpServletRequest request){

        List<Cart> cartProduct= cartService.getAllCart();
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Order order = new Order();
        order.setIdUser(user);

        int totalCost=0;

        for (Cart c:cartProduct){
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setProductId(c.getIdProducts());
            orderDetail.setAmount(c.getPrice());
            orderDetail.setQuantity(c.getQuantity());
            orderDetail.setOrder(order);
            totalCost+= c.getPrice();
        }
        order.setPrice(totalCost);
        orderService.saveOrder(order);

        for (Cart c:cartProduct){
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setProductId(c.getIdProducts());
            orderDetail.setAmount(c.getPrice());
            orderDetail.setQuantity(c.getQuantity());
            orderDetail.setOrder(order);
            orderDetailService.addOrderDetail(orderDetail);
        }


        cartService.cartDeleteAll();
        return "redirect:/dashboard";
    }
        }


