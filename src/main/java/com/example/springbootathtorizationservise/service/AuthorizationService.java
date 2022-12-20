package com.example.springbootathtorizationservise.service;

import com.example.springbootathtorizationservise.exception.InvalidCredentials;
import com.example.springbootathtorizationservise.exception.UnauthorizedUser;
import com.example.springbootathtorizationservise.repository.Authorities;
import com.example.springbootathtorizationservise.repository.UserRepository;
import com.example.springbootathtorizationservise.user.User;

import java.util.List;

public class AuthorizationService {
    UserRepository userRepository;

    public AuthorizationService(){
        userRepository = new UserRepository();
    }

    public List<Authorities> getAuthorities(User user) {
        String userName = user.getName();
        String userPassword = user.getPassword();

        if (isEmpty(userName) || isEmpty(userPassword)) {
            throw new InvalidCredentials("User name or password is empty");
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(userName, userPassword);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + userName);
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
