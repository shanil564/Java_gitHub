package com.example.demo.entity;

import com.example.demo.Constants;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "attendence")
@Getter
@Setter
@ToString
public class Attendence {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @JsonFormat(pattern = Constants.DATE_FORMAT, shape = JsonFormat.Shape.STRING)
    private LocalDate date;
    private boolean status;
    @ManyToOne
    @JsonIgnoreProperties({Constants.ATTENDENCE,Constants.PROJECTS})
    private Employees employee;
}
