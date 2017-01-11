package com.greenfox.exams.spring.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    public String projectName;
    public String framework;

    public Project() {
    }

    public Project(String projectName, String framework) {
        this.projectName = projectName;
        this.framework = framework;
    }
}
