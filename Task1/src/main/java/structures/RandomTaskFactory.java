package structures;

import java.util.Random;

public class RandomTaskFactory {

    private static String[] taskNamesArray = {"developing new soft", "fixing bugs", "preparing coffee", "contact with client"};

    public static Task getRandomTask() {
        int MAX_TASK_WEIGHT = 6;

        Random generator = new Random();
        String taskDescription = taskNamesArray[generator.nextInt(taskNamesArray.length)];
        int taskWeight = generator.nextInt(MAX_TASK_WEIGHT) + 1;

        return new Task(taskDescription, taskWeight);
    }

}
