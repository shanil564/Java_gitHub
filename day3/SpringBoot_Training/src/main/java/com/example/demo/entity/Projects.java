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
@Table(name = Constants.PROJECTS)
@Getter
@Setter
@ToString
public class Projects {
    @Id
    private Long projectId;
    private String projectName;
    @ManyToMany(mappedBy = Constants.PROJECTS)
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = Constants.EMP_ID)
    @JsonIgnoreProperties(Constants.PROJECTS)
    private List<Employees> employees;
}
