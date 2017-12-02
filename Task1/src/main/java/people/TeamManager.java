package people;

import reports.Report;
import reports.TeamManagerReport;

public class TeamManager extends AbstractEmployee
                         implements Manager{

    private final int limitOfEmployees;
    private final TeamManagerReport report = new TeamManagerReport();

    public TeamManager(String empName, int empLimitOfEmployees) {
        super(empName, Role.TEAMMANAGER);
        limitOfEmployees = empLimitOfEmployees;
    }


    @Override
    public boolean hire(Employee employee) {
        if(report.getWorkList().size() < limitOfEmployees){
            report.getWorkList().add(employee);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean fire(Employee employee) {
        return report.getWorkList().remove(employee);
    }

    @Override
    public boolean canHire() {
        return (report.getWorkList().size() < limitOfEmployees);
    }

    @Override
    public boolean assign(Task task) {
        for (int i = 0; i < report.getWorkList().size(); i++) {
            if(report.getWorkList().get(i).assign(task)){
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
