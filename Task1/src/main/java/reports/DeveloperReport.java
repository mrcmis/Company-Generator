package reports;

import people.Developer;
import structures.Task;

public class DeveloperReport implements Report {

    private final Developer developer;

    public DeveloperReport(Developer developer) {
        this.developer = developer;
    }

    public void showWork(int indentLevel) {
        String output = String.format("%"+ indentLevel +"s", " ");
        System.out.print(output);

        System.out.println(developer.getRole() + " " + developer.getName() + " that: ");

        for (Task task : developer.getWorkList()) {
            output = String.format("%"+ 2*indentLevel +"s", " ");
            System.out.print(output);
            System.out.println(task);
        }
    }

}
