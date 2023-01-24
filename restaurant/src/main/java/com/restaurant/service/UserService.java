package com.restaurant.service;

import com.restaurant.model.User;
import com.restaurant.web.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.boot.autoconfigure.security.servlet.UserDetailsService;

public interface UserService {
    User save (UserRegistrationDto registrationDto);

    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
