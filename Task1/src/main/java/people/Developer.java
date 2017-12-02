package people;

import reports.DeveloperReport;

public class Developer extends AbstractEmployee {

    int freeResources;
    private final DeveloperReport report = new DeveloperReport();

    public Developer(String empName, int devFreeResources) {
        super(empName, Role.DEVELOPER);
        freeResources = devFreeResources;
    }


    @Override
    public boolean assign(Task task) {
        if(task.weight <= freeResources){
            freeResources -= task.weight;
            report.getWorkList().add(task);
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
