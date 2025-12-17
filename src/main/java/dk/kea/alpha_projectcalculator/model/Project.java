package dk.kea.alpha_projectcalculator.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Project {

    private String name;
    private String customer;
    private LocalDate deadline;

    private List<Task> tasks = new ArrayList<>();

    public Project(String name, String customer, LocalDate deadline) {
        this.name = name;
        this.customer = customer;
        this.deadline = deadline;
    }

    // ---------- GETTERS ----------

    public String getName() {
        return name;
    }

    public String getCustomer() {
        return customer;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    // ---------- OPGAVER ----------

    public void addTask(String name, int estimatedHours) {
        tasks.add(new Task(name, estimatedHours));
    }

    // ---------- BEREGNINGER ----------

    // Samlet estimeret tid for projektet
    public int getTotalEstimatedHours() {
        int total = 0;
        for (Task task : tasks) {
            total += task.getEstimatedHours();
        }
        return total;
    }

    // Antal dage til deadline
    public long getDaysUntilDeadline() {
        return ChronoUnit.DAYS.between(LocalDate.now(), deadline);
    }

    // Timer pr. dag for at nå deadline
    public double getHoursPerDay() {
        long days = getDaysUntilDeadline();
        if (days <= 0) {
            return 0;
        }
        return (double) getTotalEstimatedHours() / days;
    }
}
