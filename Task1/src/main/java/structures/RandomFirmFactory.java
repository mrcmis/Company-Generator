package structures;

import people.Employee;
import people.Manager;
import people.PersonFactory;
import people.Role;

import java.util.Random;

public class RandomFirmFactory {

    Firm firm;
    Random generator = new Random();

    public Firm getRandomFirm(int randomLevel) {
        firm = new Firm(new RandomString().getRandomString());

        hireRandom(firm.getCeoDirector(), randomLevel);

        while (firm.getCeoDirector().assign(getRandomTask())) ;

        return firm;
    }

    public void hireRandom(Manager manager, int maxLevel) {
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

    public Employee getRandomEmployee() {

        PersonFactory personFactory = new PersonFactory();
        String randomName = new RandomString().getRandomString();
        int randomLimit = 6 + generator.nextInt(10);

        switch (generator.nextInt(6)) {
            case 0:
                return personFactory.getPerson(Role.TEAMMANAGER,
                        randomName, randomLimit);
            case 1:
                return personFactory.getPerson(Role.TEAMMANAGER,
                        randomName, randomLimit);
            case 2:
                return personFactory.getPerson(Role.DEVELOPER,
                        randomName, randomLimit);
            case 3:
                return personFactory.getPerson(Role.TESTER,
                        randomName, randomLimit);
            case 4:
                return personFactory.getPerson(Role.TEAMLEADER,
                        randomName, randomLimit);
            case 5:
                return personFactory.getPerson(Role.CONTRIBUTOR,
                        randomName, randomLimit);
            default:
                return null;
        }
    }

    public Task getRandomTask() {
        return new Task(new RandomString().getRandomString(), generator.nextInt(6) + 1);
    }
}