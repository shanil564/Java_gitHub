package com.factweavers.tutorials.controller;
import com.factweavers.tutorials.common.JsonFileReader;
import com.factweavers.tutorials.model.AssignProject;
import com.factweavers.tutorials.model.EmployeeDetails;
import com.factweavers.tutorials.model.ProjectDetails;
import com.factweavers.tutorials.service.EmployeeService;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.util.List;
public class JsonFileReaderTest {
    JsonFileReader jsonFileReader;
    EmployeeService employeeService;
    @BeforeTest
    public void init(){
        this.employeeService=new EmployeeService();
        this.jsonFileReader=new JsonFileReader();

    }

    @Test
    public void jsonFileToEmployeeDetailsTestElementExist() throws  Exception{
        List<EmployeeDetails> list=jsonFileReader.jsonFileToEmployeeDetails(employeeService.employeeJsonFilePath);
        Assert.assertTrue(true, String.valueOf(list.size()>0));
    }
    @Test
    public void jsonFileToEmployeeDetailsTestForEmpty() throws  Exception{
        List<EmployeeDetails> list=jsonFileReader.jsonFileToEmployeeDetails(employeeService.employeeJsonFilePath);
        Assert.assertFalse(list.isEmpty());
    }
    @Test
    public void jsonFileToEmployeeDetailsTestException() throws Exception{
            jsonFileReader.jsonFileToEmployeeDetails(employeeService.employeeJsonFilePath);
    }
    @Test(expectedExceptions = {FileNotFoundException.class})
    public void jsonFileNOtFoundException() throws Exception{
        jsonFileReader.jsonFileToEmployeeDetails("src/resources/addEmployee.json");

    }
    @Test
    public void jsonFileToProjectDetailsTestForElementExist() throws  Exception{
        List<ProjectDetails> list=jsonFileReader.jsonFileToProjectDetails(employeeService.projectJsonFilePath);

        Assert.assertTrue(list.size()>0);
    }
    @Test
    public void jsonFileToProjectDetailsTestForEmpty() throws  Exception {
        List<ProjectDetails> list = jsonFileReader.jsonFileToProjectDetails(employeeService.projectJsonFilePath);
        Assert.assertFalse(list.isEmpty());
    }
    @Test
    public void jsonFileToAssignProjectTestForElementExist() throws  Exception{
        List<AssignProject> list=jsonFileReader.jsonFileToAssignProject(employeeService.assignProjectJsonFilePath);
        Assert.assertTrue(true, String.valueOf(list.size()>0));
    }
    @Test
    public void jsonFileToAssignProjectTestForEmpty() throws  Exception {
        List<AssignProject> list = jsonFileReader.jsonFileToAssignProject(employeeService.assignProjectJsonFilePath);
        Assert.assertFalse(list.isEmpty());
    }
}
