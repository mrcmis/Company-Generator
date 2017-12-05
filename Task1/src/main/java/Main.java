import structures.Firm;
import structures.RandomFirmFactory;
import structures.Task;

public class Main {
    public static void main(String[] args) {

        Task task = new Task("AAAAAAAAAA", 3);
        Task task1 = new Task("BBBBBbBB", 3);

        Firm firm = new RandomFirmFactory().getRandomFirm(Integer.parseInt(args[0]));
        firm.getCeoDirector().reportWork().showWork(0);

    }
}
