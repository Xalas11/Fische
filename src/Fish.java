/**
 * Created by bjarne on 09.05.16.
 */
public class Fish {
    String name;
    int price;
    String[] incompa;
    String[] compa;

    public Fish(String name, int price, String[] incompa) {
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

    public String[] getIncompa() {
        return incompa;
    }

    public String[] getCompa() {
        return compa;
    }

    public void setCompa(String[] compa) {
        this.compa = compa;
    }
}
