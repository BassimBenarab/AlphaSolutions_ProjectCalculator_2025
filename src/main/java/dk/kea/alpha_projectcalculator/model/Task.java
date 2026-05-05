package dk.kea.alpha_projectcalculator.model;

import jakarta.persistence.*;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int estimatedHours;

    public Task() {
    }

    public Task(String name, int estimatedHours) {
        this.name = name;
        this.estimatedHours = estimatedHours;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getEstimatedHours() {
        return estimatedHours;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEstimatedHours(int estimatedHours) {
        this.estimatedHours = estimatedHours;
    }
}