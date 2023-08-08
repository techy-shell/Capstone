package com.example.Final.Project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class FinancialDAO {
    private JdbcTemplate jdbcTemplate;

    //SQL query to pull all info from Finances table in database

    public List<FinancialDB> getFinancials(){
        String sql = "SELECT * from finances";

        List <FinancialDB> financials = jdbcTemplate.query(
                sql,
                new FinancialRowMapper());
        return  financials;
    }

    //SQL query to pull all info for a specific user from Finances table in database
    public List<FinancialDB> getUserFinancials(int userID){
        String sql = "SELECT * from finances WHERE UserID = " + userID;

        List <FinancialDB> userFinancials = jdbcTemplate.query(
                sql,
                new FinancialRowMapper());
        return  userFinancials;
    }

    //method to update finances table in database
    public void updateSalary (int x, int customerID, int benefit) {
        String sql = "UPDATE Finances set MonthlyPay = " + x + ", benefits = "+benefit+" Where UserID = " + customerID;
        jdbcTemplate.update(sql);
    }
    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
