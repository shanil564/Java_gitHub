package com.example.demo.controller;

import com.example.demo.Constants;
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
@RequestMapping(Constants.COMPANY_PATH+Constants.ATTENDANCE)
public class AttendanceController {
    @Autowired
    AttendenceService attendenceService;
    @PreAuthorize(Constants.HAS_AUTHORITY_READ)
    @PostMapping
    public Response markAttendance(@RequestBody MarkAttendance markAttendance){
        return attendenceService.markAttendance(markAttendance);
    }
    @PreAuthorize(Constants.HAS_AUTHORITY_READ)
    @PostMapping(Constants.DATE)
    public Response getAttendanceByDate(@RequestBody EmployeeAttendanceDTO employeeAttendanceDTO){
        return attendenceService.getAttendanceByDate(employeeAttendanceDTO.getStartDate());
    }
    @PreAuthorize(Constants.HAS_AUTHORITY_READ)
    @PostMapping(Constants.PATH_EMP_ID)
    public Response employeeAttendanceBetweenStartAndEndDate(@PathVariable Long empId, @RequestBody EmployeeAttendanceDTO employeeAttendanceDTO){
        return attendenceService.employeeAttendanceBetweenStartAndEndDate(empId,employeeAttendanceDTO);
    }
}
