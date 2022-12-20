package com.example.springbootathtorizationservise.repository;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.example.springbootathtorizationservise.repository.Authorities.*;

public class UserRepository {
    Map<String, String> usersPasswordsMap;
    Map<String, List<Authorities>> usersAuthoritiesMap;

    public UserRepository() {
        this.usersPasswordsMap = new HashMap<>();
        this.usersPasswordsMap.put("user1", "1111");
        this.usersPasswordsMap.put("user2", "2222");
        this.usersPasswordsMap.put("user3", "3333");
        this.usersPasswordsMap.put("user4", "4444");

        this.usersAuthoritiesMap = new HashMap<>();
        this.usersAuthoritiesMap.put("user1", List.of(new Authorities[]{READ, WRITE, DELETE}));
        this.usersAuthoritiesMap.put("user2", List.of(new Authorities[]{READ, DELETE}));
        this.usersAuthoritiesMap.put("user3", List.of(new Authorities[]{READ, WRITE}));
        this.usersAuthoritiesMap.put("user4", List.of(new Authorities[]{DELETE}));
    }


    public List<Authorities> getUserAuthorities(String user, String password) {
        if (!this.usersPasswordsMap.containsKey(user) || !this.usersPasswordsMap.get(user).equals(password)) {
            return Collections.emptyList();
        }else {
            return this.usersAuthoritiesMap.get(user);
        }
    }
}
