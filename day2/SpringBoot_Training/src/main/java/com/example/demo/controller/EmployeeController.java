package com.example.demo.controller;

import com.example.demo.entity.AssignProjectDTO;
import com.example.demo.entity.Employees;
import com.example.demo.response.Response;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/company/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @PreAuthorize("hasAuthority('WRITE')")
    @PostMapping
    public Response addEmployee(@RequestBody Employees employee){
        return  employeeService.addEmployee(employee);
    }
    @PreAuthorize("hasAuthority('READ')")
    @GetMapping("/{id}")
    public Response getEmployeeById(@PathVariable Long id){
        return employeeService.getEmployeeById(id);
    }
    @PreAuthorize("hasAuthority('WRITE')")
    @GetMapping
    public Response getAllEmployee(){
        return employeeService.getAllEmployee();
    }
    @PreAuthorize("hasAuthority('WRITE')")
    @PutMapping
    public Response updateEmployee(@RequestBody Employees employee){
        return employeeService.updateEmployee(employee);
    }
    @PreAuthorize("hasAuthority('WRITE')")
   @DeleteMapping("/{id}")
   public Response deleteEmployeeById(@PathVariable Long id){
       return employeeService.deleteEmployeeById(id);
   }
    @PreAuthorize("hasAuthority('WRITE')")
   @PostMapping("/assignProject")
    public Response assignProject(@RequestBody AssignProjectDTO assignProjectDTO){
        return employeeService.assignProject(assignProjectDTO);
   }
}
