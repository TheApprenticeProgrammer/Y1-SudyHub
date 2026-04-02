/*
Soient a un entier strictement positif, écrivez une fonction récursive qui calcule a exposant n pour n positif
ou nul. Pour rappel : a exposant 0 vaut 1. Combien de multiplication doit effectuer votre algorithme pour
calculer 2 exposant 24 ?

Cas de base n == 0 => return 1;

Pour 2 exposant 4 :
    return 2 * exp(2, 4 - 1)
                        2 * exp(2, 3 - 1)
                                    2 * exp(2, 2 - 1)
                                                2 * exp(2, 1 - 1)
                                                        2 * exp(0) ==> Cas de base return 1;
*/

public class Main {

    public static int exp(int a, int n) {
        if (n == 0) {
            return 1;
        }
        return a * exp(a, n - 1);
    }

    public static void main(String[] args) {
        System.out.println(exp(2, 0));
        System.out.println(exp(2, 1));
        System.out.println(exp(2, 2));
        System.out.println(exp(2, 3));
        System.out.println(exp(2, 4));
        System.out.println(exp(2, 5));
        System.out.println(exp(2, 6));
        System.out.println(exp(2, 7));
        System.out.println(exp(2, 8));
    }
}
