package PersonFactory;
import java.util.*;

/**
 * class which represents a Person
 * <essential info>
 * @version 1.0.0
 * @author Marcin Miś
 */
public class Person implements Comparable<Person>,PersonInterface{

    private String name;
    private String surname;
    private String email;
    private static String nameRegex = "[a-zA-z]+"; //name regex fits to name and surname
    private static String emailRegex = "[a-zA-z0-9.]+@[a-zA-Z0-9]+.[a-zA-Z]+";

    public Person(){
        name = "defaultName";
        surname = "defaultSurname";
        email = "default@e.mail";
    }

    public Person (String personName, String personSurname,
                   String personEmail) throws IllegalArgumentException {

        if (!personName.matches(nameRegex)){
            throw new IllegalArgumentException("invalid personName");
        }
        name = personName;

        if (!personSurname.matches(nameRegex)){
            throw new IllegalArgumentException("invalid personSurname");
        }
        surname = personSurname;

        if (!personEmail.matches(emailRegex)){
            throw new IllegalArgumentException("invalid personEmail");
        }
        email = personEmail;
    }

    public void setName(String personName) throws IllegalArgumentException{
        if (!personName.matches(nameRegex)){
            throw new IllegalArgumentException("invalid name");
        }
        name = personName;
    }

    public void setName() throws IllegalArgumentException{
        String personName;
        Scanner scanner = new Scanner(System.in);

        personName = scanner.nextLine();

        setName(personName);
    }

    public void setSurname(String personSurname)throws IllegalArgumentException{
        if (!personSurname.matches(nameRegex)){
            throw new IllegalArgumentException("invalid surname");
        }
        name = personSurname;
    }

    public void setSurname() throws IllegalArgumentException{
        String personSurname;
        Scanner scanner = new Scanner(System.in);

        personSurname = scanner.nextLine();

        setSurname(personSurname);
    }

    public void setEmail(String personEmail)throws IllegalArgumentException{
        if (!personEmail.matches(emailRegex)){
            throw new IllegalArgumentException("invalid email");
        }
        name = personEmail;
    }

    public void setEmail() throws IllegalArgumentException{
        String personEmail;
        Scanner scanner = new Scanner(System.in);

        personEmail = scanner.nextLine();

        setEmail(personEmail);
    }

    @Override
    public String toString(){
        return "name: " + name +" surname: " + surname + " email: " + email;
    }

    @Override
    public int compareTo(Person anotherPerson) {

        if (this.name.compareTo(anotherPerson.name) != 0){
            return this.name.compareTo(anotherPerson.name);
        } else if (this.surname.compareTo(anotherPerson.surname) != 0){
            return this.surname.compareTo(anotherPerson.surname);
        } else {
            return this.email.compareTo(anotherPerson.email);
        }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getSurname() {
        return surname;
    }

    @Override
    public String getEmail() {
        return email;
    }
}