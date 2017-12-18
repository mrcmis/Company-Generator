package structures;

import employees.Developer;
import employees.Employee;
import employees.Role;
import employees.TeamManager;

public class FirmVisualizer {
    public void visualize(Firm firm) {
        showWithIndent(0, firm.getCeoDirector());
    }

    private void showWithIndent(int indentLevel, Employee employee) {
        if (employee.getRole() == Role.TEAMMANAGER || employee.getRole() == Role.CEO) {
            showTeamManager(indentLevel, (TeamManager) employee);
        } else {
            showDeveloper(indentLevel, (Developer) employee);
        }
    }

    private void showDeveloper(int indentLevel, Developer developer) {
        String output = String.format("%" + indentLevel + "s", " ");
        System.out.print(output);

        System.out.println(developer.getRole() + " " + developer.getName() + " " + developer.getSurname() + " that: ");

        for (Task task : developer.getTaskList()) {
            output = String.format("%" + 2 * indentLevel + "s", " ");
            System.out.print(output);
            System.out.println(task);
        }
    }

    private void showTeamManager(int indentLevel, TeamManager teamManager) {
        String output = String.format("%" + (indentLevel + 1) + "s", " ");
        System.out.print(output);

        System.out.println(teamManager.getRole() + " " + teamManager.getName() + " " + teamManager.getSurname() + " hiring:");
        for (Employee employee : teamManager.getEmployeeList()) {
            System.out.print(output);
            showWithIndent(indentLevel + 5, employee);
        }
    }

}
