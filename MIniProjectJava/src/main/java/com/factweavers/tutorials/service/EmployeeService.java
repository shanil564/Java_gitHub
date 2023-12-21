package com.factweavers.tutorials.service;
import com.factweavers.tutorials.common.JsonFileReader;
import com.factweavers.tutorials.configurationLoader.ConfigurationLoader;
import com.factweavers.tutorials.constants.Constants;
import com.factweavers.tutorials.model.AssignProject;
import com.factweavers.tutorials.model.EmployeeProjectDetails;
import com.factweavers.tutorials.model.EmployeeDetails;
import com.factweavers.tutorials.model.ProjectDetails;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class EmployeeService {
    private static final Properties properties = ConfigurationLoader.getInstance().getProperties();
    public  final String employeeJsonFilePath = properties.getProperty(Constants.INPUT_JSON_ADD_EMPLOYEE_FILE_PATH);
    public final String projectJsonFilePath = properties.getProperty(Constants.INPUT_JSON_ADD_PROJECT_FILE_PATH);
    public final String assignProjectJsonFilePath = properties.getProperty(Constants.INPUT_JSON_ASSIGN_PROJECT_FILE_PATH);
    public final String deleteEmployeeJsonFilePath = properties.getProperty(Constants.INPUT_JSON_DELETE_EMPLOYEE_FILE_PATH);
    public final String deleteProjectJsonFilePath = properties.getProperty(Constants.INPUT_JSON_DELETE_PROJECT_FILE_PATH);
    public final String updateEmployeeJsonFilePath = properties.getProperty(Constants.INPUT_JSON_UPDATE_EMPLOYEE_FILE_PATH);
    public final String updateProjectJsonFilePath = properties.getProperty(Constants.INPUT_JSON_UPDATE_PROJECT_FILE_PATH);
    public final String updateAssignProjectJsonFilePath = properties.getProperty(Constants.INPUT_JSON_REASSIGN_PROJECT_FILE_PATH);
    public final String getEmployeeJsonFilePath = properties.getProperty(Constants.INPUT_JSON_GET_EMPLOYEE_FILE_PATH);
    public final String getProjectJsonFilePath = properties.getProperty(Constants.INPUT_JSON_GET_PROJECT_FILE_PATH);
    private Logger logger=Logger.getLogger(getClass());
    SqlService sqlService=new SqlService();
    private JsonFileReader jsonFileReader=new JsonFileReader();
    public  void updateEmployee() throws Exception{
        for (EmployeeDetails employee:jsonFileReader.jsonFileToEmployeeDetails(updateEmployeeJsonFilePath)){//get a employee detail
            if(sqlService.isEmployeeExists((int) employee.getEmployeeId())) {
                sqlService.updateEmployee(employee, true);
            } else {
                logger.warn("employee id:" + employee.getEmployeeId() + " doesn't exist.so new employee added");
                sqlService.updateEmployee(employee,false);
            }
        }
    }
    public  void addEmployees() throws Exception{
        for (EmployeeDetails employee:jsonFileReader.jsonFileToEmployeeDetails(employeeJsonFilePath)){//get a employee detail
            sqlService.updateEmployee(employee,false);
        }
    }
    public void addProjects() throws Exception{
        for (ProjectDetails project:jsonFileReader.jsonFileToProjectDetails(projectJsonFilePath)){
            sqlService.updateProject(project,false);
        }
    }
    public void updateProject() throws Exception{
        for (ProjectDetails project:jsonFileReader.jsonFileToProjectDetails(updateProjectJsonFilePath)){
            if(sqlService.isProjectExists((int) project.getProjectId())) {
                sqlService.updateProject(project, true);
            } else {
                logger.warn("employee id:" + project.getProjectId() + " doesn't exist.so new employee added");
                sqlService.updateProject(project,false);
            }
        }
    }
    public void addAssignProject() throws Exception{
        for (AssignProject assignProject:jsonFileReader.jsonFileToAssignProject(assignProjectJsonFilePath)){
            sqlService.assignProject(assignProject,false);
        }
    }
    public void reassignProject() throws Exception{
        for (AssignProject assignProject:jsonFileReader.jsonFileToAssignProject(updateAssignProjectJsonFilePath)){
            sqlService.assignProject(assignProject,true);
        }
    }
    public void deleteEmployee() throws Exception{
        for(EmployeeDetails employee:jsonFileReader.jsonFileToEmployeeDetails(deleteEmployeeJsonFilePath)) {
            sqlService.deleteEmployee(employee);
        }
    }
    public void deleteProject() throws Exception{
        for(ProjectDetails project:jsonFileReader.jsonFileToProjectDetails(deleteProjectJsonFilePath)) {
            sqlService.deleteProject(project);
        }
    }
    public List<EmployeeDetails> getAllEmployees(){
        return sqlService.getAllEmployees();
    }
    public List<ProjectDetails> getAllProjects() {
        return sqlService.getAllProjects();
    }

    public void stopCrudOperations() throws Exception{
            sqlService.closeConnection();
    }
    public List<EmployeeProjectDetails> getEmployeeDetails() throws Exception{
        List<EmployeeProjectDetails> employeeProjectDetailsList =new ArrayList<>();
        for(EmployeeDetails employee:jsonFileReader.jsonFileToEmployeeDetails(getEmployeeJsonFilePath)) {
            employeeProjectDetailsList.add(sqlService.getEmployeeDetails(employee));
        }
        return employeeProjectDetailsList;
    }
    public void showEmployeesWithAssignedProject(List<EmployeeProjectDetails> employeeProjectDetailsList){
        for(EmployeeProjectDetails employeeProjectDetails : employeeProjectDetailsList){
            logger.info("the details for the employee "+ employeeProjectDetails.getEmployee().getEmployeeId()+" are below:");
            logger.info("employeeName:"+ employeeProjectDetails.getEmployee().getEmployeeName());
            logger.info("projectAssign:"+ employeeProjectDetails.getProject().getProjectName());
        }
    }
    public void showAllEmployees(List<EmployeeDetails> employeeList){
        for (EmployeeDetails employeeDetails:employeeList){
            logger.info("the details for the employee "+employeeDetails.getEmployeeId()+" are below:");
            logger.info("employeeName:"+employeeDetails.getEmployeeName());
        }
    }
    public void showAllProjects(List<ProjectDetails> projectList){
        for (ProjectDetails projectDetails:projectList){
            logger.info("the details for the project "+projectDetails.getProjectId()+" are below:");
            logger.info("projectName:"+projectDetails.getProjectName());
        }
    }
    public List<EmployeeProjectDetails> getProjectDetails() throws Exception{
        List<EmployeeProjectDetails> employeeProjectDetailsList =new ArrayList<>();
        for(ProjectDetails project:jsonFileReader.jsonFileToProjectDetails(getProjectJsonFilePath)) {
            employeeProjectDetailsList.add(sqlService.getProjectDetails(project));
        }
        return employeeProjectDetailsList;
    }
    public void showProjectWithAssignedEmployees(List<EmployeeProjectDetails> employeeProjectDetailsList){
        for(EmployeeProjectDetails employeeProjectDetails : employeeProjectDetailsList){
            logger.info("the details for the project "+ employeeProjectDetails.getProject().getProjectId()+" are below:");
            logger.info(" projectName: "+ employeeProjectDetails.getProject().getProjectName());
            logger.info("below are the assigned employees");
            for(EmployeeDetails employeeDetails: employeeProjectDetails.getEmployeeList()){
                logger.info("employeeName: "+employeeDetails.getEmployeeName());
            }
        }
    }
}
