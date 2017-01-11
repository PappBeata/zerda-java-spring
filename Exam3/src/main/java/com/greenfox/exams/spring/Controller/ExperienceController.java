package com.greenfox.exams.spring.Controller;

import com.greenfox.exams.spring.Entity.Experience;
import com.greenfox.exams.spring.Service.ExperienceServices;
import com.greenfox.exams.spring.Service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/questionnaire")
public class ExperienceController {

    ExperienceServices experienceService;
    ProjectService projectService;

    @Autowired
    public ExperienceController(ExperienceServices experienceService, ProjectService projectService) {
        this.experienceService = experienceService;
        this.projectService = projectService;
    }

    @RequestMapping(value = {"/", ""})
    public String index() {
        return "redirect:/questionnaire/feedback";
    }

    @GetMapping("/feedback")
    public String addFeedback(Model model) {
        model.addAttribute("experience", new Experience());
        return "welcome";
    }

    @PostMapping("/feedback")
    public String processFeedback(@ModelAttribute Experience experience, Model model) {
        boolean isIncomplete = false;
        if (experienceService.checkValidInput(experience, experienceService.compliments)) {
            experienceService.saveNewExperience(experience);
            return "redirect:/questionnaire/results";
        } else {
            //isIncomplete = true;
            model.addAttribute("isIncomplete", isIncomplete);
            return "welcome";
        }
    }

    @RequestMapping("/results")
    public String listProjects(Model model) {
        model.addAttribute("projects", projectService.listOfProjects());
        return "thankYou";
    }

}
