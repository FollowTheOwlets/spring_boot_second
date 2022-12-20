package com.example.springbootathtorizationservise.controller;

import com.example.springbootathtorizationservise.repository.Authorities;
import com.example.springbootathtorizationservise.service.AuthorizationService;
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
    public List<Authorities> getAuthorities(@RequestParam("user") String user, @RequestParam("password") String password) {
        return service.getAuthorities(user, password);
    }

}
