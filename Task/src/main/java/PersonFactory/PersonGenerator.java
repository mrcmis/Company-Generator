package PersonFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * inner class to generate random Person's class objects
 * <essential info>
 *    //na początku klasa miała być klasą wewnetrzną klasy Person
 *    nie wiem jak byłoby najlepiej
 */
public class PersonGenerator{

    public PersonGenerator(){}

    public ArrayList<Person> createRandomList(int numberOfPeople){

        ArrayList<Person> listOfPeople = new ArrayList <Person>();
        Random generator = new Random();
        char randomChar;
        StringBuilder randomName = new StringBuilder();
        StringBuilder randomSurname = new StringBuilder();
        StringBuilder randomEmail = new StringBuilder();

        for(int i = 0; i < numberOfPeople; i++){

            for(int j = 0; j < 2 + (generator.nextInt(15)); j++){
                randomChar = randomCharBuilder();
                randomName.append(randomChar);

                randomChar = randomCharBuilder();
                randomSurname.append(randomChar);

                randomChar = randomCharBuilder();
                randomEmail.append(randomChar);
            }

            randomEmail.append('@');
            for(int j = 0; j < 2 + (generator.nextInt(10)); j++){
                randomChar = randomCharBuilder();
                randomEmail.append(randomChar);
            }

            randomEmail.append(".");
            for(int j = 0; j < 2 + (generator.nextInt(5)); j++){
                randomChar = randomCharBuilder();
                randomEmail.append(randomChar);
            }

            listOfPeople.add(new Person(randomName.toString(),
                    randomSurname.toString(), randomEmail.toString()));

            randomName.setLength(0);
            randomSurname.setLength(0);
            randomEmail.setLength(0);
        }

        Collections.sort(listOfPeople);
        return listOfPeople;
    }

    private char randomCharBuilder(){
        return (char)('a' + new Random().nextInt('z'-'a'));
    }
}