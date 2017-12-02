import java.util.ArrayList;
import PersonFactory.*;

public class Main {

    public static void main(String[] args) {

        PersonFactory personFactory = new PersonFactory();
        PersonInterface person1 = personFactory.getPerson("Person");

        person1.getName();


        ArrayList<Person> listOfPeople;
        listOfPeople = new PersonGenerator().createRandomList(30);

        for(Person randomPerson : listOfPeople){
            System.out.println(randomPerson);
        }
    }
}
