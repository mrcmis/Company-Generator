package reports;

import people.Employee;

import java.util.ArrayList;
import java.util.List;

public class TeamManagerReport implements Report {

    private final ArrayList<Employee> listOfEmployees;

    public TeamManagerReport(){
        listOfEmployees = new ArrayList<Employee>();
    }

    @Override
    public List<Employee> getWorkList() {
        return listOfEmployees;
    }

    @Override
    public void showWork(String name, int indentLevel) {
        for (int i = 0; i < indentLevel; i++) {
            System.out.print(" ");
        }
        System.out.println("TeamManager " + name + " hiring:");
        for (Employee employee : listOfEmployees){
            for (int i = 0; i < indentLevel; i++) {
                System.out.print(" ");
            }
            employee.reportWork().showWork(employee.getName(), indentLevel + 5);
        }
    }

}
