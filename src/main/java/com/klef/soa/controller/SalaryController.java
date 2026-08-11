package com.klef.soa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.klef.soa.entity.Salary;
import com.klef.soa.service.SalaryService;

@RestController
@RequestMapping("/salary")
public class SalaryController {

    @Autowired
    private SalaryService service;

    // Test
    @GetMapping("/")
    public String test() {
        return "SOA Programming & MicroServices";
    }

   
    @PostMapping("/add")
    public ResponseEntity<Salary> addSalary(@RequestBody Salary salary) {

        Salary s = service.addSalary(salary);

        return ResponseEntity.status(201).body(s);
    }


    @GetMapping("/displayall")
    public ResponseEntity<List<Salary>> displayAllSalaries() {

        List<Salary> salaries = service.displayAll();

        return ResponseEntity.status(200).body(salaries);
    }

  
    @GetMapping("/display")
    public ResponseEntity<?> displaySalaryById(@RequestParam Long id) {

        Salary salary = service.displayById(id);

        if (salary != null) {
            return ResponseEntity.status(200).body(salary);
        } else {
            return ResponseEntity.status(404).body("Salary ID Not Found");
        }
    }

    
    @PutMapping("/update")
    public ResponseEntity<?> updateSalary(@RequestBody Salary salary) {

        Salary s = service.updateSalary(salary);

        if (s != null) {
            return ResponseEntity.ok(s);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Salary ID Not Found");
        }
    }

    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteSalaryById(@PathVariable Long id) {

        String message = service.deleteById(id);

        return new ResponseEntity<>(message, HttpStatus.OK);
    }

  
    @GetMapping("/displaybyname/{sname}")
    public ResponseEntity<List<Salary>> displaySalariesByName(
            @PathVariable String sname) {

        List<Salary> salaries = service.findByName(sname);

        return ResponseEntity.status(200).body(salaries);
    }

    
    @GetMapping("/displaybytype/{type}")
    public ResponseEntity<List<Salary>> displaySalariesByType(
            @PathVariable String type) {

        List<Salary> salaries = service.findByType(type);

        return ResponseEntity.status(200).body(salaries);
    }
}