package com.example.demo.entity;
import com.example.demo.Constants;
import com.fasterxml.jackson.annotation.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = Constants.EMPLOYEES)
@Getter
@Setter
@ToString
public class Employees {
    @Id
    private Long empId;
    private String empName;
    private Long age;
    @ManyToMany
    @JoinTable(name = Constants.ASSIGN_PROJECT,
            joinColumns = @JoinColumn(name = Constants.EMPLOYEE_ID),
            inverseJoinColumns = @JoinColumn(name = Constants.PROJECT_ID))
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = Constants.PROJECT_ID)
    @JsonIgnoreProperties(value=Constants.EMPLOYEES)
    private List<Projects> projects;
    @OneToMany(mappedBy = Constants.EMPLOYEE)
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = Constants.ID)
    @JsonIgnoreProperties(value= Constants.EMPLOYEE)
    private List<Attendence> attendence;
}
