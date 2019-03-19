package com.example.clientapp;


public class User {
    public String name, email, password ,location;


    public User(){

    }

    public User(String name, String email, String password, String location) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.location = location;
    }
}
