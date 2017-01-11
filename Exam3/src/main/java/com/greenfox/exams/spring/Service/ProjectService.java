package com.greenfox.exams.spring.Service;

import com.greenfox.exams.spring.Entity.Project;
import com.greenfox.exams.spring.Repository.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    private ProjectRepo projectRepo;

    @Autowired
    public ProjectService(ProjectRepo projectRepo) {
        this.projectRepo = projectRepo;
    }

    public List<Project> listOfProjects() {
        return projectRepo.findAll();
    }
}
