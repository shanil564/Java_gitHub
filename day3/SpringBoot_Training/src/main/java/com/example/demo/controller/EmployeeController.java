package com.example.demo.controller;

import com.example.demo.Constants;
import com.example.demo.entity.AssignProjectDTO;
import com.example.demo.entity.Employees;
import com.example.demo.response.Response;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(Constants.COMPANY_PATH+Constants.EMPLOYEE_PATH)
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @PreAuthorize(Constants.HAS_AUTHORITY_WRITE)
    @PostMapping
    public Response addEmployee(@RequestBody Employees employee){
        return  employeeService.addEmployee(employee);
    }
    @PreAuthorize(Constants.HAS_AUTHORITY_READ)
    @GetMapping("/{id}")
    public Response getEmployeeById(@PathVariable Long id){
        return employeeService.getEmployeeById(id);
    }
    @PreAuthorize(Constants.HAS_AUTHORITY_WRITE)
    @GetMapping
    public Response getAllEmployee(){
        return employeeService.getAllEmployee();
    }
    @PreAuthorize(Constants.HAS_AUTHORITY_WRITE)
    @PutMapping
    public Response updateEmployee(@RequestBody Employees employee){
        return employeeService.updateEmployee(employee);
    }
    @PreAuthorize(Constants.HAS_AUTHORITY_WRITE)
   @DeleteMapping(Constants.PATH_VARIABLE_ID)
   public Response deleteEmployeeById(@PathVariable Long id){
       return employeeService.deleteEmployeeById(id);
   }
    @PreAuthorize(Constants.HAS_AUTHORITY_WRITE)
   @PostMapping(Constants.ASSIGN_PROJECT_PATH)
    public Response assignProject(@RequestBody AssignProjectDTO assignProjectDTO){
        return employeeService.assignProject(assignProjectDTO);
   }
}
