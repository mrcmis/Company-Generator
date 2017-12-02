package people;

import java.util.Random;

public class RandomFirmFactory {

    Firm firm;
    Random generator = new Random();

    public Firm getRandomFirm(int randomLevel) {
        firm = new Firm(new RandomString().getRadnomString());

        hireRandom(firm.getCeoDirector(), randomLevel);

        while(firm.getCeoDirector().assign(getRandomTask()));

        return firm;
    }

    public void hireRandom(Manager manager, int level) {
        Employee randomEmployee;
        if (level == 0) {
            return; //recursion end
        } else {
            for (int i = 0; i < generator.nextInt(20); i++) {
                randomEmployee = getRandomEmployee();
                manager.hire(randomEmployee);
                if (randomEmployee instanceof Manager) {
                    hireRandom((Manager) randomEmployee, level - 1);
                }
            }
        }
    }

    public Employee getRandomEmployee() {

        PersonFactory personFactory = new PersonFactory();
        String randomName = new RandomString().getRadnomString();
        int randomLimit = 6 + generator.nextInt(10);

        if (generator.nextInt() % 2 == 0) {
            return personFactory.getPerson(Role.TEAMMANAGER,
                    randomName, randomLimit);
        } else {
            return personFactory.getPerson(Role.DEVELOPER, randomName, randomLimit);
        }
    }

    public Task getRandomTask(){
        int randomInt = generator.nextInt(3);
        switch (randomInt){
            case 0: return Task.DOTEST;
            case 1: return Task.DEVNEWSOFT;
            case 2: return Task.BUGFIX;
            default: return null;
        }
    }
}
