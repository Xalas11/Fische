/**
 * Created by bjarne on 09.05.16.
 */
public class Testprogramm {
    FishCalculator calculator = new FishCalculator();

    String[] grueneMigraeneDoesNotLike = {"Breitmaulmolch", "Grottensprotte"};
    Fish grueneMigraene = new Fish("Gruene Migraene", 70, grueneMigraeneDoesNotLike);

    String[] korallenqualleDoesNotLike = {};
    Fish korallenqualle = new Fish("Korallenqualle", 50, korallenqualleDoesNotLike);

    String[] schuppenschatulleDoesNotLike = {"Breitmaulmolch", "Prachtpiranha"};
    Fish schuppenschatulle = new Fish("Schuppenschatulle", 30, schuppenschatulleDoesNotLike);

    String[] breitmaulmolchDoesNotLike = {"Gruene Migraene", "Schuppenschatulle"};
    Fish breitmaulmolch = new Fish("Breitmaulmolch", 40, breitmaulmolchDoesNotLike);

    String[] prachtpiranhaDoesNotLike = {"Grottensprotte", "Schuppenschatulle"};
    Fish prachtpiranha = new Fish("Prachtpiranha", 40, prachtpiranhaDoesNotLike);

    String[] zitterlingDoesNotLike = {"Grottensprotte"};
    Fish zitterling = new Fish("Zitterling", 30, zitterlingDoesNotLike);

    String[] grottensprotteDoesNotLike = {"Gruene Migraene", "Zitterling", "Prachtpiranha"};
    Fish grottensprotte = new Fish("Grottensprotte", 40, grottensprotteDoesNotLike);


    Fish[] pop = {grueneMigraene, korallenqualle, schuppenschatulle, breitmaulmolch, prachtpiranha, zitterling, grottensprotte};


}
