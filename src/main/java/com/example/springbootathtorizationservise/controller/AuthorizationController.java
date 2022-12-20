package com.example.springbootathtorizationservise.controller;

import com.example.springbootathtorizationservise.repository.Authorities;
import com.example.springbootathtorizationservise.service.AuthorizationService;
import com.example.springbootathtorizationservise.user.User;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/")
public class AuthorizationController {
    AuthorizationService service;

    public AuthorizationController(){
        service = new AuthorizationService();
    }

    @GetMapping("authorize")
    public List<Authorities> getAuthorities(@Valid User user) {
        return service.getAuthorities(user);
    }

}
