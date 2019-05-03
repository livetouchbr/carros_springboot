package com.carros.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.concurrent.TimeUnit;

public class GeneratePassword {
    public static void main(String[] args) {

        System.out.println("Admin -> "
                + new BCryptPasswordEncoder().encode("admin"));

        System.out.println("User -> "
                + new BCryptPasswordEncoder().encode("user"));
    }
}
