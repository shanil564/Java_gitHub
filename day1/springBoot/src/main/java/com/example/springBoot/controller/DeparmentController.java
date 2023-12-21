package com.example.springBoot.controller;
import com.example.springBoot.departmentResponseBody.DepartmentResponseBody;
import com.example.springBoot.model.Department;
//import com.example.springBoot.service.DepartmentService;
import com.example.springBoot.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;
@Slf4j
@RestController
@RequestMapping("/department")
public class DeparmentController {
    @Autowired
    DepartmentService departmentService;
    @PreAuthorize("hasAuthority('WRITE')")
    @PostMapping
    public DepartmentResponseBody addDepartment(@RequestBody Department department){
        Map<String,Object> errorMap = departmentService.validateRequest(department.getDepartmentId());
        if(!(boolean) errorMap.get("isError")) {
       return departmentService.addDepartment(department);
        }else {
            return (DepartmentResponseBody) errorMap.get("response");
        }
    }
    @PreAuthorize("hasAuthority('READ')")
    @GetMapping("/id/{id}")
    public Department fetchDepartmentByid(@PathVariable Long id){
        return departmentService.getDepartmentById(id).get();
    }
    @PreAuthorize("hasAuthority('READ')")
    @GetMapping("/{departmentName}")
    public List<Department> fetchDepartment(@PathVariable String departmentName){
            return departmentService.getDepartmentByName(departmentName);
    }
    @PreAuthorize("hasAuthority('READ')")
    @GetMapping
    public List<Department> getDepartment(){
            return departmentService.getAllDepartment();
    }
    @PutMapping
    public DepartmentResponseBody updateDepartment(@RequestBody Department department) throws Exception {
        return departmentService.updateDepartment(department);

    }
    @PreAuthorize("hasAuthority('WRITE')")
    @DeleteMapping("/{id}")
    public DepartmentResponseBody deleteDepartment(@PathVariable Long id){
        Map<String,Object> errorMap = departmentService.validateRequest(id);
        if(!(boolean) errorMap.get("isError")) {
            return departmentService.deleteDepartment(id);
        }else {
            return (DepartmentResponseBody) errorMap.get("response");
        }
    }
}
