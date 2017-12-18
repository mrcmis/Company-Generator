package employees;

import java.util.function.Predicate;

public class HireConditions {

    public static Predicate<Employee> requireNothing() {
        return (employee) -> true;
    }

    public static Predicate<Employee> requireUniversity(String university) {
        return (employee) -> employee.getUniversity().equals(university);
    }

    public static Predicate<Employee> requireSex(Sex sex) {
        return employee -> employee.getSex() == sex;
    }

    public static Predicate<Employee> requireCountry(String country) {
        return (employee) -> employee.getCountry().equals(country);
    }

    public static Predicate<Employee> requireEmail(String email) {
        return (employee) -> employee.getEmail().contains("@" + email);
    }
}
