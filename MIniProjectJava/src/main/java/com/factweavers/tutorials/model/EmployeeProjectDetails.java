package com.factweavers.tutorials.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.ArrayList;
import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeeProjectDetails {
        private EmployeeDetails employee;
        private ProjectDetails project;
        private List<EmployeeDetails> employeeList= new ArrayList<>();
    public EmployeeDetails getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeDetails employee) {
        this.employee = employee;
    }

    public ProjectDetails getProject() {
        return project;
    }

    public void setProject(ProjectDetails project) {
        this.project = project;
    }

    public List<EmployeeDetails> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<EmployeeDetails> employeeList) {
        this.employeeList = employeeList;
    }
    @Override
    public String toString() {
        return "employeeProjectDetails{" +
                "employee=" + employee +
                ", project=" + project +
                ", employeeList=" + employeeList +
                '}';
    }
}
