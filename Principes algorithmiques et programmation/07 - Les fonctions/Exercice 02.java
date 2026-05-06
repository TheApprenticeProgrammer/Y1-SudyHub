import java.util.Scanner;

/*
Écrivez une fonction qui renvoie la moyenne de deux nombres.
*/

public class Main {

    public static double moyenne(int val1, int val2) {
        return (double) (val1 + val2) / 2;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Entrez la première valeur : ");
        int val1 = scan.nextInt();
        System.out.println("Entrez la seconde valeur : ");
        int val2 = scan.nextInt();
        double reponse = moyenne(val1, val2);
        System.out.println("La moyenne des deux valeurs est : " + reponse);
    }
}
