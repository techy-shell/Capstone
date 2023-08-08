package com.example.Final.Project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import java.util.List;
@Repository
public class LocalHelpDAO {

    private JdbcTemplate jdbcTemplate;

    //SQL query to pull all info from LocalHelp table in database

    public List<LocalHelpDB> getLocalHelp(){
        String sql = "SELECT * from LocalHelp";

        List <LocalHelpDB> localHelp = jdbcTemplate.query(
                sql,
                new LocalHelpRowMapper());
        return  localHelp;
    }

    //SQL query to pull info for a specific city from LocalHelp table in database

    public List<LocalHelpDB> getLocalInfo(String CityID) {
        String sql = "SELECT * FROM LocalHelp WHERE CityID = " + "'" + CityID + "'";

        List<LocalHelpDB> localInfo = jdbcTemplate.query(
                sql,
                new LocalHelpRowMapper());
        return localInfo;
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
