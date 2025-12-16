package dk.kea.alpha_projectcalculator.model;

public class Task {

    private String name;
    private int estimatedHours;

    public Task(String name, int estimatedHours) {
        this.name = name;
        this.estimatedHours = estimatedHours;
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
