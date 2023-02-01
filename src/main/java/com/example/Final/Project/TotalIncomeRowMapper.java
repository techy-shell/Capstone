package com.example.Final.Project;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TotalIncomeRowMapper implements RowMapper<TotalIncomeDB> {

    public TotalIncomeDB mapRow (ResultSet rs, int rowNum) throws SQLException {
        TotalIncomeDB totalIncomeDB = new TotalIncomeDB();
        totalIncomeDB.setTotalIncome(rs.getInt("TotalIncome"));
        return totalIncomeDB;

    }
}