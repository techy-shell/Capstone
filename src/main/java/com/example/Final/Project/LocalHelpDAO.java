package com.example.Final.Project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import java.util.List;
@Repository
public class LocalHelpDAO {

    private JdbcTemplate jdbcTemplate;

    public List<LocalHelpDB> getLocalHelp(){
        String sql = "SELECT * from LocalHelp";

        List <LocalHelpDB> localHelp = jdbcTemplate.query(
                sql,
                new LocalHelpRowMapper());
        return  localHelp;


    }


    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
