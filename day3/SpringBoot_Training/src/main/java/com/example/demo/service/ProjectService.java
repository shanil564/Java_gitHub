package com.example.demo.service;
import com.example.demo.Constants;
import com.example.demo.entity.Projects;
import com.example.demo.repository.EmployeesRepo;
import com.example.demo.repository.ProjectsRepo;
import com.example.demo.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
@Service
public class ProjectService {
    @Autowired
    private ProjectsRepo projectsRepo;
    @Autowired
    private EmployeesRepo employeesRepo;
    public Response addProject(Projects project){
        Response response=new Response();
        if(findByProjectId(project.getProjectId()).size()==0){
            projectsRepo.save(project);
            response.setMessage(Constants.MSG_ADDED);
            response.setResult(project);
            return response;
        }else{
            response.setMessage(Constants.MSG_EXISTS);
            return response;
        }
    }
    public List<Projects> findByProjectId(Long id){
        return projectsRepo.findByProjectId(id);
    }
    public Response getAllProjects(){
        Response response=new Response();
        List<Projects> projectList= projectsRepo.findAll();
        response.setList(Collections.singletonList(projectList));
        return response;
    }
    public Response getProjectById(Long id){
        Response response=new Response();
        Optional<Projects> projects=projectsRepo.findById(id);
        if (projects.isPresent()){
            response.setResult(projects);
            return response;
        }else{
            response.setMessage(Constants.MSG_NOT_EXISTS);
            response.setSuccess(false);
            return response;
        }
    }
    public Response deleteProjectById(Long id){
        Response response=new Response();
        Optional<Projects> projects=projectsRepo.findById(id);
        if (projects.isPresent()){
            projectsRepo.deleteById(id);
            response.setMessage(Constants.MSG_DELETED);
            return response;
        }else{
            response.setSuccess(false);
            response.setMessage(Constants.MSG_NOT_EXISTS);
            return response;
        }
    }
    public Response updateProject(Projects project){
        if (findByProjectId(project.getProjectId()).size()==0){
            return addProject(project);
        }else{
            project.setProjectName(project.getProjectName());
            project.setEmployees(project.getEmployees());
            projectsRepo.save(project);
            Response response=new Response();
            response.setMessage(Constants.MSG_UPDATED);
            response.setResult(project);
            return response;
        }
    }
}
