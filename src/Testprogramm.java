import java.io.IOException;

/**
 * Created by bjarne on 09.05.16.
 */
public class Testprogramm {

    public static void main(String[] args) {
        FishCalculator calculator = new FishCalculator();

        if (args.length != 1) {
            System.out.println("Fehler:\nVerwende: java Testprogramm PATH\nPATH: Der Pfad zur Textdatei, die die Fische enthaelt.");
            System.exit(1);
        }

        try {
            Fish[] pop = Parser.readFishFromFile(args[0]);
            Parser.printFishList(pop);
            calculator.setPopulation(pop);
            calculator.calculate(170);
        } catch (IOException e) {
           System.out.print("Fish.txt Datei wurde nicht gefunden.");
            System.exit(1);
        }
    }
}
