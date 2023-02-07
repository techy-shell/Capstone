package com.example.Final.Project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAO {

    private JdbcTemplate jdbcTemplate;

    //SQL query to pull all info from Users table in database

    public List<UserDB> getUsers() {
        String sql = "SELECT * from users";

        List<UserDB> users = jdbcTemplate.query(
                sql,
                new UserRowMapper());
        return users;
    }

    //SQL query to pull all info for a specific user from Users table in database

    public List<UserDB> getUserInfo(int userID) {
        String sql = "SELECT * FROM Users WHERE UserID = " + "'" + userID + "'";

        List<UserDB> userInfo = jdbcTemplate.query(
                sql,
                new UserRowMapper());
        return userInfo;
    }

//either use Tel or Email for contactMethod
    public void updateContactRequest (int userID, String contactMethod) {
        String sql = "UPDATE Users set ContactRequest = " + contactMethod + " Where UserID = " + userID;
        jdbcTemplate.update(sql);
    }
    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
