package people;

import reports.Report;
import reports.TeamManagerReport;
import structures.Task;

import java.util.ArrayList;
import java.util.List;

public class TeamManager extends AbstractEmployee
        implements Manager {

    private final int limitOfEmployees;
    private final TeamManagerReport report = new TeamManagerReport(this);
    private final ArrayList<Employee> listOfEmployees
            = new ArrayList<>();

    public TeamManager(String name, int limitOfEmployees, Role role) {
        super(name, role);
        this.limitOfEmployees = limitOfEmployees;
    }


    @Override
    public boolean hire(Employee employee) {
        if (listOfEmployees.size() < limitOfEmployees) {
            listOfEmployees.add(employee);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean fire(Employee employee) {
        return listOfEmployees.remove(employee);
    }

    @Override
    public boolean canHire() {
        return (listOfEmployees.size() < limitOfEmployees);
    }


    public List<Employee> getWorkList() {
        return listOfEmployees;
    }

    @Override
    public boolean assign(Task task) {
        for (int i = 0; i < listOfEmployees.size(); i++) {
            if (listOfEmployees.get(i).assign(task)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Report reportWork() {
        return report;
    }

}
