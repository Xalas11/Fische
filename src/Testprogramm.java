import java.io.IOException;

/**
 * Created by bjarne on 09.05.16.
 */
public class Testprogramm {

    public static void main(String[] args) {
        FishCalculator calculator = new FishCalculator();

        if (args.length != 2) {
            System.out.println("Fehler:\nVerwende: java Testprogramm BUDGET PATH\nBUDGET: Die zur Verfuegung stehende Summe als natuerliche Zahl.\nPATH: Der Pfad zur Textdatei, die die Fische enthaelt.");
            System.exit(1);
        }

        try {
            int maxPreisInt = Integer.parseInt(args[0]);
            Fish[] pop = Parser.readFishFromFile(args[1]);
            Parser.printFishList(pop);
            calculator.setPopulation(pop);
            calculator.setMaxPreis(maxPreisInt);
            calculator.calculate();
        } catch (IOException e) {
           System.out.print("Fish.txt Datei wurde nicht gefunden.");
            System.exit(1);
        }
    }
}
