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

    // ---------- FORSIDE ----------
    @GetMapping("/")
    public String index() {
        return "index";
    }

    // ---------- VIS ALLE PROJEKTER ----------
    @GetMapping("/projects")
    public String showProjects(Model model) {
        model.addAttribute("projects", projects);
        return "projects";
    }

    // ---------- OPRET PROJEKT (FORM) ----------
    @GetMapping("/projects/create")
    public String createProjectForm() {
        return "project-create";
    }

    // ---------- OPRET PROJEKT (POST) ----------
    @PostMapping("/projects/create")
    public String createProject(
            @RequestParam String name,
            @RequestParam String customer,
            @RequestParam String deadline
    ) {
        Project project = new Project(
                name,
                customer,
                LocalDate.parse(deadline)
        );

        projects.add(project);
        return "redirect:/projects";
    }

    // ---------- VIS ÉT PROJEKT ----------
    @GetMapping("/projects/{index}")
    public String showProject(@PathVariable int index, Model model) {
        Project project = projects.get(index);

        model.addAttribute("project", project);
        model.addAttribute("index", index);
        model.addAttribute("hoursPerDay", project.getHoursPerDay());

        return "project-details";
    }

    // ---------- TILFØJ OPGAVE ----------
    @PostMapping("/projects/{index}/tasks")
    public String addTask(
            @PathVariable int index,
            @RequestParam String taskName,
            @RequestParam int estimatedHours
    ) {
        Project project = projects.get(index);
        project.addTask(taskName, estimatedHours);

        return "redirect:/projects/" + index;
    }
}
