package PersonFactory;

public class PersonFactory {

    public PersonInterface getPerson(String typeOfPerson){
        if(typeOfPerson.equals("Person")) {
            return new Person();
        } else{
            return null;
        }
    }
}
