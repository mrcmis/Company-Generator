package reports;

import employees.Employee;
import structures.Task;

import java.util.Comparator;

public class ReportComparator {

    public static Comparator<Employee> employeeLexicalSort() {
        return Comparator
                .comparing(Employee::getSurname)
                .thenComparing(Employee::getName)
                .thenComparing((emp1, emp2) -> emp1.getRole().name().compareTo(emp2.getRole().name()))
                .thenComparing(Employee::getUnitOfWork);
    }

    public static Comparator<Task> taskWeightSort() {
        return Comparator
                .comparing(Task::getWeight)
                .thenComparing(Task::toString);
    }

    public static Comparator<Task> taskNameSort() {
        return Comparator
                .comparing(Task::toString)
                .thenComparing(Task::getWeight);
    }
}
