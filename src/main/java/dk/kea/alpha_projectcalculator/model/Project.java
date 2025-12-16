package dk.kea.alpha_projectcalculator.model;

public class Project {

    private Long id;
    private String name;
    private String customer;
    private int estimatedHours;

    public Project() {
    }

    public Project(Long id, String name, String customer, int estimatedHours) {
        this.id = id;
        this.name = name;
        this.customer = customer;
        this.estimatedHours = estimatedHours;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public int getEstimatedHours() {
        return estimatedHours;
    }

    public void setEstimatedHours(int estimatedHours) {
        this.estimatedHours = estimatedHours;
    }
}
