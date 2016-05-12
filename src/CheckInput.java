import java.util.Scanner;

/**
 * contains static Methods to check the validity of input
 */
public class CheckInput {
    /**
     * valid integer
     * @return
     */
    public static int cInt() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                return sc.nextInt();
            }
            catch (java.util.InputMismatchException e) {
                sc.nextLine();
            }
            System.out.println("Falsche Eingabe: ");
        }
    }

    /**
     * String
     * @return
     */
    public static String cString() {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        return a;
    }
}