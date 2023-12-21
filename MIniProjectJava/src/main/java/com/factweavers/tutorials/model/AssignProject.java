package com.factweavers.tutorials.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AssignProject {
    private long assignProjectId;
    private long employeeId;
    private long projectId;

    public long getAssignProjectId() {
        return assignProjectId;
    }

    public void setAssignProjectId(long assignProjectId) {
        this.assignProjectId = assignProjectId;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    @Override
    public String toString() {
        return "AssignProject{" +
                "assignProjectId=" + assignProjectId +
                ", employeeId=" + employeeId +
                ", projectId=" + projectId +
                '}';
    }
}
