package com.example.myapplication.Model;

public class User {
    private String Phone;
    private String Password;

    public User() {
    }

    public User(String phone, String password) {
        Phone = phone;
        Password = password;
    }

    public String getPhone() {
        return Phone;
    }

    public void sePhone(String phone) {
        Phone = phone;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
