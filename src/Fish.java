/**
 * Created by bjarne on 09.05.16.
 */

import java.util.HashSet;


public class Fish {
    String name;
    int price;
    HashSet<String> incompa;
    HashSet<Fish> incompaFish;

    public Fish(String name, int price, HashSet<String> incompa) {
        this.name = name;
        this. price = price;
        this.incompa = incompa;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public void setIncompaFish(HashSet<Fish> incompaFish) {
        this.incompaFish = incompaFish;
    }

    public HashSet<Fish> getIncompaFish() {
        return incompaFish;
    }

    public HashSet<String> getIncompa() {
        return incompa;
    }

}
