package dk.kea.alpha_projectcalculator.controller;

import dk.kea.alpha_projectcalculator.model.Project;
import dk.kea.alpha_projectcalculator.repository.ProjectRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
public class HomeController {

    private final ProjectRepository projectRepository;

    public HomeController(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @GetMapping("/")
    public String index() {
        return "redirect:/projects";
    }

    @GetMapping("/projects")
    public String showProjects(Model model) {
        model.addAttribute("projects", projectRepository.findAll());
        return "projects";
    }

    @GetMapping("/projects/create")
    public String createProjectForm() {
        return "project-create";
    }

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

        projectRepository.save(project);
        return "redirect:/projects";
    }

    @GetMapping("/projects/{id}")
    public String showProject(@PathVariable Long id, Model model) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Project not found"));

        model.addAttribute("project", project);
        model.addAttribute("hoursPerDay", project.getHoursPerDay());

        return "project-details";
    }

    @PostMapping("/projects/{id}/tasks")
    public String addTask(
            @PathVariable Long id,
            @RequestParam String taskName,
            @RequestParam int estimatedHours
    ) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Project not found"));

        project.addTask(taskName, estimatedHours);
        projectRepository.save(project);

        return "redirect:/projects/" + id;
    }
}