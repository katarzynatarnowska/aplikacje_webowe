package com.restaurant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@RestController

public class RestaurantApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestaurantApplication.class, args);
	}



//@GetMapping("/signin.html")
//public String signin() {
//		return "/signin.html";
//	}

	public class SpringBootSecurityApplication {
		public static void main(String[] args) {
			SpringApplication.run(SpringBootSecurityApplication.class, args);
		}

	}



}
