package people;

public class PersonFactory {

    public AbstractEmployee getPerson(Role role, String name, int limit) {
        switch (role) {
            case TEAMMANAGER:
                return new TeamManager(name, limit, Role.TEAMMANAGER);
            case CEO:
                return new TeamManager(name, limit, Role.CEO);
            case DEVELOPER:
                return new Developer(name, limit, Role.DEVELOPER);
            case TESTER:
                return new Developer(name, limit, Role.TESTER);
            case CONTRIBUTOR:
                return new Developer(name, limit, Role.CONTRIBUTOR);
            case TEAMLEADER:
                return new Developer(name, limit, Role.TEAMLEADER);
            default:
                return null;
        }
    }

}
