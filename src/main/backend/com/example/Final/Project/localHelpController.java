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
public class localHelpController {

    private LocalHelpDAO localHelpDAO;

    @RequestMapping("/localhelp")
    public List<LocalHelpDB> retreiveLocalHelp (){
        return localHelpDAO.getLocalHelp();
    }

    //Request mapping to pull local help info from database using city at reference ie /localhelp/'cityname'
    @RequestMapping("/localhelp/{CityID}")
    public ResponseEntity<List> retrieveLocalInfo(@PathVariable String CityID) {
        List<LocalHelpDB> localHelpDBList = localHelpDAO.getLocalInfo(CityID);
        if (localHelpDBList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else return new ResponseEntity<>(localHelpDBList,HttpStatus.OK);
    }
    @Autowired
    public void setLocalHelpDAO(LocalHelpDAO localHelpDAO) {
        this.localHelpDAO = localHelpDAO;
    }
}

//URL for all data for Local help https://localhost:8080/localhelp