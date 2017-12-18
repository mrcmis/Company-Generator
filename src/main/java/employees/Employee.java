package employees;

import reports.Report;
import structures.Task;

public interface Employee {

    String getName();

    String getSurname();

    Sex getSex();

    String getEmail();

    String getUniversity();

    String getCountry();

    Role getRole();

    boolean assign(Task task);

    int getUnitOfWork();

    Report reportWork();
}