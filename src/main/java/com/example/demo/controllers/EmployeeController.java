package com.example.demo.controllers;

import com.example.demo.DTOs.EmployeeDTO;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping(path = "/emp") // base path for all endpoints
public class EmployeeController {

    // Simple GET Endpoint
    @GetMapping("/hello")
    public String greet() {
        return "Hello Mr. John";
    }

    // Get Variable Endpoint
    @GetMapping("/UserName/{id}")
    public String userID(@PathVariable int id) {
        return "User Name " + id;
    }

    // Return full DTO object
    @GetMapping("/employee/ID/{ID}")
    public EmployeeDTO employeeByID(@PathVariable Long ID) {
        return new EmployeeDTO(
                ID,
                "Shashank",
                "abc@gmail",
                "#234@#$",
                23,
                LocalDate.of(2025, 12, 20),
                true
        );
    }

    // Return only specific field (like name)
    @GetMapping("/employee/UserName/{UserName}")
    public String employeeByUserName(@PathVariable String UserName) {
        EmployeeDTO obj = new EmployeeDTO(
                10L,
                UserName,
                "abc@gmail",
                "#234@#$",
                23,
                LocalDate.of(2025, 12, 20),
                true
        );
        return obj.getName();
    }

    // Use of Request Parameters (query params)
    @GetMapping
    public String name(
            @RequestParam(required = false) String Name,
            @RequestParam(required = false, defaultValue = "0") int Age
    ) {
        return "Hi " + Name + " " + Age;
    }

    // Example of POST with RequestBody
    @PostMapping
    public EmployeeDTO createNewEmp(@RequestBody EmployeeDTO inputEmp) {
        inputEmp.setId(100L); // set ID manually
        return inputEmp;
    }
}
