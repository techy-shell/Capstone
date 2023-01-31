package com.example.Final.Project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class FinancialController {

    private FinancialDAO financialDAO;

@RequestMapping ("/Financial")
    public List<FinancialDB> retreieveFinancials() {
    return financialDAO.getFinancials();
}

//Add request mapping for specific financial info for one user ie /Financial/'username' (to fill in forms - budget & benefits)
@RequestMapping ("/Financial/{UserID}")
public List<FinancialDB> retreieveUserFinancials(@PathVariable int UserID) {
    return financialDAO.getUserFinancials(UserID);
}
//Add put mapping to add financial data into databse for one user (other income etc)

    @RequestMapping ("/update")
    public ResponseEntity<Integer> updateFinancial (@RequestBody FinancialDB requestFinancial) {
    financialDAO.updateSalary(requestFinancial.getSalary(), requestFinancial.getUserName());
    return new ResponseEntity<Integer>(HttpStatus.OK);

    }
    
@Autowired
public void setFinancialDAO(FinancialDAO financialDAO) {
        this.financialDAO = financialDAO;
    }
}

//URL for all data for Financials help https://localhost:8080/Financial