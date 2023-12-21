package com.example.demo.controller;

import com.example.demo.entity.Projects;
import com.example.demo.response.Response;
import com.example.demo.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/company/project")
public class ProjectController {
    @Autowired
    private ProjectService projectService;
    @PreAuthorize("hasAuthority('WRITE')")
    @PostMapping
    public Response addProject(@RequestBody Projects project){
        return  projectService.addProject(project);
    }
    @PreAuthorize("hasAuthority('READ')")
    @GetMapping
    public Response getAllProjects(){
        return projectService.getAllProjects();
    }
    @PreAuthorize("hasAuthority('READ')")
    @GetMapping("/{id}")
    public Response getProjectById(@PathVariable Long id){
        return projectService.getProjectById(id);
    }
    @PreAuthorize("hasAuthority('WRITE')")
    @DeleteMapping("/{id}")
    public Response deleteProjectById(@PathVariable Long id){
        return projectService.deleteProjectById(id);
    }
    @PreAuthorize("hasAuthority('WRITE')")
    @PutMapping
    public Response updateProject(@RequestBody Projects project){
        return projectService.updateProject(project);
    }
}
