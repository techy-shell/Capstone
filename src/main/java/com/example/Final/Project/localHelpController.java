package com.example.Final.Project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class localHelpController {

    private LocalHelpDAO localHelpDAO;

    @RequestMapping("/localhelp")
    public List<LocalHelpDB> retreiveLocalHelp (){
        return localHelpDAO.getLocalHelp();
    }

    //Add request mapping to pull local help info from datatbase using city at reference ie /localhelp/'cityname'
    @RequestMapping("/localhelp/{CityID}")
    public List<LocalHelpDB> retrieveLocalInfo(@PathVariable String CityID) {
        return localHelpDAO.getLocalInfo(CityID);
    }
    @Autowired
    public void setLocalHelpDAO(LocalHelpDAO localHelpDAO) {
        this.localHelpDAO = localHelpDAO;
    }
}

//URL for all data for Local help https://localhost:8080/localhelp