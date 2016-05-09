/**
 * Created by bjarne on 09.05.16.
 */
public class FishCalculator {

    int maxPreis;
    Fish[] population;

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Fehler:\nVerwende: java FishCalculator BUDGET\nBUDGET: Die zur Verfuegung stehende Summe als natuerliche Zahl.");
            System.exit(1);
        }
        try {
            int maxPreisInt = Integer.parseInt(args[0]);
            FishCalculator calculator = new FishCalculator();
            Fish[] pop = Parser.readFish();
            calculator.setPopulation(pop);
            calculator.calculate(maxPreisInt);
        } catch (NumberFormatException e) {
            System.out.println("Fehler:\nVerwende: java FishCalculator BUDGET\nBUDGET: Die zur Verfuegung stehende Summe als natuerliche Zahl.");
            System.out.print("Eine natuerliche Zahl ist eine Zahl ohne Komma, die groesser ist als 0");
            System.exit(1);
        }
    }

    public void calculate(int maxPreis) {
        this.maxPreis = maxPreis;
        System.out.println("Budget: " + maxPreis);
    }

    public Fish[] rekursion(Fish[] remainingFish) {
        Fish[] remaining = remainingFish;
        // REKURSION
        return remaining;
    }

    public void setPopulation(Fish[] population) {
        this.population = population;
    }
}
