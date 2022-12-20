package com.example.springbootathtorizationservise.service;

import com.example.springbootathtorizationservise.exception.InvalidCredentials;
import com.example.springbootathtorizationservise.exception.UnauthorizedUser;
import com.example.springbootathtorizationservise.repository.Authorities;
import com.example.springbootathtorizationservise.repository.UserRepository;

import java.util.List;

public class AuthorizationService {
    UserRepository userRepository;

    public AuthorizationService(){
        userRepository = new UserRepository();
    }

    public List<Authorities> getAuthorities(String user, String password) {
        System.out.println(user);
        System.out.println(password);

        if (isEmpty(user) || isEmpty(password)) {
            throw new InvalidCredentials("User name or password is empty");
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user, password);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user);
        }
        return userAuthorities;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }
}
