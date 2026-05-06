import java.util.Scanner;

/*
Écrivez une fonction qui détermine si un nombre entier positif est pair ou non.
*/

public class Main {

    public static boolean estPair(int val) {
        return val % 2 == 0;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Entrez votre valeur : ");
        int val = scan.nextInt();
        if (estPair(val)) {
            System.out.println("Ce nombre est pair.");
        }
        else {
            System.out.println("Ce nombre est impair.");
        }
    }
}
