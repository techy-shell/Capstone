package com.example.Final.Project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAO {

    private JdbcTemplate jdbcTemplate;

    public List<UserDB> getUsers() {
        String sql = "SELECT * from users";

        List<UserDB> users = jdbcTemplate.query(
                sql,
                new UserRowMapper());
        return users;
    }

    public List<UserDB> getUserInfo(int userID) {
        String sql = "SELECT * FROM Users WHERE UserID = " + "'" + userID + "'";

        List<UserDB> userInfo = jdbcTemplate.query(
                sql,
                new UserRowMapper());
        return userInfo;
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
