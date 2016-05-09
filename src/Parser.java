/**
 * Created by bjarne on 09.05.16.
 */

import java.util.LinkedList;

public class Parser {

    public static Fish[] readFish() {
        LinkedList<Fish> fishes = new LinkedList();
        while (true) {
            String stringFish = "";
            int price;
            System.out.println("Wenn sie keinen Weiteren Fisch mehr eingeben möchten 'end' Eingeben \nBitte gebe den Name des Fisches ein: ");
            String temp = CheckInput.cString();
            if (temp.equals("end")) break;
            stringFish = temp;
            stringFish += "$";
            System.out.println("Geben sie bitte den Preis des Fisches ein");
            price = CheckInput.cInt();
            int inCompaSize = 0;
            while (true) {
                System.out.println("Fuer Fertig 'end' eingeben geben sie Bitte einen unvertraeglichen Fisch ein: ");
                String temp1 =CheckInput.cString();
                if (temp1.equals("end")) break;
                stringFish += temp1;
                stringFish += "$";
                inCompaSize++;
            }
            fishes.add(createFish(stringFish,price, inCompaSize));
        }

        Fish[] fishList = new Fish[fishes.size()];
        for(int i=0; i<fishes.size(); i++) {
            fishList[i] = fishes.getFirst();
            fishes.removeFirst();
        }
        return fishList;
    }
    public static Fish createFish(String stringFish, int price, int inCompaSize) {
        String incompa[] = new String[inCompaSize];
        String name="";
        int nextWordIndex;
        int prevWordIndex=0;
        for(int i=0; i<inCompaSize; i++) {
            nextWordIndex = stringFish.indexOf('$', prevWordIndex);
            incompa[i] = stringFish.substring(prevWordIndex, nextWordIndex);
            prevWordIndex = nextWordIndex;
        }
        Fish fish = new Fish(name, price, incompa);
        return fish;
    }


}
