import java.util.Scanner;

/*
Écrivez une fonction qui calcule la puissance d’un entier quelconque par un entier positif (ou nul).
Pour rappel, ab = 1 * a * a * ... * a (avec b multiplications).
*/

public class Main {

    public static int puissance(int base, int exp) {
        int res = 1;
        if (exp > 0) {
            res = base;
            for (int i = 1; i < exp; ++i) {
                res *= base;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Entrez votre base : ");
        int base = scan.nextInt();
        System.out.println("Entrez votre exposant : ");
        int exp = scan.nextInt();
        System.out.println("La valeur de " + base + " exposant " + exp + " est : " + puissance(base, exp));
    }
}
