import java.util.Scanner;

/*
Écrivez une fonction qui détermine si un nombre entier est négatif.
*/

public class Main {

    public static boolean estNegatif(int val) {
        return val < 0;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Entrez votre valeur : ");
        int val = scan.nextInt();
        if (estNegatif(val)) {
            System.out.println("Cette valeur est négative.");
        }
        else {
            System.out.println("Cette valeur est positive.");
        }
    }
}
