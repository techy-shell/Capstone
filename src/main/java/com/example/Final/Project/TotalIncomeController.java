package com.example.Final.Project;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class TotalIncomeController {

    private TotalIncomeDAO totalIncomeDAO;

    @RequestMapping("/TotalIncome/{userID}")
    public ResponseEntity<List> retrieveTotalFinancials(@PathVariable int userID) {
        List<TotalIncomeDB> income = totalIncomeDAO.getTotalIncome(userID);
        if (income.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else return new ResponseEntity<>(income,HttpStatus.OK);
    }
}
