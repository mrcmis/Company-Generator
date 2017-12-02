package people;

import reports.Report;

public interface Employee {

     String getName();
     Role getRole();

    /**
     *@return true if task has been properly assigned, if not - false
     */
     boolean assign(Task task);
     Report reportWork();

}