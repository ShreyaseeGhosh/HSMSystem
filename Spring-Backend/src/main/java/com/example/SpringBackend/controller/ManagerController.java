package com.example.SpringBackend.controller;

import java.util.List;

import com.example.SpringBackend.database.entities.Residences;
import com.example.SpringBackend.database.entities.Residents;
import com.example.SpringBackend.services.ResidenceService;
import com.example.SpringBackend.services.ResidentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/manager")
public class ManagerController {
    
    @Autowired
    private ResidenceService residenceService;

    @Autowired
    private ResidentService residentService;

    @GetMapping("/residences/id/{id}")
    public ResponseEntity<Residences> getResidenceById(@PathVariable long id){
        Residences residences = residenceService.getResidenceById(id);
        if(residences == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(residences, HttpStatus.OK);
    }

    @GetMapping("/residences/tower/{towerId}")
    public ResponseEntity<List<Residences>> getResidencesByTower(@PathVariable int towerId){
        List<Residences> residences = residenceService.getResidencesByTower(towerId);
        if(residences == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(residences, HttpStatus.OK);
    }
    
    @GetMapping("/residences/flat/{flatNo}")
    public ResponseEntity<Residences> getResidenceByFlatNo(@PathVariable String flatNo){
        Residences residences = residenceService.getResidenceByFlatNo(flatNo);
        if(residences == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(residences, HttpStatus.OK);
    }

    @GetMapping("/residents/tower/{towerId}")
    public ResponseEntity<List<Residents>> getResidentsByTower(@PathVariable int towerId){
        List<Residents> residents = residentService.getAllResidentsByTower(towerId);
        return new ResponseEntity<>(residents, HttpStatus.OK);
    }
    
}
