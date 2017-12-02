package reports;

import people.Employee;

import java.util.ArrayList;
import java.util.List;

public class CeoReport implements Report {

   private final ArrayList<Employee> listOfEmployees
                         = new ArrayList<>();

    @Override
    public List<Employee> getWorkList() {
        return listOfEmployees;
    }

    @Override
    public void showWork(String name, int indentLevel) {
        System.out.println("CEO " + name + "hiring: ");
        for (Employee employee : listOfEmployees){
            for (int i = 0; i < indentLevel; i++) {
                System.out.print(" ");
            }
            employee.reportWork().showWork(employee.getName(), indentLevel + 5);
        }
    }
}
