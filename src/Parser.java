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
            int price;
            System.out.println("Wenn sie keinen Weiteren Fisch mehr eingeben moechten 'end' Eingeben \nBitte gebe den Name des Fisches ein: ");
            String temp = CheckInput.cString();
            if (temp.equals("end")) break;
            stringFish = temp;
            System.out.println("Geben sie bitte den Preis des Fisches ein");
            price = CheckInput.cInt();
            int inCompaSize = 0;
            while (true) {
                System.out.println("Fuer Fertig 'end' eingeben geben sie Bitte einen unvertraeglichen Fisch ein: ");
                stringFish += "$";
                String temp1 =CheckInput.cString();
                if (temp1.equals("end")) break;
                stringFish += temp1;
                inCompaSize++;
            }
            fishes.add(createFish(stringFish,price, inCompaSize));
        }

        Fish[] fishList = new Fish[fishes.size()];
        int i=0;
        while (!fishes.isEmpty()){
            fishList[i] = fishes.getFirst();
            i++;
            fishes.removeFirst();
        }
        return fishList;
    }
    public static Fish createFish(String stringFish, int price, int inCompaSize) {
        HashSet<String> incompa = new HashSet<String>();
        String name;

        int nextWordIndex;
        int prevWordIndex=0;

        nextWordIndex = stringFish.indexOf('$', prevWordIndex);
        name = stringFish.substring(prevWordIndex, nextWordIndex);
        prevWordIndex = nextWordIndex+1;

        for(int i=0; i<inCompaSize; i++) {
            nextWordIndex = stringFish.indexOf('$', prevWordIndex);
            incompa.add(stringFish.substring(prevWordIndex, nextWordIndex));
            prevWordIndex = nextWordIndex+1;
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