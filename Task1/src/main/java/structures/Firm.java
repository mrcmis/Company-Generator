package structures;

import people.Role;
import people.TeamManager;

public class Firm {

    private TeamManager ceoDirector
            = new TeamManager("default", 100, Role.TEAMMANAGER);
    private final String name;

    public Firm(String firmName) {
        name = firmName;
    }

    public TeamManager getCeoDirector() {
        return ceoDirector;
    }

    public void setCeoDirector(TeamManager newCeoDirector) {
        ceoDirector = newCeoDirector;
    }
}
