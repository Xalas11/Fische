import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * Created by bjarne on 09.05.16.
 */
public class Parser {
    public static void main(String[] args) {
        printFishList(readFish());
    }

    public static Fish[] readFish() {

        LinkedList<Fish> fishes = new LinkedList();

        while (true) {
            String stringFish = "";
            System.out.println("Wenn sie keinen Weiteren Fisch mehr eingeben moechten 'end' Eingeben \nBitte gebe den Name des Fisches ein: ");
            String temp = CheckInput.cString();
            if (temp.equals("end")) break;
            stringFish = temp + "$";
            System.out.println("Geben sie bitte den Preis des Fisches ein");
            stringFish += Integer.toString(CheckInput.cInt());
            while (true) {
                System.out.println("Fuer Fertig 'end' eingeben geben sie Bitte einen unvertraeglichen Fisch ein: ");
                stringFish += "$";
                String temp1 = CheckInput.cString();
                if (temp1.equals("end")) break;
                stringFish += temp1;
            }
            fishes.add(createFish(stringFish));
        }


        return arrayCreate(fishes);
    }

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


    public static void printFishList(Fish[] fishlist) {

        for (Fish n: fishlist) {
            String tempFish ="";

            for (String fish : n.getIncompa()) {
                tempFish += fish + " ";
            }
            System.out.print(n.getName()+" Price: "+n.getPrice()+" Incompa: "+ tempFish +" \n");
        }
    }
}