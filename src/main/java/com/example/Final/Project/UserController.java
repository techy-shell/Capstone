package com.example.Final.Project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class UserController {

    private UserDAO userDAO;

    @RequestMapping("/User")
    public List<UserDB> retrieveUsers() {
        return userDAO.getUsers();
    }


    //Add request mapping for specific contact info for one user ie /User/'username' for callback form (if still doing)

    @RequestMapping("/User/{UserID}")
    public ResponseEntity<List> retrieveUserInfo(@PathVariable int UserID) {
        List<UserDB> user = userDAO.getUserInfo(UserID);
        if (user.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else return new ResponseEntity<>(user, HttpStatus.OK);

    }
    @Autowired
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
}

//URL for all data for Users https://localhost:8080/User
//URL for User specific data for Users https://localhost:8080/User/{UserID}