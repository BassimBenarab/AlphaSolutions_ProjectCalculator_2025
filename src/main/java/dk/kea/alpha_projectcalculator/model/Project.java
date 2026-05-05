package dk.kea.alpha_projectcalculator.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String customer;
    private LocalDate deadline;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Task> tasks = new ArrayList<>();

    public Project() {
    }

    public Project(String name, String customer, LocalDate deadline) {
        this.name = name;
        this.customer = customer;
        this.deadline = deadline;
    }

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

    public long getDaysUntilDeadline() {
        return ChronoUnit.DAYS.between(LocalDate.now(), deadline);
    }

    public double getHoursPerDay() {
        long days = getDaysUntilDeadline();
        if (days <= 0) {
            return 0;
        }
        return (double) getTotalEstimatedHours() / days;
    }
}