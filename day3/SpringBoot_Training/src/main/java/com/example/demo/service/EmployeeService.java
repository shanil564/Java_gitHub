package com.example.demo.service;
import com.example.demo.Constants;
import com.example.demo.entity.AssignProjectDTO;
import com.example.demo.entity.Employees;
import com.example.demo.entity.Projects;
import com.example.demo.repository.EmployeesRepo;
import com.example.demo.repository.ProjectsRepo;
import com.example.demo.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
@org.springframework.stereotype.Service
public class EmployeeService {
    @Autowired
    private EmployeesRepo employeesRepo;
    @Autowired
    private ProjectsRepo projectsRepo;
    public Response addEmployee(Employees employee){
        Response response = new Response();

        if(findByEmployeeId(employee.getEmpId()).size()==0) {
            employeesRepo.save(employee);
            response.setMessage(Constants.MSG_ADDED);
            response.setResult(employee);
            return response;
        }else{
            response.setMessage(Constants.MSG_EXISTS);
            return response;
        }
    }
    public List<Employees> findByEmployeeId(Long id){
        return employeesRepo.findByEmpId(id);
    }
    public Response getEmployeeById(Long id){
        Response response=new Response();
        Optional<Employees> employees=employeesRepo.findById(id);
        if (employees.isPresent()){
            response.setResult(employees);
            return response;
        }else{
            response.setSuccess(false);
            response.setMessage(Constants.MSG_NOT_EXISTS);
            return response;
        }
    }
    public Response getAllEmployee(){
       // Pageable pageable= PageRequest.of(0,2);
        List<Employees> employeeList= employeesRepo.findAll();
        Response response=new Response();
        response.setList(Collections.singletonList(employeeList));
        return response;
    }public Response deleteEmployeeById(Long id){
        Optional<Employees> employees=employeesRepo.findById(id);
        Response response=new Response();
        if (employees.isPresent()){
            employeesRepo.deleteById(id);
            response.setMessage(Constants.MSG_DELETED);
            return response;
        }else{
            response.setSuccess(false);
            response.setMessage(Constants.MSG_NOT_EXISTS);
            return response;
        }
    }
    public Response updateEmployee(Employees employee){
        Response response=new Response();
        if (findByEmployeeId(employee.getEmpId()).size()==0){
            return addEmployee(employee);
        }else{
            Optional<Employees> emp=employeesRepo.findById(employee.getEmpId());
            if (employee.getEmpName()==null){
                employee.setEmpName(emp.get().getEmpName());
            }
            if (employee.getAge()==null){
                employee.setAge(emp.get().getAge());
            }
            employeesRepo.save(employee);
            response.setMessage(Constants.MSG_UPDATED);
            return response;
        }
    }
    public Response assignProject(AssignProjectDTO assignProjectDTO){
        Response response=new Response();
        Projects project = projectsRepo.findById(assignProjectDTO.getProjectId()).orElse(null);
        Employees employee = employeesRepo.findById(assignProjectDTO.getEmpId()).orElse(null);
        if (project != null && employee != null) {
            project.getEmployees().add(employee);
            employee.getProjects().add(project);
            projectsRepo.save(project);
            employeesRepo.save(employee);
            response.setMessage(Constants.MSG_PROJECT_ASSIGNED);
        }
        return response;
    }
}
