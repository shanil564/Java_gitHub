package com.factweavers.tutorials.controller;
import com.factweavers.tutorials.Resources.EmployeeResources;
import com.factweavers.tutorials.config.MainConfig;
import com.factweavers.tutorials.model.EmployeeProjectDetails;
import com.factweavers.tutorials.service.EmployeeService;
import com.factweavers.tutorials.service.SqlService;
import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Environment;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import java.util.List;
public class OfficeController extends Application<MainConfig> {

    public static Logger logger = Logger.getLogger(OfficeController.class);
    private  static EmployeeService employeeService=new EmployeeService();
    private static void processEmployeeCrudOperations() throws Exception{

        employeeService.addEmployees();//add employee
        logger.info("showing employees after adding........");
        employeeService.showAllEmployees(employeeService.getAllEmployees());

        employeeService.updateEmployee();//update employee
        logger.info("showing employees after updating........");
        employeeService.showAllEmployees(employeeService.getAllEmployees());

        employeeService.deleteEmployee();// delete employee
        logger.info("showing employees after delete.......");
        employeeService.showAllEmployees(employeeService.getAllEmployees());
    }
    private static void processProjectCrudOperations()throws Exception{
        employeeService.addProjects();//add project
        logger.info("showing projects after adding.......");
        employeeService.showAllProjects(employeeService.getAllProjects());

        employeeService.deleteProject();//delete project
        logger.info("showing projects after delete........");
        employeeService.showAllProjects(employeeService.getAllProjects());

        employeeService.updateProject();//update a project
        logger.info("showing employees after updating......");
        employeeService.showAllProjects(employeeService.getAllProjects());
    }
    public static void main(String[] args) throws Exception {
        new OfficeController().run(args);


        BasicConfigurator.configure();
        processEmployeeCrudOperations();
        processProjectCrudOperations();
//
//        employeeService.addAssignProject();//add assign project
//        employeeService.reassignProject();//update assignProject
//        List<EmployeeProjectDetails> employeesWithAssignedProject = employeeService.getEmployeeDetails();
//        List<EmployeeProjectDetails> projectWithAssignedEmployees = employeeService.getProjectDetails();
//
//        logger.info("showing employee with assignedProject");
//        employeeService.showEmployeesWithAssignedProject(employeesWithAssignedProject);
//
//        logger.info("showing project details with assignedEmployee");
//        employeeService.showProjectWithAssignedEmployees(projectWithAssignedEmployees);
//
//        logger.info("processed all crud operations........");
//        employeeService.stopCrudOperations();



    }



    @Override
    public void run(MainConfig mainConfig, Environment environment) throws Exception {
        environment.jersey().register(EmployeeResources.class);

    }
}
