package com.example.demo.service;
import com.example.demo.entity.Attendence;
import com.example.demo.entity.Employees;
import com.example.demo.entity.MarkAttendance;
import com.example.demo.repository.AttendenceRepo;
import com.example.demo.repository.EmployeesRepo;
import com.example.demo.response.Response;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AttendenceServiceTest {
    @Mock
    AttendenceRepo attendenceRepo;
    @Mock
    EmployeesRepo employeesRepo;
    @InjectMocks
    AttendenceService attendenceService;
    @Test
    public void markAttendanceTestForEmpExist(){
        MarkAttendance markAttendance=new MarkAttendance();
        markAttendance.setEmpId(1L);
        markAttendance.setDate(LocalDate.parse("2345-03-04"));
        markAttendance.setIsPresent(true);
        when(employeesRepo.findById(any())).thenReturn( Optional.of(new Employees()));
        Response response=attendenceService.markAttendance(markAttendance);
        Assert.assertEquals("attendance marked",response.getMessage());
    }
    @Test
    public void getAttendanceByDateTest(){
        List<Attendence> attendences= Arrays.asList(new Attendence(),new Attendence());
        when(attendenceRepo.findByDate(any())).thenReturn(attendences);
        Response response=attendenceService.getAttendanceByDate(LocalDate.parse("3234-05-05"));
        Assert.assertTrue(response.isSuccess());

    }
}
