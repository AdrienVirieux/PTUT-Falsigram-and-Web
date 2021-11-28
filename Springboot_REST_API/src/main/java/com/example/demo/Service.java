package com.example.demo;

class Service {
    String toUpperCase(String s) {
        return s.toUpperCase();
    }

    String infoUser(User user) {
        return "je m'appelle " + user.getName() + " et j'ai " + user.getAge() + " ans.";
    }
}
