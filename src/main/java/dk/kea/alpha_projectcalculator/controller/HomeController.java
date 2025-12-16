package dk.kea.alpha_projectcalculator.controller;

import dk.kea.alpha_projectcalculator.model.Project;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/projects")
    public String projects(Model model) {
        List<Project> projects = new ArrayList<>();
        projects.add(new Project(1L, "Website til KundeX", "KundeX", 120));
        projects.add(new Project(2L, "Internt CRM System", "Alpha Solutions", 200));
        projects.add(new Project(3L, "App til HR-afdelingen", "KundeY", 90));

        model.addAttribute("projects", projects);
        return "projects";
    }
}
