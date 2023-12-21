package com.example.demo.entity;
import com.fasterxml.jackson.annotation.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "employees")
@Getter
@Setter
@ToString
public class Employees {
    @Id
    private Long empId;
    private String empName;
    private Long age;
    @ManyToMany
    @JoinTable(name = "assignProject",
            joinColumns = @JoinColumn(name = "employeeId"),
            inverseJoinColumns = @JoinColumn(name = "projectId"))
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "projectId")
    @JsonIgnoreProperties(value="employees")
    private List<Projects> projects;
    @OneToMany(mappedBy = "employee")
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIgnoreProperties(value="employee")
    private List<Attendence> attendence;
}
