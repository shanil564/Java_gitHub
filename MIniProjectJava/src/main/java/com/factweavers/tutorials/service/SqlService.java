package com.factweavers.tutorials.service;
import com.factweavers.tutorials.common.SqlConnector;
import com.factweavers.tutorials.constants.Constants;
import com.factweavers.tutorials.model.AssignProject;
import com.factweavers.tutorials.model.EmployeeProjectDetails;
import com.factweavers.tutorials.model.EmployeeDetails;
import com.factweavers.tutorials.model.ProjectDetails;
import org.apache.log4j.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class SqlService {
    Logger logger=Logger.getLogger(this.getClass());
    private List<ProjectDetails> projectList=new ArrayList<>();
    private Connection connection= SqlConnector.getInstance().getconnection();
    private PreparedStatement preparedStatement=SqlConnector.getstatement();
    public void updateEmployee(EmployeeDetails employee,boolean isUpdate) throws Exception{
        try{
            if(isUpdate){
                String query=Constants.UPDATE_EMPLOYEE_QUERY;
                preparedStatement =connection.prepareStatement(query);
                preparedStatement.setString(Constants.ONE,  employee.getEmployeeName());
                preparedStatement.setInt(Constants.TWO, (int) employee.getEmployeeId());
                preparedStatement.executeUpdate();
                logger.info( "changed employee name who's employeeId :"+employee.getEmployeeId());
            } else {
                String query = Constants.ADD_EMPLOYEES_QUERY;
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(Constants.ONE, (int) employee.getEmployeeId());
                preparedStatement.setString(Constants.TWO, employee.getEmployeeName());
                preparedStatement.executeUpdate();
                logger.info("employee id:"+employee.getEmployeeId()+" Data added");
            }
        }catch (Exception e){
            logger.error("Failed to add/update employee with id: "+employee.getEmployeeId()+" error: "+e.getMessage());
        }
    }
    public void updateProject(ProjectDetails project,boolean isUpdate){
        try {
            if (isUpdate){
            String query=Constants.UPDATE_PROJECT_QUERY;
            preparedStatement =connection.prepareStatement(query);
            preparedStatement.setString(Constants.ONE,project.getProjectName());
            preparedStatement.setInt(Constants.TWO, (int) project.getProjectId());
            preparedStatement.executeUpdate();
            logger.info("changed project name who's projectId :"+project.getProjectId());
        } else{
                String query = Constants.ADD_PROJECTS_QUERY;
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(Constants.ONE, (int) project.getProjectId());
                preparedStatement.setString(Constants.TWO, project.getProjectName());
                preparedStatement.executeUpdate();
                logger.info("project id: "+project.getProjectId()+" Data added");
            }
        } catch (Exception e){
            logger.error("Failed to add/update project with id: "+project.getProjectId()+" error: "+e.getMessage());
        }
    }
    public  void assignProject(AssignProject assignProject,boolean isUpdate){
        try {if (isUpdate){
            String query=Constants.REASSIGN_PROJECT_QUERY;
            preparedStatement =connection.prepareStatement(query);
            preparedStatement.setInt(Constants.ONE, (int) assignProject.getProjectId());
            preparedStatement.setInt(Constants.TWO, (int) assignProject.getEmployeeId());
            preparedStatement.executeUpdate();
            logger.info("changed assigned project who's employee id:"+assignProject.getEmployeeId());
        } else{
                String query = Constants.ADD_ASSIGN_PROJECTS_QUERY;
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(Constants.ONE, (int) assignProject.getAssignProjectId());
                preparedStatement.setInt(Constants.TWO, (int) assignProject.getEmployeeId());
                preparedStatement.setInt(Constants.THREE, (int) assignProject.getProjectId());
                preparedStatement.executeUpdate();
                logger.info("new project assigned for employeeId: "+assignProject.getEmployeeId());
            }
        } catch (Exception e){
            logger.error("Failed to add/update assigned project with id: "+assignProject.getEmployeeId()+" error: "+e.getMessage());
        }
    }
    public void deleteEmployee(EmployeeDetails employee){
        try {
            String query = Constants.DELETE_EMPLOYEE_QUERY ;
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(Constants.ONE, (int) employee.getEmployeeId());
            preparedStatement.executeUpdate();
            logger.info("deleted employeeId :"+employee.getEmployeeId());
        } catch (Exception e) {
            logger.error("Failed to delete employee with id: "+employee.getEmployeeId()+" error: "+e.getMessage());
        }
    }
    public  void deleteProject(ProjectDetails project){
        try {
            String query = Constants.DELETE_PROJECT_QUERY;
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(Constants.ONE, (int) project.getProjectId());
            preparedStatement.executeUpdate();
            logger.info("deleted projectId:"+project.getProjectId());
        } catch (Exception e) {
            logger.error("Failed to delete project with id: "+project.getProjectId()+" error: "+e.getMessage());
        }
    }
    public List<EmployeeDetails> getAllEmployees(){
        List<EmployeeDetails> employeeList=new ArrayList<>();
        try {
            String query = Constants.GET_ALL_EMPLOYEES_QUERY;
            preparedStatement=connection.prepareStatement(query);
            ResultSet resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
                EmployeeDetails employeeData=new EmployeeDetails();
                employeeData.setEmployeeId(resultSet.getInt(Constants.ONE));
                employeeData.setEmployeeName(resultSet.getString(Constants.TWO));
                employeeList.add(employeeData);
            }
        } catch (Exception e){
            logger.error("Failed to show all employees... error: "+e.getMessage());
        }
        return employeeList;
    }
    public List<ProjectDetails> getAllProjects(){
        List<ProjectDetails> projectList=new ArrayList<>();
        try {
            String query = Constants.GET_ALL_PROJECTS_QUERY;
            preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                ProjectDetails projectDetails = new ProjectDetails();
                projectDetails.setProjectId(resultSet.getInt(Constants.ONE));
                projectDetails.setProjectName(resultSet.getString(Constants.TWO));
                projectList.add(projectDetails);
            }

        } catch (Exception e) {
            logger.error("Failed to show all projects... error: "+e.getMessage());
        }
        return projectList;
    }
    public EmployeeProjectDetails getEmployeeDetails(EmployeeDetails employee) throws Exception{
        String query=Constants.GET_EMPLOYEE_ASSIGNED_PROJECT_QUERY;
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(Constants.ONE, (int) employee.getEmployeeId());
        ResultSet resultSet = preparedStatement.executeQuery();
        EmployeeProjectDetails employeeProjectDetails =new EmployeeProjectDetails();
        while(resultSet.next()){
            EmployeeDetails employeeDetails=new EmployeeDetails();
            ProjectDetails projectDetails=new ProjectDetails();
            employeeDetails.setEmployeeId(resultSet.getInt(Constants.ONE));
            employeeDetails.setEmployeeName(resultSet.getString(Constants.TWO));
            projectDetails.setProjectName(resultSet.getString(Constants.THREE));
            employeeProjectDetails.setEmployee(employeeDetails);
            employeeProjectDetails.setProject(projectDetails);
        }
        return employeeProjectDetails;
    }
    public EmployeeProjectDetails getProjectDetails(ProjectDetails project) throws Exception{
        String query=Constants.GET_PROJECT_WITH_ASSIGNED_EMPLOYEE_QUERY;
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(Constants.ONE, (int) project.getProjectId());
        ResultSet resultSet = preparedStatement.executeQuery();
        List<EmployeeDetails> employeeList=new ArrayList<>();
        EmployeeProjectDetails employeeProjectDetails =new EmployeeProjectDetails();
        while(resultSet.next()){
            ProjectDetails projectDetails=new ProjectDetails();
            EmployeeDetails employeeDetails=new EmployeeDetails();
            projectDetails.setProjectId(resultSet.getInt(Constants.ONE));
            projectDetails.setProjectName(resultSet.getString(Constants.TWO));
            employeeDetails.setEmployeeName(resultSet.getString(Constants.THREE));
            employeeList.add(employeeDetails);
            employeeProjectDetails.setProject(projectDetails);
        }
        employeeProjectDetails.setEmployeeList(employeeList);
        return employeeProjectDetails;
    }
    public void closeConnection() throws SQLException {
        connection.close();
    }
    public boolean isEmployeeExists(int employeeId)throws Exception{
        String query=Constants.IS_EMPLOYEE_EXISTS_QUERY;
        preparedStatement=connection.prepareStatement(query);
        preparedStatement.setInt(Constants.ONE,employeeId);
        ResultSet resultSet=preparedStatement.executeQuery();
        boolean value=false;
        while (resultSet.next()){
            value=resultSet.getBoolean(Constants.ONE);
        }
        return value;
    }
    public boolean isProjectExists(int projectId)throws Exception{
        String query=Constants.IS_PROJECTS_EXISTS_QUERY;
        preparedStatement=connection.prepareStatement(query);
        preparedStatement.setInt(Constants.ONE,projectId);
        ResultSet resultSet=preparedStatement.executeQuery();
        boolean value=false;
        while (resultSet.next()){
            value=resultSet.getBoolean(Constants.ONE);
        }
        return value;
    }
}
