package com.example.Final.Project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class UserController {

    private UserDAO userDAO;

    @RequestMapping("/User")
    public List<UserDB> retrieveUsers() {
        return userDAO.getUsers();
    }


    //Add request mapping for specific contact info for one user ie /User/'username' for callback form (if still doing)
    @RequestMapping("/User/{UserID}")
    public List<UserDB> retrieveUserInfo(@PathVariable int UserID) {
        return userDAO.getUserInfo(UserID);
    }

    @Autowired
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
}

//URL for all data for Users https://localhost:8080/User
//URL for User specific data for Users https://localhost:8080/User/{UserID}