/**
 * Created by bjarne on 09.05.16.
 */
public class Testprogramm {

    static String[] grueneMigraeneDoesNotLike = {"Breitmaulmolch", "Grottensprotte"};
    static Fish grueneMigraene = new Fish("Gruene Migraene", 70, grueneMigraeneDoesNotLike);

    static String[] korallenqualleDoesNotLike = {};
    static Fish korallenqualle = new Fish("Korallenqualle", 50, korallenqualleDoesNotLike);

    static String[] schuppenschatulleDoesNotLike = {"Breitmaulmolch", "Prachtpiranha"};
    static Fish schuppenschatulle = new Fish("Schuppenschatulle", 30, schuppenschatulleDoesNotLike);

    static String[] breitmaulmolchDoesNotLike = {"Gruene Migraene", "Schuppenschatulle"};
    static Fish breitmaulmolch = new Fish("Breitmaulmolch", 40, breitmaulmolchDoesNotLike);

    static String[] prachtpiranhaDoesNotLike = {"Grottensprotte", "Schuppenschatulle"};
    static Fish prachtpiranha = new Fish("Prachtpiranha", 40, prachtpiranhaDoesNotLike);

    static String[] zitterlingDoesNotLike = {"Grottensprotte"};
    static Fish zitterling = new Fish("Zitterling", 30, zitterlingDoesNotLike);

    static String[] grottensprotteDoesNotLike = {"Gruene Migraene", "Zitterling", "Prachtpiranha"};
    static Fish grottensprotte = new Fish("Grottensprotte", 40, grottensprotteDoesNotLike);


    static Fish[] pop = {grueneMigraene, korallenqualle, schuppenschatulle, breitmaulmolch, prachtpiranha, zitterling, grottensprotte};

    public static void main(String[] args) {
        FishCalculator calculator = new FishCalculator();
        Parser.printFishList(pop);
        calculator.setPopulation(pop);
        calculator.calculate(170);
    }
}
