package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
public class EmployeeAttendanceDTO {
    private LocalDate startDate;
    private LocalDate endDate;
}
