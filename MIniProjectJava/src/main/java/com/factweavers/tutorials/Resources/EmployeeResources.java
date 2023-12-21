package com.factweavers.tutorials.Resources;

import com.factweavers.tutorials.service.EmployeeService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("employee")
public class EmployeeResources {
    EmployeeService employeeService=new EmployeeService();
    @GET
    @Path("/testing")
    public Response test(){
        return  Response.ok(employeeService.getAllEmployees()).build();

    }
}
