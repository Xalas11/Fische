import java.util.HashSet;
import java.util.Arrays;

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
            Parser.printFishList(pop);
            calculator.setPopulation(pop);
        } catch (NumberFormatException e) {
            System.out.println("Fehler:\nVerwende: java FishCalculator BUDGET\nBUDGET: Die zur Verfuegung stehende Summe als natuerliche Zahl.");
            System.out.print("Eine natuerliche Zahl ist eine Zahl ohne Komma, die groesser ist als 0");
            System.exit(1);
        }
    }

    public void calculate() {
        System.out.println("Budget: " + maxPreis);
    }
    
    public HashSet<Fish> findCompaFishes(Fish fish) {
        HashSet<Fish> compaFishSet = new HashSet<Fish>();
        for (int i = 0; i < population.length; i++) {
            if (population[i].incompa.contains(fish.getName()) == false ) {
                compaFishSet.add(population[i]);
            }
        }
        return compaFishSet;
    }
    
    public HashSet<Fish> findCompaFishes(HashSet<Fish> fishes) {
        HashSet<Fish> compaFishSet = new HashSet<>(Arrays.asList(population));
        for (Fish fish : fishes) {
            compaFishSet.removeAll(fish.getIncompa());
        }
        return  fishes;
    }

    public Fish[] rekursion(Fish[] fishes) {
        return fishes;
    }

    public void setPopulation(Fish[] population) {
        this.population = population;
    }

    public void setMaxPreis(int maxPreis) {
        this.maxPreis = maxPreis;
    }
}
