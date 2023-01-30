package com.example.Final.Project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class FinancialController {

    private FinancialDAO financialDAO;

@RequestMapping ("/Financial")
    public List<FinancialDB> test() {
    return financialDAO.getFinancials();
}

//Add request mapping for specific financial info for one user ie /Financial/'username' (to fill in forms - budget & benefits)

//Add put mapping to add financial data into databse for one user (other income etc)
    
@Autowired
public void setFinancialDAO(FinancialDAO financialDAO) {
        this.financialDAO = financialDAO;
    }
}

//URL for all data for Financials help https://localhost:8080/Financial