package employees;

import java.util.List;

public interface Manager extends Employee {
    boolean hire(Employee employee);

    boolean fire(Employee employee);

    boolean canHire(Employee employee);

    List<Employee> getEmployeeList();

    List<Employee> getAllSubordinatesList();
}


