package com.example.demo.service;

import com.example.demo.entity.*;
import com.example.demo.repository.AttendenceRepo;
import com.example.demo.repository.EmployeesRepo;
import com.example.demo.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AttendenceService {
    @Autowired
     private AttendenceRepo attendenceRepo;
    @Autowired
    EmployeesRepo employeesRepo;
    public Response markAttendance(MarkAttendance markAttendance) {
        Response response = new Response();
        Optional<Employees> employees = employeesRepo.findById(markAttendance.getEmpId());
        Attendence attendence=new Attendence();
        if (employees.isPresent()) {
            attendence.setStatus(markAttendance.getIsPresent());
            employees.get().getAttendence().add(attendence);
            attendence.setEmployee(employees.get());
            attendence.setDate(markAttendance.getDate());
            attendenceRepo.save(attendence);
            employeesRepo.save(employees.get());
            response.setMessage("attendance marked");
            return response;
        }
        return null;
    }
    public Response getAttendanceByDate(LocalDate date){
        List<Attendence> attendence=attendenceRepo.findByDate(date);
        Response response=new Response();
        response.setList(Collections.singletonList(attendence));
        return response;
    }
    public Response employeeAttendanceBetweenStartAndEndDate(Long empId, EmployeeAttendanceDTO employeeAttendanceDTO) {
        List<Attendence> attendences=attendenceRepo.findByEmployeeEmpIdAndDateBetween(empId,employeeAttendanceDTO.getStartDate(),employeeAttendanceDTO.getEndDate());
        Response response=new Response();
        response.setList(Collections.singletonList(attendences));
        return response;
    }
}
