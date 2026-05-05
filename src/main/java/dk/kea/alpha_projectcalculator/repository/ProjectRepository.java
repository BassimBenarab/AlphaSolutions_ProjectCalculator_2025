package dk.kea.alpha_projectcalculator.repository;

import dk.kea.alpha_projectcalculator.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}