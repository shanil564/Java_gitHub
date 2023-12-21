package com.factweavers.tutorials.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeeDetails {
    private long employeeId;
    private String employeeName;
    public long getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
    public String getEmployeeName() {
        return employeeName;
    }
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    @Override
    public String toString() {
        return "EmployeeDetails{" +
                "employeeId=" + employeeId +
                ", employeeName='" + employeeName + '\'' +
                '}';
    }
}
