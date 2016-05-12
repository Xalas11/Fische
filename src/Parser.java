import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * handles input of fishes, from document and from files, can print Fish lists
 */
public class Parser {


    /**
     * array of Fish
     * @return
     */
    public static Fish[] readFish() {

        LinkedList<Fish> fishes = new LinkedList();

        while (true) {
            String stringFish;
            // name of the fish
            System.out.println("Wenn sie keinen weiteren Fisch mehr eingeben moechten 'end' Eingeben ");
            System.out.print("\nBitte gebe den Name des Fisches ein: ");
            stringFish = CheckInput.cString();

            if (stringFish.equals("end")) break; // no more fish

            stringFish += "$";
            // price of the fish
            System.out.println("Geben sie bitte den Preis des Fisches ein");
            stringFish += Integer.toString(CheckInput.cInt());
            // incompabilitys of the fish
            while (true) {
                System.out.println("Fuer Fertig 'end' eingeben geben sie Bitte einen unvertraeglichen Fisch ein: ");
                stringFish += "$";
                String temp = CheckInput.cString();
                if (temp.equals("end")) break;
                stringFish += temp;
            }
            fishes.add(createFish(stringFish));
        }
        return arrayCreate(fishes);
    }

    /**
     * array of Fish
     * @param path
     * @return
     * @throws IOException
     */
    public static Fish[] readFishFromFile(String path) throws IOException {

        FileReader getText = new FileReader(path);
        BufferedReader bufferText = new BufferedReader(getText);
        LinkedList<Fish> fishes = new LinkedList();


        String line = bufferText.readLine();
        if (!line.isEmpty()) {
            do {
                fishes.add(createFish(line));
                line = bufferText.readLine();
            } while (line != null);
        }
        return arrayCreate(fishes);
    }

    /**
     * array of Fish
     * @param fishes
     * @return
     */
    public static Fish[] arrayCreate(LinkedList<Fish> fishes) {
        Fish[] fishList = new Fish[fishes.size()];
        int i = 0;
        while (!fishes.isEmpty()) {
            fishList[i] = fishes.getFirst();
            i++;
            fishes.removeFirst();
        }
        return fishList;
    }

    /**
     * Fish
     * @param stringFish
     * @return
     */
    public static Fish createFish(String stringFish) {
        LinkedList<String> inCompaSize = new LinkedList<>();
        String name;
        int price;

        int nextWordIndex;
        int prevWordIndex = 0;

        nextWordIndex = stringFish.indexOf('$', prevWordIndex);
        name = stringFish.substring(prevWordIndex, nextWordIndex);
        prevWordIndex = nextWordIndex + 1;

        nextWordIndex = stringFish.indexOf('$', prevWordIndex);
        price = Integer.parseInt(stringFish.substring(prevWordIndex, nextWordIndex));
        prevWordIndex = nextWordIndex + 1;

        while (prevWordIndex<stringFish.length()) {
            nextWordIndex = stringFish.indexOf('$', prevWordIndex);
            inCompaSize.add(stringFish.substring(prevWordIndex, nextWordIndex));
            prevWordIndex = nextWordIndex + 1;
        }
        HashSet<String> incompa = new HashSet<String>();
        while (!inCompaSize.isEmpty()) {
            incompa.add(inCompaSize.getFirst());
            inCompaSize.removeFirst();
        }

        Fish fish = new Fish(name, price, incompa);
        return fish;
    }

    /**
     * array of Fish
     * @param fishlist
     */
    public static void printFishList(Fish[] fishlist) {

        for (Fish n: fishlist) {
            String tempFish ="";

            for (String fish : n.getIncompa()) {
                tempFish += fish + ", ";
            }
            if (n.getIncompa().size() == 0) {
                tempFish += "-";
            }
            System.out.print(n.getName()+" ("+n.getPrice()+" Euro)\n   Incompa: "+ tempFish +" \n");
        }
    }

    /**
     * hashset of Fish
     * @param fishlist
     */
    public static void printFishList(HashSet<Fish> fishlist) {
        int price = 0;
        for (Fish n: fishlist) {
            price += n.getPrice();
            String tempFish ="";

            for (String fish : n.getIncompa()) {
                tempFish += fish + ", ";
            }
            if (n.getIncompa().size() == 0) {
                tempFish += "-";
            }
          // System.out.print(n.getName()+"\n  Preis: "+n.getPrice()+" Euro \n  Incompatibel: "+ tempFish +" \n");
            System.out.print(n.getName() + " (" + n.getPrice() + " Euro)\n  Incompatibel: "+ tempFish +" \n");
        }
        System.out.println("--------------");
        System.out.println("SUMME "+ price + " Euro");
    }



}