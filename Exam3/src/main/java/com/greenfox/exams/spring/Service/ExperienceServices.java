package com.greenfox.exams.spring.Service;

import com.greenfox.exams.spring.Entity.Experience;
import com.greenfox.exams.spring.Repository.ExperienceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ExperienceServices {

    public List<String> compliments = Arrays.asList(new String[]{"amazing", "awesome", "blithesome", "excellent", "fabulous", "fantastic", "favorable", "fortuitous", "great", "incredible", "ineffable", "mirthful", "outstanding", "perfect", "propitious", "remarkable", "smart", "spectacular", "splendid", "stellar", "stupendous", "super", "ultimate", "unbelievable", "wondrous"});

    private ExperienceRepo experienceRepo;

    @Autowired
    public ExperienceServices(ExperienceRepo experienceRepo) {
        this.experienceRepo = experienceRepo;
    }

    public void saveNewExperience(Experience experience) {
        experienceRepo.save(experience);
    }

    public boolean checkEmail(String email) {
        return email.contains("@") && email.contains(".");
    }

    public boolean checkExperienceText(String experienceText, List<String> compliments) {
        int result = 0;
        for (String item : compliments) {
            if (experienceText.contains(item)) {
                result++;
            }
        }
        return (result >= 3);
    }

    public boolean checkRate(Long rate) {
        return rate == 10;
    }

    public boolean checkValidInput(Experience experience, List<String> compliments) {
        return checkEmail(experience.email) && checkExperienceText(experience.experienceText, compliments) && checkRate(experience.rate);
    }

}
