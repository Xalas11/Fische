import java.io.IOException;

/**
 * Created by bjarne on 09.05.16.
 */
public class Testprogramm {

    public static void main(String[] args) {
        FishCalculator calculator = new FishCalculator();
        Fish[] pop = new Fish[0];
        try {
            pop = Parser.readFishFromFile("fishes.txt");
        } catch (IOException e) {
           System.out.print("Fish.txt Datei wurde nicht gefunden.");
            System.exit(1);
        }
        Parser.printFishList(pop);
        calculator.setPopulation(pop);
        calculator.calculate(170);
    }
}
