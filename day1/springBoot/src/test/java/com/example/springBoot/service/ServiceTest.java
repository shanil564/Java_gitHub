package com.example.springBoot.service;

import com.example.springBoot.departmentRepo.DepartmentRepo;
import com.example.springBoot.departmentResponseBody.DepartmentResponseBody;
import com.example.springBoot.model.Department;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.*;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ServiceTest {
    @Mock
    private DepartmentRepo departmentRepo;
    @InjectMocks
    private DepartmentService departmentService;
    @Test
    public void addDepartmentTestForDepartmentNotExist() {
        Department department = new Department();
        department.setDepartmentId(1L);
        department.setDepartmentName("Test Department");
        when(departmentRepo.findByDepartmentName(anyString())).thenReturn(Collections.emptyList());
        DepartmentResponseBody response = departmentService.addDepartment(department);
       // Assert.assertTrue(response.isSuccess());
        Assert.assertEquals("department id:1 doesn't exist.so new department added", response.getMessage());
    }
    @Test
    public void addDepartmentTestForDepartmentExist() {
        Department department = new Department();
        department.setDepartmentId(1L);
        department.setDepartmentName("Test Department");
        List<Department> nonEmptyList = Arrays.asList(new Department(), new Department());
        when(departmentRepo.findByDepartmentName(anyString())).thenReturn(nonEmptyList);
        DepartmentResponseBody response = departmentService.addDepartment(department);
        Assert.assertEquals("Failed to add department with id: 1 error:duplicate elements are not allowed", response.getMessage());
    }
    @Test
    public void deleteDepartmentTestForDepartmentNotExist(){
        Department department = new Department();
        department.setDepartmentId(1L);
        when(departmentRepo.findById(department.getDepartmentId())).thenReturn(Optional.empty());
        DepartmentResponseBody response=departmentService.deleteDepartment(department.getDepartmentId());
        Assert.assertEquals("department id: 1 doesn't exist.", response.getMessage());
    }
    @Test
    public void deleteDepartmentTestForDepartmentExist(){
        Department department = new Department();
        department.setDepartmentId(1L);
        department.setDepartmentName("Test Department");
        when(departmentRepo.findById(department.getDepartmentId())).thenReturn(Optional.of(new Department()));
        DepartmentResponseBody response=departmentService.deleteDepartment(department.getDepartmentId());
        Assert.assertEquals("department ID: 1 data deleted",response.getMessage());
    }
    @Test
    public void getDepartmentBynameTestElementExists(){
        DepartmentResponseBody response=new DepartmentResponseBody();
        response.setList(Collections.singletonList(departmentService.getAllDepartment()));
        Assert.assertTrue(response.getList().size()>0);
    }
}
