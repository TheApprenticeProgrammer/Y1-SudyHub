import java.util.Scanner;

/*
Écrivez une fonction qui détermine si un entier (positif) est multiple d’un autre. Un entier a est
multiple d’un entier b ssi a est divisible exactement par b.
*/

public class Main {

    public static boolean estMultipleDe(int multiple, int val) {
        return multiple % val == 0;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Entrez votre potentiel multiple : ");
        int multiple = scan.nextInt();
        System.out.println("Entre votre valeur : ");
        int val = scan.nextInt();
        if (estMultipleDe(multiple, val)) {
            System.out.println("La valeur " + multiple + " est bien un multiple de " + val);
        }
        else {
            System.out.println("La valeur " + multiple + " n'est pas un multiple de " + val);
        }
    }
}
