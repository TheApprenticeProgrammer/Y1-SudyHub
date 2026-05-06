import java.util.Scanner;

/*
Écrire une fonction qui, pour un nombre n donné, affiche à l’écran un carré de n caractères X de
côté (voir exercice 1.a du récapitulatif sur les boucles)
*/

public class Main {

    public static void square(int val) {
        for (int largeur = 0; largeur < val; ++largeur) {
            for (int longueur = 0; longueur < val; ++longueur) {
                System.out.print("X");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Entrez votre longueur/largeur : ");
        int val = scan.nextInt();
        square(val);
    }
}
