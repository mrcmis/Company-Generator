package people;

public class PersonFactory {

    public AbstractEmployee getPerson(Role role, String name, int limit){
        switch (role){
            case CEO: return new CeoDirector(name,limit);
            case TEAMMANAGER: return new TeamManager(name,limit);
            case DEVELOPER: return new Developer(name, limit);
            default: return null;
        }
    }

}
