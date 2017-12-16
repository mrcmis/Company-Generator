package reports;

import employees.TeamManager;
import structures.PrintEmployeeService;

public class TeamManagerReport extends AbstractReport {

    private final TeamManager teamManager;

    public TeamManagerReport(TeamManager teamManager) {
        this.teamManager = teamManager;
    }

    @Override
    public void show() {
        teamManager.getAllSubordinatesList()
                .stream()
                .sorted(ReportComparator.employeeLexicalSort())
                .forEach(PrintEmployeeService::printEmployee);
    }

}
