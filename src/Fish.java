/**
 *
 */

import java.util.HashSet;

/**
 *  Models a Fish name, price and compatibilitys
 */
public class Fish {

    String name;
    int price;
    HashSet<String> incompa;
    HashSet<Fish> incompaFish;

    /**
     *
     * @param name
     * @param price
     * @param incompa
     */
    public Fish(String name, int price, HashSet<String> incompa) {
        this.name = name;
        this. price = price;
        this.incompa = incompa;
    }

    /**
     * price
     * @return
     */
    public int getPrice() {
        return price;
    }

    /**
     * name
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * hashset<Fish>
     * @param incompaFish
     */
    public void setIncompaFish(HashSet<Fish> incompaFish) {
        this.incompaFish = incompaFish;
    }

    /**
     * hashset<Fish>
     * @return
     */
    public HashSet<Fish> getIncompaFish() {
        return incompaFish;
    }

    /**
     * String of Fishnames
     * @return
     */
    public HashSet<String> getIncompa() {
        return incompa;
    }

}
