package com.example.demo.entity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
public class MarkAttendance {
    private Long empId;
    private LocalDate date;
    private Boolean isPresent;
}
