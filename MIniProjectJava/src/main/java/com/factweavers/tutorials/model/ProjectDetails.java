package com.factweavers.tutorials.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProjectDetails {
    private long projectId;
    private String projectName;
    public long getProjectId() {
        return projectId;
    }
    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }
    public String getProjectName() {
        return projectName;
    }
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
    @Override
    public String toString() {
        return "ProjectDetails{" +
                "projectId=" + projectId +
                ", projectName='" + projectName + '\'' +
                '}';
    }
}
