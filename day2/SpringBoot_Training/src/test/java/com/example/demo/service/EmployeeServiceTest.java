package com.example.demo.service;
import com.example.demo.entity.Employees;
import com.example.demo.repository.EmployeesRepo;
import com.example.demo.response.Response;
import org.h2.command.dml.MergeUsing;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceTest {
    @Mock
    EmployeesRepo employeesRepo;
    @InjectMocks
    EmployeeService employeeService;
    @Test
    public void addEmployeeTestForEmployeeExist(){
        Employees employees=new Employees();
        employees.setEmpId(1L);
        employees.setEmpName("testName");
        when(employeesRepo.findByEmpId(any())).thenReturn(Collections.emptyList());
        Response response=employeeService.addEmployee(employees);
        Assert.assertEquals("employeeId: 1 data added",response.getMessage());
    }
    @Test
    public void addEmployeeTestForEmployeeNotExist(){
        Employees employees=new Employees();
        employees.setEmpId(1L);
        employees.setEmpName("testName");
        List<Employees> nonEmptyList= Arrays.asList(new Employees(),new Employees());
        when(employeesRepo.findByEmpId(any())).thenReturn(nonEmptyList);
        Response response=employeeService.addEmployee(employees);
        Assert.assertEquals("employee Details already exists....",response.getMessage());
    }


}
