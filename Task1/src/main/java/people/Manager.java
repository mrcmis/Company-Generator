package people;

public interface Manager extends Employee {
     boolean hire(Employee employee);
     boolean fire(Employee employee);
     boolean canHire();
}


