package reports;

import people.Task;

import java.util.ArrayList;
import java.util.List;

public class DeveloperReport implements Report {

    private final ArrayList<Task> listOfTasks
                            = new ArrayList<>();

    public List getWorkList(){
        return listOfTasks;
    }

    public void showWork(String name, int indentLevel){
        for (int i = 0; i < indentLevel; i++) {
            System.out.print(" ");
        }
        System.out.println("Developer " + name + " that: ");
        for(Task task : listOfTasks){
            for (int i = 0; i < 2*indentLevel; i++) {
                System.out.print(" ");
            }
            if(task == Task.BUGFIX){
                System.out.println("fixing bugs");
            } else if (task == Task.DEVNEWSOFT){
                System.out.println("developing new soft");
            } else if (task == Task.DOTEST) {
                System.out.println("doint tests");
            }
        }
    }

}
