package com.example.Final.Project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    private UserDAO userDAO;

    @RequestMapping("/Hello")
    public int check() {
        return 10;
    }

    @RequestMapping("/User")
    public List<UserDB> test() {
        return userDAO.getUsers();
    }

    @Autowired
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
}

//URL for all data for Users https://localhost:8080/User