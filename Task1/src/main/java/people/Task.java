package people;


/**
 * Enum representing Task
 *
 */
public enum Task {
    BUGFIX(5),
    DEVNEWSOFT(10),
    DOTEST(6);

    int weight;

    Task(int weightOfTask){
        weight = weightOfTask;
    }

}
