package structures;

import employees.Employee;
import employees.Manager;
import employees.RandomPersonFactory;
import employees.Role;

import java.util.Random;

public class RandomFirmFactory {

    private Firm firm;
    private Random generator = new Random();

    public Firm getRandomFirm() {
        firm = new Firm(RandomString.getRandomString());
        int NUMBER_OF_LEVELS = generator.nextInt(7) + 1;

        firm.setCeoDirector(new RandomPersonFactory().getRandomCEO());
        hireRandom(firm.getCeoDirector(), NUMBER_OF_LEVELS);

        while (firm.getCeoDirector().assign(RandomTaskFactory.getRandomTask())) ;

        return firm;
    }

    private void hireRandom(Manager manager, int maxLevel) {
        Employee randomEmployee;
        if (maxLevel == 0) {
            return; //recursion end
        } else {
            for (int i = 0; i < generator.nextInt(20); i++) {
                randomEmployee = getRandomEmployee();
                manager.hire(randomEmployee);
                if (randomEmployee.getRole() == Role.TEAMMANAGER) {
                    hireRandom((Manager) randomEmployee, maxLevel - 1);
                }
            }
        }
    }

    private Employee getRandomEmployee() {

        RandomPersonFactory personFactory = new RandomPersonFactory();
        final double CHANCE_TO_GET_DEV = 0.66;

        if (generator.nextDouble() < CHANCE_TO_GET_DEV) {
            return personFactory.getRandomDeveloper();
        } else {
            return personFactory.getRandomManager();
        }
    }
}