package com.example.Final.Project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FinancialDAO {
    private JdbcTemplate jdbcTemplate;

    public List<FinancialDB> getFinancials(){
        String sql = "SELECT * from finances";

        List <FinancialDB> financials = jdbcTemplate.query(
                sql,
                new FinancialRowMapper());
        return  financials;


    }


    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
