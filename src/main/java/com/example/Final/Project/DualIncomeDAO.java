package com.example.Final.Project;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DualIncomeDAO {

    private JdbcTemplate jdbcTemplate;
    public List<DualIncomeDB> getDualIncome(int userID1, int userID2){
        String sql = "SELECT SUM(MonthlyPay) + SUM(Benefits) as DualIncome from finances WHERE UserID = " + userID1 + " OR UserID = " + userID2;

        List <DualIncomeDB> dualFinancials = jdbcTemplate.query(
                sql,
                new DualIncomeRowMapper());
        return  dualFinancials;
    }
    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

}
