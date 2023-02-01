package com.example.Final.Project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TotalIncomeDAO {
    private JdbcTemplate jdbcTemplate;

    public List<TotalIncomeDB> getTotalIncome(int userID){
        String sql = "SELECT SUM(MonthlyPay) + SUM(Benefits) as TotalIncome from finances WHERE UserID = " + userID;

        List <TotalIncomeDB> totalFinancials = jdbcTemplate.query(
                sql,
                new TotalIncomeRowMapper());
        return  totalFinancials;
    }
    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
