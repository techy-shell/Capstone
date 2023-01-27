package com.example.Final.Project;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<UserDB> {
    public UserDB mapRow(ResultSet rs, int rowNum) throws SQLException {
        UserDB userDB = new UserDB();
        //check column names
        userDB.setUserID(rs.getInt("UserID"));
        userDB.setFirstName(rs.getString("FirstName"));
        userDB.setSurname(rs.getString("Surname"));
        userDB.setPostcode(rs.getString("Postcode"));
        userDB.setEmail(rs.getString("Email"));
        userDB.setTel(rs.getString("Tel"));
        return userDB;


    }
}
