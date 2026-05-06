import java.util.Scanner;

/*
Écrivez une fonction qui renvoie le maximum de deux nombres.
*/

public class Main {

    public static int estMax(int val1, int val2) {
        if (val1 > val2) {
            return val1;
        }
        else {
            return val2;
        }
    }

    public static int estMaxV2(int val1, int val2) {
        int max = val1;
        if (max < val2) {
            max = val2;
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Entrez la première valeur : ");
        int val1 = scan.nextInt();
        System.out.println("Entrez la seconde valeur : ");
        int val2 = scan.nextInt();
        System.out.println("La plus grande des 2 valeurs est : " + estMaxV2(val1, val2));
    }
}
