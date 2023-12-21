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
@Table(name = "projects")
@Getter
@Setter
@ToString
public class Projects {
    @Id
    private Long projectId;
    private String projectName;
    @ManyToMany(mappedBy = "projects")
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "empId")
    @JsonIgnoreProperties("projects")
    private List<Employees> employees;
}
