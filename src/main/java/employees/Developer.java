package employees;

import com.google.common.collect.ImmutableList;
import reports.DeveloperReport;
import structures.Task;

import java.util.ArrayList;
import java.util.List;

public class Developer extends AbstractEmployee {

    private final ArrayList<Task> listOfTasks
            = new ArrayList<>();
    private final DeveloperReport report = new DeveloperReport(this);
    private int freeResources;

    public Developer(String name, String surname, Role role, Sex sex,
                     String university, String email, String country, int freeResources) {
        super(name, surname, role, sex, university, email, country);
        this.freeResources = freeResources;
    }

    public Developer(DeveloperBuilder builder) {
        super(builder);
        this.freeResources = builder.freeRersources;
    }

    @Override
    public int getUnitOfWork() {
        int unitOfWork = 0;
        for (Task task : listOfTasks) {
            unitOfWork += task.getWeight();
        }
        return unitOfWork;
    }

    public List<Task> getTaskList() {
        return ImmutableList.copyOf(listOfTasks);
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
    public String toString() {
        return super.toString() + " unit of work: " + getUnitOfWork();
    }

    @Override
    public DeveloperReport reportWork() {
        return report;
    }

    public static class DeveloperBuilder extends AbstractEmployee.EmployeeBuilder<DeveloperBuilder> {

        private int freeRersources;

        public DeveloperBuilder setFreeResources(int freeResources) {
            this.freeRersources = freeResources;
            return this;
        }

        public Developer build() {
            return new Developer(this);
        }
    }
}
