package com.greenfox.exams.spring.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Experience {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    private String experienceText;
    private Long rate;
    private String email;

    public Experience() {
    }

    public Experience(String experienceText, Long rate, String email) {
        this.experienceText = experienceText;
        this.email = email;
        this.rate = rate;
    }

}
