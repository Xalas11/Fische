import java.util.HashSet;
import java.util.Arrays;

/**
 *
 */
public class FishCalculator {

    int maxPreis;
    Fish[] population;
    HashSet<HashSet<Fish>> setSet = new HashSet<HashSet<Fish>>();

    /**
     * array of Fish
     * @param population
     */
    public void setPopulation(Fish[] population) {
        this.population = population;
    }

    /**
     * int price
     * @param maxPreis
     */
    public void setMaxPreis(int maxPreis) {
        this.maxPreis = maxPreis;
    }

    /**
     * int price
     * @param args
     */
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Fehler:\nVerwende: java FishCalculator BUDGET\nBUDGET: Die zur Verfuegung stehende Summe als natuerliche Zahl.");
            System.exit(1);
        }
        try {
            int maxPreisInt = Integer.parseInt(args[0]);
            Fish[] pop = Parser.readFish();
            Parser.printFishList(pop);
            FishCalculator calculator = new FishCalculator();
            calculator.setMaxPreis(maxPreisInt);
            calculator.setPopulation(pop);
            calculator.calculate();
        } catch (NumberFormatException e) {
            System.out.println("Fehler:\nVerwende: java FishCalculator BUDGET\nBUDGET: Die zur Verfuegung stehende Summe als natuerliche Zahl.");
            System.out.print("Eine natuerliche Zahl ist eine Zahl ohne Komma, die groesser ist als 0");
            System.exit(1);
        }
    }

    /**
     *
     */
    public void calculate() {
        System.out.println("Budget: " + maxPreis);

        // finds incompatible Fishobjekts for every fish
        for(int i = 0; i < population.length; i++) {
            HashSet<Fish> incompFishSet = new HashSet<Fish>();
            for (String incompaName: population[i].getIncompa()) {
                for (int j = 0; j < population.length; j++) {
                    if(incompaName.equals(population[j].getName())) {
                        incompFishSet.add(population[j]);
                    }
                }
            }
            population[i].setIncompaFish(incompFishSet);
        }

        //BJARNE FRAGEN OB WIRKLICH NUR VON STRING ZU HASHSET

        // starts the recursion
        HashSet<Fish> liste = new HashSet<Fish>();
        rekursion(liste);

        // finds the best option out of the combinations
        int best = 0;
        HashSet<Fish> bestSet = new HashSet<Fish>();
        for (HashSet<Fish> set: setSet) {
            if (set.size() > best) {
                best = set.size();
            }
        }

        // prints the best option
        for (HashSet<Fish> set: setSet) {
            if (set.size() == best) {
                System.out.print("\n\nKAUFOPTION:\n");
                Parser.printFishList(set);
            }
        }
    }

    /**
     * finds fishes, which are compatible with a given Fish set
     * @param fishes
     * @return
     */
    public HashSet<Fish> findCompaFishes(HashSet<Fish> fishes) {
        HashSet<Fish> compaFishSet = new HashSet<>(Arrays.asList(population));
        for (Fish fish : fishes) {
            compaFishSet.removeAll(fish.getIncompaFish());
        }
        return  compaFishSet;
    }

    // Findet Fischkombinationen, die zusammen Leben koennen (und zwar rekursiv)

    /**
     * finds all possible Fish combinations in terms of diversity
     * @param fishes
     * @return
     */
    public HashSet<Fish> rekursion(HashSet<Fish> fishes) {
        HashSet<Fish> passendeFishe = findCompaFishes(fishes);
        for (Fish passenderFish: passendeFishe) {
            HashSet<Fish> deepCopy = new HashSet<Fish>();
            int currentPrice = passenderFish.getPrice();
            deepCopy.add(passenderFish);
            for (Fish fish : fishes) {
                deepCopy.add(fish);
                currentPrice += fish.getPrice();
            }
            if (currentPrice <= maxPreis && !setSet.contains(deepCopy)) {
                System.out.println("==================");
                for (Fish fi: deepCopy) {
                    System.out.println(fi.getName());
                }
                System.out.println("==================");
                setSet.add(deepCopy);
                rekursion(deepCopy);
            }
        } return  null;
    }
}
