package com.example.springbootathtorizationservise.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class User {
    @NotBlank
    @Size(min = 4)
    String user;
    @NotBlank
    @Size(min = 4)
    String password;

    public User(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public String getName() {
        return user;
    }

    public String getPassword() {
        return password;
    }
}
