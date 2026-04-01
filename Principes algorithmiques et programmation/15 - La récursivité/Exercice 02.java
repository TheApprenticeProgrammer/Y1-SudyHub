import java.util.Scanner;
/*
Ecrivez une fonction récursive qui renvoie la factorielle d'un nombre entier positif.

if (5 > 1) => 5 * fact(4)
                    => if (4 > 1) => 4 * fact(3)
                                            => if (3 > 1) => 3 * fact(2)
                                                                    => if (2 > 1) => 2 * fact(1)
                                                                                            => if (1 > 1) => STOP => else => return 1
Ce qui donne :
    2 * 1 = 2
    3 * 2 = 6
    4 * 6 = 24
    5 * 24 = 120
*/

public class Main {
    public static int fact(int val) {
        if (val < 0) {
            throw new RuntimeException("Nombre négatif !");
        }
        if (val > 1) {
            return val * fact(val - 1);
        }
        else {
            return 1;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Entrez un nombre : ");
        int val = scan.nextInt();
        System.out.println("La factorielle de " + val + " est : " + fact(val));
    }
}
