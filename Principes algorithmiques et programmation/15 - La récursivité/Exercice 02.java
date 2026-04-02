/*
Écrivez une fonction récursive qui renvoie la factorielle d'un nombre entier positif.

Formule générale : n! = n * (n - 1) * ((n - 1) - 1) ... * 1
Pour 5! = 5 * 4 * 3 * 2 * 1

Cas de base => n == 0 => return 1

return 5 * f(5 - 1)     <== 5 * 4 * 3 * 2 * 1
                => 4 * f(4 - 1)     <== 4 * 3 * 2 * 1 * 1
                            => 3 * f(3 - 1)     <== 3 * 2 * 1 * 1
                                        => 2 * f(2 - 1)     <== 2 * 1 * 1
                                                    => 1 * f(1 - 1)     <== 1 * 1
                                                            => 0 => Cas de base return 1;
*/

public class Main {

    public static int factorielle(int n) {
        if (n < 0) {
            throw new RuntimeException("Impossible => wrong number !");
        }
        if (n == 0) {
            return 1;
        }
        else {
            return n * factorielle(n - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println("120 = " + factorielle(5));
        System.out.println(factorielle(-1));
    }
}
