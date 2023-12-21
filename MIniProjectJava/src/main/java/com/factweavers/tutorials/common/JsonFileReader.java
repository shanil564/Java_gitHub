package com.factweavers.tutorials.common;
import com.factweavers.tutorials.model.AssignProject;
import com.factweavers.tutorials.model.EmployeeDetails;
import com.factweavers.tutorials.model.ProjectDetails;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
public class JsonFileReader {
    private JsonParser jsonParser=new JsonParser();
    private ObjectMapper objectMapper=new ObjectMapper();
    public List<ProjectDetails> projectList=new ArrayList<>();
    private static List<EmployeeDetails> employeeList=new ArrayList<>();
    private static List<AssignProject> assignProjectList=new ArrayList<>();

    public List<EmployeeDetails> jsonFileToEmployeeDetails(String path) throws Exception{
        Object obj = jsonParser.parse(new FileReader(path));
        JsonArray list=(JsonArray) obj;
        employeeList = objectMapper.readValue(list.toString(), new TypeReference<List<EmployeeDetails>>(){});
        return employeeList;
    }
    public List<ProjectDetails> jsonFileToProjectDetails(String path) throws Exception{
        Object obj = jsonParser.parse(new FileReader(path));
        JsonArray list=(JsonArray) obj;
        projectList = objectMapper.readValue(list.toString(), new TypeReference<List<ProjectDetails>>() {});
        return projectList;
    }
    public List<AssignProject> jsonFileToAssignProject(String path) throws Exception{
        Object obj = jsonParser.parse(new FileReader(path));
        JsonArray list=(JsonArray) obj;
        assignProjectList = objectMapper.readValue(list.toString(), new TypeReference<List<AssignProject>>() {});
        return assignProjectList;
    }
}
