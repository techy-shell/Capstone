package com.example.Final.Project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    private UserDAO userDAO;

    @RequestMapping("/User")
    public List<UserDB> test() {
        return userDAO.getUsers();
    }

    //Add request mapping for specific contact info for one user ie /User/'username' for callback form (if still doing)


    @Autowired
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
}

//URL for all data for Users https://localhost:8080/User