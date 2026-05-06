package dk.kea.alpha_projectcalculator;

import dk.kea.alpha_projectcalculator.model.Project;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ProjectTest {

    @Test
    void shouldCalculateTotalEstimatedHours() {
        Project project = new Project("Website", "Alpha", LocalDate.now().plusDays(10));

        project.addTask("Frontend", 5);
        project.addTask("Backend", 10);

        assertEquals(15, project.getTotalEstimatedHours());
    }

    @Test
    void shouldCalculateDaysUntilDeadline() {
        Project project = new Project("Website", "Alpha", LocalDate.now().plusDays(5));

        assertEquals(5, project.getDaysUntilDeadline());
    }

    @Test
    void shouldCalculateHoursPerDay() {
        Project project = new Project("Website", "Alpha", LocalDate.now().plusDays(5));

        project.addTask("Frontend", 10);

        assertEquals(2.0, project.getHoursPerDay());
    }

    @Test
    void shouldReturnZeroHoursPerDayIfDeadlineIsToday() {
        Project project = new Project("Website", "Alpha", LocalDate.now());

        project.addTask("Frontend", 10);

        assertEquals(0, project.getHoursPerDay());
    }
}