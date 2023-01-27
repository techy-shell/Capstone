package com.example.Final.Project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class localHelpController {

    private LocalHelpDAO localHelpDAO;

    @RequestMapping("/localhelptest")
    public List<LocalHelpDB> test (){
        return localHelpDAO.getLocalHelp();
    }

    @Autowired
    public void setLocalHelpDAO(LocalHelpDAO localHelpDAO) {
        this.localHelpDAO = localHelpDAO;
    }
}
