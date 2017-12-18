package employees;

import structures.RandomString;

import java.util.Random;
import java.util.function.Predicate;

public class RandomPersonFactory {

    private static String[] nameArray = {"John", "Alex", "Oliver", "Gabi", "Gab", "Leo", "Muhammed", "Jacob", "William", "Nathan", "Leo"};
    private static String[] surnameArray = {"Simpson", "Porter", "Bradley", "Stone", "Collins", "Coleman", "Hayes"};
    private static String[] emailArray = {"onet.pl", "gmail.com", "o2.pl", "yahoo.com", "hotmail.com"};
    private static String[] countryArray = {"Poland", "Russia", "Ukraine", "Germany", "Slovakia", "UK", "USA"};
    private static String[] universityArray = {"agh", "uj", "pk", "sgh", "uw", "pw"};

    Random generator = new Random();

    public Developer getRandomDeveloper() {
        Developer randomDeveloper = new Developer(getRandomName(), getRandomSurname(), getRandomDeveloperRole(),
                getRandomSex(), getRandomUniversity(),
                getRandomEmail(), getCountry(), getRandomLimit());
        return randomDeveloper;
    }

    public TeamManager getRandomManager() {
        TeamManager teamManager = new TeamManager(getRandomName(), getRandomSurname(), getRandomManagerRole(),
                getRandomSex(), getRandomUniversity(), getRandomEmail(),
                getCountry(), getRandomLimit(), getRandomPredicate());

        return teamManager;
    }

    public TeamManager getRandomCEO() {
        TeamManager ceoManager = new TeamManager(getRandomName(), getRandomSurname(), Role.CEO,
                getRandomSex(), getRandomUniversity(), getRandomEmail(),
                getCountry(), getRandomLimit(), getRandomPredicate());
        return ceoManager;
    }

    private Sex getRandomSex() {
        return generator.nextBoolean() ? Sex.FEMALE : Sex.MALE;
    }

    private String getRandomEmail() {
        return RandomString.getRandomString()
                + "@" + emailArray[generator.nextInt(emailArray.length)];

    }

    private String getRandomUniversity() {
        return universityArray[generator.nextInt(universityArray.length)];
    }

    private String getRandomName() {
        return nameArray[generator.nextInt(nameArray.length)];
    }

    private String getRandomSurname() {
        return surnameArray[generator.nextInt(surnameArray.length)];
    }

    private String getCountry() {
        return countryArray[generator.nextInt(countryArray.length)];
    }

    private int getRandomLimit() {
        return 6 + generator.nextInt(10);
    }

    private Role getRandomDeveloperRole() {
        Role[] arrayOfRoles = {Role.CONTRIBUTOR, Role.TESTER, Role.DEVELOPER, Role.TEAMLEADER};
        return arrayOfRoles[generator.nextInt(4)];
    }

    private Role getRandomManagerRole() {
        return Role.TEAMMANAGER;
    }

    private Predicate<Employee> getRandomPredicate() {
        return HireConditions.requireNothing();
    }

}
