package com.example.Final.Project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class FinancialController {

    private FinancialDAO financialDAO;

@RequestMapping ("/testFinancial")
    public List<FinancialDB> test() {
    return financialDAO.getFinancials();
}



    
@Autowired
public void setFinancialDAO(FinancialDAO financialDAO) {
        this.financialDAO = financialDAO;
    }
}
