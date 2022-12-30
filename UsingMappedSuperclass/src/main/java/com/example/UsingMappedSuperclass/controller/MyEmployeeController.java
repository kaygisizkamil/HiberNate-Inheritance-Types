package com.example.UsingMappedSuperclass.controller;

import com.example.UsingMappedSuperclass.business.MyEmployeeService;
import com.example.UsingMappedSuperclass.entity.MyEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
@RestController
@RequestMapping("/employees")
public class MyEmployeeController {

    @Autowired
    private MyEmployeeService employeeService;

    @PostMapping
    public MyEmployee createMyEmployee(@RequestBody MyEmployee employee) {
        return employeeService.createMyEmployee(employee);
    }

    @GetMapping("/{id}")
    public MyEmployee readMyEmployee(@PathVariable long id) {
        return employeeService.readMyEmployee(id);
    }

    @PutMapping
    public MyEmployee updateMyEmployee(@RequestBody MyEmployee employee) {
        return employeeService.updateMyEmployee(employee);
    }

    @DeleteMapping("/{id}")
    public void deleteMyEmployee(@PathVariable long id) {
        employeeService.deleteMyEmployee(id);
    }
}