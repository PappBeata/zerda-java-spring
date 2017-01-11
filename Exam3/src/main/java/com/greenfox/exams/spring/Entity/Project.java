package com.greenfox.exams.spring.Entity;

import javax.persistence.Entity;

@Entity
public class Project {
    private String whateverText;
    private String framework;

    public Project() {
    }

    public Project(String whateverText, String framework) {
        this.whateverText = whateverText;
        this.framework = framework;
    }
}
