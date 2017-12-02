import people.*;

public class Main {
    public static void main(String[] args) {

        Firm firm = new RandomFirmFactory().getRandomFirm(Integer.parseInt(args[0]));
        firm.getCeoDirector().reportWork().showWork(firm.getCeoDirector().getName(),0);

    }
}
