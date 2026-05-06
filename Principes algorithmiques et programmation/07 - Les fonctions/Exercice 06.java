import java.util.Scanner;

/*
Supposons que l’opération de multiplication de deux entiers ne soit pas (pré-) définie en Java,
(autrement dit, que l’opérateur * n’existe pas). Ecrivez une fonction qui réalise cette opération en
utilisant, entre autres, l’addition. Envisagez et spécifiez tous les cas particuliers.
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

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Entrez le multiplicateur : ");
        int multiplicateur = scan.nextInt();
        System.out.println("Entrez le multiplicande : ");
        int multiplicande = scan.nextInt();
        System.out.println("Le produit de cette multiplication est : " + multiplication(multiplicateur, multiplicande));
    }
}
