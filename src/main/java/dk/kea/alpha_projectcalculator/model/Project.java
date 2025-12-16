package dk.kea.alpha_projectcalculator.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Project {

    private Long id;
    private String name;
    private String customer;
    private LocalDate deadline;

    private List<Task> tasks = new ArrayList<>();

    public Project(Long id, String name, String customer, LocalDate deadline) {
        this.id = id;
        this.name = name;
        this.customer = customer;
        this.deadline = deadline;
    }

    // -------- Getters --------

    public Long getId() {
        return id;
    }

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

    // -------- Forretningslogik --------

    public void addTask(String name, int estimatedHours) {
        tasks.add(new Task(name, estimatedHours));
    }

    public int getTotalEstimatedHours() {
        int total = 0;
        for (Task task : tasks) {
            total += task.getEstimatedHours();
        }
        return total;
    }

    public long getRemainingDays() {
        return ChronoUnit.DAYS.between(LocalDate.now(), deadline);
    }

    public double getHoursPerDay() {
        long days = getRemainingDays();
        if (days <= 0) {
            return getTotalEstimatedHours();
        }
        return (double) getTotalEstimatedHours() / days;
    }
}
