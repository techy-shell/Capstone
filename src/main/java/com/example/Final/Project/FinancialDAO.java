package com.example.Final.Project;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FinancialDAO {
    private JdbcTemplate jdbcTemplate;

    public List<FinancialDB> getFinancials(){
        String sql = "SELECT * from Financials";

        List <FinancialDB> financials = jdbcTemplate.query(
                sql,
                new FinancialRowMapper());
        return  financials;


    }
}
