package people;

public abstract class AbstractEmployee implements Employee{

   private final String name;
   final Role role;

    public AbstractEmployee(String empName, Role empRole){
        name = empName;
        role = empRole;
    }

    public String getName(){
        return name;
    }

    public Role getRole(){
        return role;
    }

    @Override
    public String toString(){
        return getRole() + " " + getName();
    }

}
