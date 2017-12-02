package people;

import reports.CeoReport;
import reports.Report;

public class CeoDirector extends AbstractEmployee implements Manager{

    final int limitOfEmployees;
    private final CeoReport report = new CeoReport();

    public CeoDirector(String empName, int ceoLimitOfEmployees) {
        super(empName, Role.CEO);
        limitOfEmployees = ceoLimitOfEmployees;
    }

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
        return report.getWorkList().size() < limitOfEmployees;
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
