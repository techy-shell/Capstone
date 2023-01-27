package com.example.Final.Project;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FinancialRowMapper implements RowMapper<FinancialDB> {

    public FinancialDB mapRow (ResultSet rs, int rowNum) throws SQLException {
        FinancialDB financialDB = new FinancialDB();
        //check column names
        financialDB.setSalary(rs.getInt("MonthlyNetPay"));
        financialDB.setUserName(rs.getInt("UserID"));
        financialDB.setMortgage(rs.getInt("MortgageOrRent"));
        financialDB.setBills(rs.getInt("Bills"));
        return financialDB;

    }
}
