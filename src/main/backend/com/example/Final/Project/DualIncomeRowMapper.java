package com.example.Final.Project;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DualIncomeRowMapper implements RowMapper<DualIncomeDB> {

    public DualIncomeDB mapRow(ResultSet rs, int rowNum) throws SQLException {
        DualIncomeDB dualIncomeDB = new DualIncomeDB();
        dualIncomeDB.setDualIncome(rs.getInt("DualIncome"));
        return dualIncomeDB;
    }
}