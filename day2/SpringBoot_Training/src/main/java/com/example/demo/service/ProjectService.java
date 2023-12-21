package com.example.demo.service;
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
            response.setMessage("projectId: "+project.getProjectId()+" added");
            response.setResult(project);
            return response;
        }else{
            response.setMessage("project Details already exists");
            return response;
        }
    }
    public List<Projects> findByProjectId(Long id){
        return projectsRepo.findByProjectId(id);
    }
    public Response getAllProjects(){
        Response response=new Response();
        List<Projects> projectList= projectsRepo.findAll();
        response.setMessage("list of all project details shown below");
        response.setList(Collections.singletonList(projectList));
        return response;
    }
    public Response getProjectById(Long id){
        Response response=new Response();
        Optional<Projects> projects=projectsRepo.findById(id);
        if (projects.isPresent()){
            response.setMessage("projectId: "+id+" details");
            response.setResult(projects);
            return response;
        }else{
            response.setMessage("projectId: "+id+" doesn't exist");
            response.setSuccess(false);
            return response;
        }
    }
    public Response deleteProjectById(Long id){
        Response response=new Response();
        Optional<Projects> projects=projectsRepo.findById(id);
        if (projects.isPresent()){
            projectsRepo.deleteById(id);
            response.setMessage("projectId :"+id+" deleted");
            return response;
        }else{
            response.setSuccess(false);
            response.setMessage("projectId: "+id+" doesn't exist");
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
            response.setMessage("projectID: "+project.getProjectId()+" updated");
            response.setResult(project);
            return response;
        }
    }
}
