package people;

public abstract class AbstractEmployee implements Employee {

    private final String name;
    private final Role role;

    public AbstractEmployee(String name, Role role) {
        this.name = name;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public Role getRole() {
        return role;
    }

    @Override
    public String toString() {
        return getRole() + " " + getName();
    }

}
