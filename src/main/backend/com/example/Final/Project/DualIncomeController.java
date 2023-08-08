package com.example.Final.Project;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class DualIncomeController {
    private DualIncomeDAO dualIncomeDAO;

    //Mapping for specific financial info for two users ie /DualIncome/'userID'/'userID' (to use in expenditure calc)
    @RequestMapping("/DualIncome/{userID1}/{userID2}")
    public ResponseEntity<List> retrieveTotalFinancials(@PathVariable int userID1, @PathVariable int userID2) {
        List<DualIncomeDB> income = dualIncomeDAO.getDualIncome(userID1, userID2);
        if (income.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else return new ResponseEntity<>(income,HttpStatus.OK);
    }

    @Autowired
    public void setDualIncomeDAO(DualIncomeDAO dualIncomeDAO) {
        this.dualIncomeDAO = dualIncomeDAO;
    }
}
