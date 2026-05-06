import java.util.Scanner;

/*
Écrivez une fonction qui détermine le nombre de nombres premiers strictement inférieurs à une
valeur entière donnée (1 n’est pas considéré comme premier).
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

    public static int nombresPremiersAvantVal(int val) {
        int res = 0;
        for (int i = 1; i < val; ++i) {
            if (estPremier(i)) {
                ++res;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Entrez votre valeur : ");
        int val = scan.nextInt();
        System.out.println("Il y a " + nombresPremiersAvantVal(val) + " nombres premiers strictement inférieurs à " + val);
    }
}
