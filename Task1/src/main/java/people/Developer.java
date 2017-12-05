package people;

import reports.DeveloperReport;
import structures.Task;

import java.util.ArrayList;
import java.util.List;

public class Developer extends AbstractEmployee {

    int freeResources;
    private final DeveloperReport report = new DeveloperReport(this);
    private final ArrayList<Task> listOfTasks
            = new ArrayList<>();

    public Developer(String name, int freeResources, Role role) {
        super(name, role);
        this.freeResources = freeResources;
    }

    public List<Task> getWorkList() {
        return listOfTasks;
    }

    @Override
    public boolean assign(Task task) {
        if (task.getWeight() <= freeResources) {
            freeResources -= task.getWeight();
            listOfTasks.add(task);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public DeveloperReport reportWork() {
        return report;
    }
}
