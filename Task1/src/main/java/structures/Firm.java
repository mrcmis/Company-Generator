package structures;

import employees.RandomPersonFactory;
import employees.TeamManager;

public class Firm {

    private final String name;
    private TeamManager ceoDirector = new RandomPersonFactory().getRandomCEO();

    public Firm(String firmName) {
        name = firmName;
    }

    public TeamManager getCeoDirector() {
        return ceoDirector;
    }

    public void setCeoDirector(TeamManager newCeoDirector) {
        copyEmployees(newCeoDirector);
        ceoDirector = newCeoDirector;
    }

    private void copyEmployees(TeamManager newCeoDirector) {
        for (int i = 0; i < ceoDirector.getEmployeeList().size(); i++) {
            newCeoDirector.hire(ceoDirector.getEmployeeList().get(i));
        }
    }

    @Override
    public String toString() {
        return "COMPANY " + name + "with CEO: " + ceoDirector.getName() + " "
                + ceoDirector.getSurname() + " and " + ceoDirector.getAllSubordinatesList().size() + " employees";
    }
}
