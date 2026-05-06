import java.util.Scanner;

/*
Supposons que ni l’opération de multiplication des entiers ni la puissance ne soient (pré-) définies
en Java. Ecrivez une fonction qui réalise la puissance d’un entier quelconque par un entier positif
(ou nul).
*/

public class Main {

    public static int multiplication(int multiplicateur, int multiplicande) {
        int produit = 0;
        if (multiplicateur < 0) {
            multiplicateur = -multiplicateur;
            multiplicande = -multiplicande;
        }
        for (int i = 0; i < multiplicateur; ++i) {
            produit += multiplicande;
        }
        return produit;
    }

    public static int puissance(int base, int exp) {
        int res = 1;
        for (int i = 0; i < exp; ++i) {
            res = multiplication(res, base);
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Entrez votre base : ");
        int base = scan.nextInt();
        System.out.println("Entrez votre exposant (il ne peut pas être négatif) : ");
        int exp = scan.nextInt();
        while (exp < 0) {
            System.out.println("Nombre invalide, recommencez : ");
            exp = scan.nextInt();
        }
        System.out.println("La valeur de " + base + " exposant " + exp + " est : " + puissance(base, exp));
    }
}
