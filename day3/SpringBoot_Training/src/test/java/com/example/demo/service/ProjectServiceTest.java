package com.example.demo.service;

import com.example.demo.entity.Projects;
import com.example.demo.repository.ProjectsRepo;
import com.example.demo.response.Response;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProjectServiceTest {
    @Mock
    ProjectsRepo projectsRepo;
    @InjectMocks
    ProjectService projectService;
    @Test
    public void addProjectTestForProjectExist(){
        Projects projects=new Projects();
        projects.setProjectId(1L);
        projects.setProjectName("testName");
        when(projectsRepo.findByProjectId(any())).thenReturn(Collections.emptyList());
        Response response=projectService.addProject(projects);
        Assert.assertEquals("projectId: 1 data added...",response.getMessage());
    }
    @Test
    public void addProjectTestForProjectNotExist(){
        Projects projects=new Projects();
        projects.setProjectId(1L);
        projects.setProjectName("testName");
        List<Projects> nonEmptyList= Arrays.asList(new Projects(),new Projects());
        when(projectsRepo.findByProjectId(any())).thenReturn(nonEmptyList);
        Response response=projectService.addProject(projects);
        Assert.assertEquals("project Details already exists....",response.getMessage());
    }

}
