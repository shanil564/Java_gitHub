package com.example.springBoot.service;
import com.example.springBoot.departmentRepo.DepartmentRepo;
import com.example.springBoot.departmentResponseBody.DepartmentResponseBody;
import com.example.springBoot.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class DepartmentService {
    @Autowired
    DepartmentRepo departmentRepo;
    public DepartmentResponseBody addDepartment(Department department){
        DepartmentResponseBody response=new DepartmentResponseBody();
        if(getDepartmentByName(department.getDepartmentName()).size()==0) {
            departmentRepo.save(department);
            response.setMessage("department id:" + department.getDepartmentId() + " doesn't exist.so new department added");
            response.setResult(department);
            return response;
        }else {
            response.setSuccess(false);
            response.setMessage("Failed to add department with id: "+department.getDepartmentId()+" error:duplicate elements are not allowed");
            return response;
        }
    }
    public List<Department> getDepartmentByName(String departmentName){
        return departmentRepo.findByDepartmentName(departmentName);
    }
    public List<Department> getAllDepartment() {
          return departmentRepo.findAll();
        }
    public DepartmentResponseBody updateDepartment(Department department) throws Exception{
        Optional<Department> depart= departmentRepo.findById(department.getDepartmentId());
        DepartmentResponseBody response=new DepartmentResponseBody();
        if(depart.isPresent()){
            if (department.getHod()!=null){
                depart.get().setHod(department.getHod());
            }
            if (department.getDepartmentName()!=null){
                depart.get().setDepartmentName(department.getDepartmentName());
            }
            if (department.getStrength()!=null){
                depart.get().setStrength(department.getStrength());
            }
            try {
                departmentRepo.save(depart.get());
            }catch (Exception e){
                response.setMessage("departmentName:"+department.getDepartmentName()+" already exists");
                return response;
            }
                departmentRepo.save(depart.get());
                response.setMessage("department Id:"+depart.get().getDepartmentId()+" is updated...");
                response.setResult(depart.get());
                return response;
        }else {
            return addDepartment(department);
        }
    }
    public DepartmentResponseBody deleteDepartment(Long id){
        DepartmentResponseBody response=new DepartmentResponseBody();
        Optional<Department> depart=departmentRepo.findById(id);
        if (depart.isEmpty()){
            response.setMessage("department id: "+ id +" doesn't exist.");
        }else{
            departmentRepo.deleteById(id);
            response.setMessage("department ID: "+id+" data deleted");
        }
        return response;
    }
    public Map<String, Object> validateRequest(Long id) {
        Map<String,Object> validationResponse = new HashMap<>();
        if(id==null){
            validationResponse.put("isError",true);
            DepartmentResponseBody departmentResponseBody = new DepartmentResponseBody();
            departmentResponseBody.setMessage("departmentId cannot be null");
            departmentResponseBody.setSuccess(false);
            validationResponse.put("response",departmentResponseBody);
        }
        else {
            validationResponse.put("isError",false);
        }
        return validationResponse;
    }
    public Optional<Department> getDepartmentById(Long id) {
        return departmentRepo.findById(id);
    }
}
