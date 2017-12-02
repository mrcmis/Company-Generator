package people;

import java.util.Random;

public class RandomString {

    public String randomString;
    Random generator = new Random();

    public String getRadnomString(){
        randomString = "";
        for(int j = 0; j < 2 + (generator.nextInt(15)); j++){
            randomString += (char)('a' + new Random().nextInt('z'-'a'));
        }
        return randomString;
    }

}
