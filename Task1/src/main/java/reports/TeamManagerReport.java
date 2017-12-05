package reports;

import people.Employee;
import people.TeamManager;

public class TeamManagerReport implements Report {

    private final TeamManager teamManager;

    public TeamManagerReport(TeamManager teamManager) {
        this.teamManager = teamManager;
    }

    @Override
    public void showWork(int indentLevel) {

        String output = String.format("%" + (indentLevel + 1) + "s", " ");
        System.out.print(output);

        System.out.println(teamManager.getRole() + " " + teamManager.getName() + " hiring:");
        for (Employee employee : teamManager.getWorkList()) {
            System.out.print(output);
            employee.reportWork().showWork(indentLevel + 5);
        }
    }

}
