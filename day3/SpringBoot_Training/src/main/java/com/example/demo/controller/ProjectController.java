package com.example.demo.controller;

import com.example.demo.Constants;
import com.example.demo.entity.Projects;
import com.example.demo.response.Response;
import com.example.demo.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(Constants.COMPANY_PATH+Constants.PROJECT_PATH)
public class ProjectController {
    @Autowired
    private ProjectService projectService;
    @PreAuthorize(Constants.HAS_AUTHORITY_WRITE)
    @PostMapping
    public Response addProject(@RequestBody Projects project){
        return  projectService.addProject(project);
    }
    @PreAuthorize(Constants.HAS_AUTHORITY_READ)
    @GetMapping
    public Response getAllProjects(){
        return projectService.getAllProjects();
    }
    @PreAuthorize(Constants.HAS_AUTHORITY_READ)
    @GetMapping(Constants.PATH_VARIABLE_ID)
    public Response getProjectById(@PathVariable Long id){
        return projectService.getProjectById(id);
    }
    @PreAuthorize(Constants.HAS_AUTHORITY_WRITE)
    @DeleteMapping(Constants.PATH_VARIABLE_ID)
    public Response deleteProjectById(@PathVariable Long id){
        return projectService.deleteProjectById(id);
    }
    @PreAuthorize(Constants.HAS_AUTHORITY_WRITE)
    @PutMapping
    public Response updateProject(@RequestBody Projects project){
        return projectService.updateProject(project);
    }
}
