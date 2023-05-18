package com.example.firstexample.controller;

import com.example.firstexample.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @GetMapping("/private")
    public String forPrivate(){
        return "Hello, from private test";
    }

    @GetMapping("/public")
    public String forPublic(){
        return employeeService.getMyAuthorities("Adel");
    }
    @GetMapping("/check")
    public void checkAuthority(){
        employeeService.checkAuthority();
    }

    @GetMapping("/api/public")
    public String forPublicApi() {
        return "Hello API, Everyone!";
    }

    @GetMapping("/api/private")
    public String forPrivateApi() {
        return "Hello API, Users!";
    }
}
