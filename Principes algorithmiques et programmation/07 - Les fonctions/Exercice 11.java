import java.util.Scanner;

/*
Écrivez une fonction qui détermine si un entier plus grand que 1 est premier. Pour rappel un entier
est premier s’il n’est (exactement) divisible que par lui-même et par 1.
*/

public class Main {

    public static boolean estDivisiblePar(int val, int diviseur) {
        return val % diviseur == 0;
    }

    public static boolean estPremier(int val) {
        int res = 0;
        for (int i = 1; i <= val / 2 && res < 3; ++i) {
            if (estDivisiblePar(val, i)) {
                ++res;
            }
        }
        return res + 1 == 2;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Entrez votre nombre : ");
        int val = scan.nextInt();
        if (estPremier(val)) {
            System.out.println("Ce nombre est un nombre premier.");
        }
        else {
            System.out.println("Ce nombre n'est pas un nombre premier.");
        }
    }
}
