package structures;

import employees.Developer;
import employees.Employee;
import employees.Role;
import employees.TeamManager;

public class PrintEmployeeService {
    public static void printEmployee(Employee employee) {
        if (employee.getRole() == Role.TEAMMANAGER || employee.getRole() == Role.CEO) {
            printTeamManager((TeamManager) employee);
        } else {
            printDeveloper((Developer) employee);
        }
    }

    private static void printTeamManager(TeamManager teamManager) {
        String employeesToString = "\n  ";
        for (Employee employee : teamManager.getEmployeeList()) {
            employeesToString += employee.getRole() + " " + employee.getName() + " " + employee.getSurname() + "\n  ";
        }
        System.out.println(teamManager.toString() + employeesToString);
    }

    private static void printDeveloper(Developer developer) {
        System.out.println(developer.toString());
        developer.reportWork().show();
    }

}
