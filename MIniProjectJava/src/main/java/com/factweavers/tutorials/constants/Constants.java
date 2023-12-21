package com.factweavers.tutorials.constants;

public class Constants {
    public static final String INPUT_JSON_ADD_EMPLOYEE_FILE_PATH = "addEmployeesPath";
    public static final String INPUT_JSON_ADD_PROJECT_FILE_PATH = "addProjectsPath";
    public static final String INPUT_JSON_ASSIGN_PROJECT_FILE_PATH = "assignProjectPath";
    public static final String INPUT_JSON_DELETE_EMPLOYEE_FILE_PATH = "deleteEmployeePath";
    public static final String INPUT_JSON_DELETE_PROJECT_FILE_PATH = "deleteProjectPath";
    public static final String INPUT_JSON_UPDATE_EMPLOYEE_FILE_PATH = "updateEmployeePath";
    public static final String INPUT_JSON_UPDATE_PROJECT_FILE_PATH = "updateProjectPath";
    public static final String INPUT_JSON_REASSIGN_PROJECT_FILE_PATH = "reassignProjectPath";
    public static final String INPUT_JSON_GET_EMPLOYEE_FILE_PATH = "getEmployeeDetailsPath";
    public static final String INPUT_JSON_GET_PROJECT_FILE_PATH = "getProjectDetailsPath";
    public static final String SQL_JDBC_URL = "sqlJdbcUrl";
    public static final String SQL_USERNAME = "sqlUserName";
    public static final String SQL_PASSWORD = "sqlPassword";
    public static final String PROPERTIES = "config.properties";
    public static final int ONE = 1;
    public static final int TWO = 2;
    public static final int THREE = 3;
    public static final String ADD_EMPLOYEES_QUERY = "INSERT INTO employeeDetails (employeeId, employeeName) VALUES (?, ?)";
    public static final String ADD_PROJECTS_QUERY = "INSERT INTO projectDetails (projectId, projectName) VALUES ( ?, ?)";
    public static final String ADD_ASSIGN_PROJECTS_QUERY = "INSERT INTO assignProject (assignProjectId,employeeId,projectId) VALUES ( ?, ?,?)";
    public static final String GET_ALL_PROJECTS_QUERY = "SELECT * from projectDetails";
    public static final String GET_ALL_EMPLOYEES_QUERY = "SELECT * FROM employeeDetails";
    public static final String DELETE_EMPLOYEE_QUERY = "delete from employeeDetails where employeeId=?";
    public static final String DELETE_PROJECT_QUERY = "delete from projectDetails where projectId=?";
    public static final String REASSIGN_PROJECT_QUERY = "update assignProject set projectId=? where employeeId=?";
    public static final String IS_EMPLOYEE_EXISTS_QUERY = "select Exists(SELECT * from employeeDetails where employeeId=?)";
    public static final String IS_PROJECTS_EXISTS_QUERY = "select Exists(SELECT * from projectDetails where projectId=?)";
    public static final String UPDATE_PROJECT_QUERY = "update projectDetails set projectName=? where projectId=?";
    public static final String UPDATE_EMPLOYEE_QUERY = "update employeeDetails set employeeName=? where employeeId=?";
    public static final String CHECK_EMPLOYEE_QUERY = "update employeeDetails set employeeName=? where employeeId=?";
    public static final String GET_EMPLOYEE_ASSIGNED_PROJECT_QUERY = "SELECT e.employeeId, e.employeeName, p.projectName FROM employeeDetails e left JOIN assignProject ap ON e.employeeId = ap.employeeId left JOIN projectDetails p ON ap.projectId = p.projectId where e.employeeId=?";
    public static final String GET_PROJECT_WITH_ASSIGNED_EMPLOYEE_QUERY = "SELECT p.projectId,p.projectName, e.employeeName FROM projectDetails p JOIN assignProject ap ON p.projectId = ap.projectId JOIN employeeDetails e ON ap.employeeId = e.employeeId where p.projectId=?";
}
