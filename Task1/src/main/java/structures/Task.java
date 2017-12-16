package structures;

public class Task {
    private String description;
    private int weight;

    public Task(String description, int weight) {
        this.description = description;
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "TASK: " + description + " WEIGHT: " + getWeight();
    }
}
