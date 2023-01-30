package com.example.Final.Project;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LocalHelpRowMapper implements RowMapper<LocalHelpDB> {

    public LocalHelpDB mapRow (ResultSet rs, int rowNum) throws SQLException {
       LocalHelpDB localHelpDB = new LocalHelpDB();
       localHelpDB.setDescription(rs.getString("Info"));
       localHelpDB.setCityID(rs.getString("CityID"));
       localHelpDB.setSupportName(rs.getString("SupportName"));
        return localHelpDB;
    }
}
