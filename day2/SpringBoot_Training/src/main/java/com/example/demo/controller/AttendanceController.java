package com.example.demo.controller;

import com.example.demo.entity.Attendence;
import com.example.demo.entity.EmployeeAttendanceDTO;
import com.example.demo.entity.MarkAttendance;
import com.example.demo.response.Response;
import com.example.demo.service.AttendenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/company/attendance")
public class AttendanceController {
    @Autowired
    AttendenceService attendenceService;
    @PreAuthorize("hasAuthority('READ')")
    @PostMapping
    public Response markAttendance(@RequestBody MarkAttendance markAttendance){
        return attendenceService.markAttendance(markAttendance);
    }
    /*@GetMapping("/{date}")
    public Response getAttendanceByDate(@PathVariable("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date){
        return attendenceService.getAttendanceByDate(date);
    }*/
    @PreAuthorize("hasAuthority('READ')")
    @PostMapping("/date")
    public Response getAttendanceByDate(@RequestBody EmployeeAttendanceDTO employeeAttendanceDTO){
        return attendenceService.getAttendanceByDate(employeeAttendanceDTO.getStartDate());
    }
    @PreAuthorize("hasAuthority('READ')")
    @PostMapping("/{empId}")
    public Response employeeAttendanceBetweenStartAndEndDate(@PathVariable Long empId, @RequestBody EmployeeAttendanceDTO employeeAttendanceDTO){
        return attendenceService.employeeAttendanceBetweenStartAndEndDate(empId,employeeAttendanceDTO);
    }
}
