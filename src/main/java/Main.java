import employees.*;
import structures.Firm;
import structures.FirmVisualizer;
import structures.RandomFirmFactory;

public class Main {
    public static void main(String[] args) {

        Firm firm = new RandomFirmFactory().getRandomFirm();

        Developer myDeveloper = new Developer.DeveloperBuilder()
                .setName("sampleName")
                .setSurname("sampleSurname")
                .setRole(Role.TESTER)
                .setEmail("sample@NOgmail.com")
                .setUniversity("sample")
                .setCountry("sample")
                .setSex(Sex.MALE)
                .setFreeResources(20)
                .build();

        TeamManager myCeo = new TeamManager.TeamManagerBuilder()
                .setName("CEOname")
                .setSurname("CEOsurname")
                .setRole(Role.CEO)
                .setEmail("ceo@gmail.com")
                .setUniversity("ceuUni")
                .setCountry("Ceoctr")
                .setSex(Sex.MALE)
                .setLimitOfEmployees(100)
                .setHireConditionFunction(HireConditions.requireNothing())
                .build();

        firm.getCeoDirector().reportWork().show();
        firm.setCeoDirector(myCeo);
        myCeo.hire(myDeveloper);
        myCeo.reportWork().show();

        new FirmVisualizer().visualize(firm);

        System.out.println(firm.toString());
    }
}
