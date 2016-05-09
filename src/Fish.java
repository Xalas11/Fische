/**
 * Created by bjarne on 09.05.16.
 */

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;


public class Fish {
    String name;
    int price;
    HashSet<String> incompa;
   // HashSet<String> compa;

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

    public HashSet<String> getIncompa() {
        return incompa;
    }

   /* public HashSet<String> getCompa() {
        return compa;
    }

    public void setCompa(HashSet<String> compa) {
        this.compa = compa;
    }
    */
}
