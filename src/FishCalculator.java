import sun.util.resources.cldr.zh.CalendarData_zh_Hans_HK;

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

    public void calculate() {
        System.out.println("Budget: " + maxPreis);
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

        HashSet<Fish> liste = new HashSet<Fish>();

        rekursion(liste);
        int best = 0;
        HashSet<Fish> bestSet = new HashSet<Fish>();

        for (HashSet<Fish> set: setSet) {
            if (set.size() > best) {
                best = set.size();
            }
        }

        for (HashSet<Fish> set: setSet) {
            if (set.size() == best) {
                System.out.print("\n\nKAUFOPTION:\n");
                Parser.printFishList(set);
            }
        }
    }

    public HashSet<Fish> findCompaFishes(HashSet<Fish> fishes) {
        HashSet<Fish> compaFishSet = new HashSet<>(Arrays.asList(population));
        for (Fish fish : fishes) {
            compaFishSet.removeAll(fish.getIncompaFish());
        }
        return  compaFishSet;
    }

    HashSet<HashSet<Fish>> setSet = new HashSet<HashSet<Fish>>();

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
              //  System.out.println("==================");
                for (Fish fi: deepCopy) {
             //       System.out.println(fi.getName());
                }
              //  System.out.println("==================");
                setSet.add(deepCopy);
                rekursion(deepCopy);
            }
        } return  null;
    }

    public void setPopulation(Fish[] population) {
        this.population = population;
    }

    public void setMaxPreis(int maxPreis) {
        this.maxPreis = maxPreis;
    }
}
