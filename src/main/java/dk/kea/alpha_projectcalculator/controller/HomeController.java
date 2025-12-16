package dk.kea.alpha_projectcalculator.controller;

import dk.kea.alpha_projectcalculator.model.Project;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    private List<Project> projects = new ArrayList<>();

    // Forside
    @GetMapping("/")
    public String index() {
        return "redirect:/projects";
    }

    // Projektoversigt
    @GetMapping("/projects")
    public String projects(Model model) {
        model.addAttribute("projects", projects);
        return "projects";
    }

    // Vis formular til oprettelse
    @GetMapping("/projects/create")
    public String createProjectForm() {
        return "project-create";
    }

    // Opret projekt
    @PostMapping("/projects/create")
    public String createProject(
            @RequestParam String name,
            @RequestParam String customer,
            @RequestParam String deadline
    ) {
        Project project = new Project(
                System.currentTimeMillis(),
                name,
                customer,
                LocalDate.parse(deadline)
        );

        projects.add(project);
        return "redirect:/projects";
    }

    // Projektdetaljer
    @GetMapping("/projects/{id}")
    public String projectDetails(@PathVariable Long id, Model model) {

        Project project = null;
        for (Project p : projects) {
            if (p.getId().equals(id)) {
                project = p;
                break;
            }
        }

        if (project == null) {
            return "redirect:/projects";
        }

        model.addAttribute("project", project);
        model.addAttribute("hoursPerDay", project.getHoursPerDay());

        return "project-details";
    }

    // Tilføj opgave
    @PostMapping("/projects/{id}/tasks")
    public String addTask(
            @PathVariable Long id,
            @RequestParam String taskName,
            @RequestParam int estimatedHours
    ) {

        for (Project project : projects) {
            if (project.getId().equals(id)) {
                project.addTask(taskName, estimatedHours);
                break;
            }
        }

        return "redirect:/projects/" + id;
    }
}
