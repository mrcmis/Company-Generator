package employees;

import com.google.common.collect.ImmutableList;
import reports.Report;
import reports.TeamManagerReport;
import structures.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class TeamManager extends AbstractEmployee
        implements Manager {

    private final int limitOfEmployees;
    private final ArrayList<Employee> listOfEmployees
            = new ArrayList<>();
    private final TeamManagerReport report = new TeamManagerReport(this);
    private Predicate<Employee> hireConditionFunction;

    public TeamManager(String name, String surname, Role role, Sex sex, String university, String email,
                       String country, int limitOfEmployees, Predicate<Employee> hireConditionFunction) {
        super(name, surname, role, sex, university, email, country);
        this.limitOfEmployees = limitOfEmployees;
        this.hireConditionFunction = hireConditionFunction;
    }

    public TeamManager(TeamManagerBuilder builder) {
        super(builder);
        this.limitOfEmployees = builder.limitOfEmployees;
        this.hireConditionFunction = builder.hireConditionFunction;
    }

    @Override
    public boolean hire(Employee employee) {
        if (canHire(employee)) {
            listOfEmployees.add(employee);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean fire(Employee employee) {
        return listOfEmployees.remove(employee);
    }

    @Override
    public boolean canHire(Employee employee) {
        return hireConditionFunction.test(employee) && listOfEmployees.size() < limitOfEmployees;
    }

    @Override
    public List<Employee> getAllSubordinatesList() {
        ArrayList<Employee> listOfAllSubordinates = new ArrayList<>(listOfEmployees);
        for (Employee employee : listOfEmployees) {
            if (employee.getRole() == Role.TEAMMANAGER) {
                listOfAllSubordinates.addAll(((Manager) employee).getAllSubordinatesList());
            }
        }
        return ImmutableList.copyOf(listOfAllSubordinates);
    }

    @Override
    public int getUnitOfWork() {
        return listOfEmployees.size();
    }

    @Override
    public List<Employee> getEmployeeList() {
        return ImmutableList.copyOf(listOfEmployees);
    }

    @Override
    public boolean assign(Task task) {
        for (int i = 0; i < listOfEmployees.size(); i++) {
            if (listOfEmployees.get(i).assign(task)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Report reportWork() {
        return report;
    }

    @Override
    public String toString() {
        return super.toString() + " hiring: " + listOfEmployees.size() + " employees";
    }

    public static class TeamManagerBuilder extends AbstractEmployee.EmployeeBuilder<TeamManagerBuilder> {

        private int limitOfEmployees;
        private Predicate<Employee> hireConditionFunction;

        public TeamManagerBuilder setLimitOfEmployees(int limitOfEmployees) {
            this.limitOfEmployees = limitOfEmployees;
            return this;
        }

        public TeamManagerBuilder setHireConditionFunction(Predicate<Employee> hireConditionFunction) {
            this.hireConditionFunction = hireConditionFunction;
            return this;
        }

        public TeamManager build() {
            return new TeamManager(this);
        }

    }
}
