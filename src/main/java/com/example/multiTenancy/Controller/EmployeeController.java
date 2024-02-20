package com.example.multiTenancy.Controller;

import com.example.multiTenancy.entity.Employee;
import com.example.multiTenancy.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Employee")
public class EmployeeController {

    @Autowired
    private EmployeeRepo employeeRepo;

    @PostMapping
    public void add(@RequestBody Employee employee) {

        employeeRepo.save(employee);
    }

    @GetMapping
    public List<Employee> get() {
        return employeeRepo.findAll();
    }
}
