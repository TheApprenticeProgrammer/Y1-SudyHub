/*
Ecrivez une fonction qui calcule la somme des chiffres d’un nombre entier positif ou nul.

Cas de base : if (nb == 0) return 0;

return (nb % 10) + sommeNb(nb / 10)

return (2745 % 10) + sommeNb(2745 / 10) <= 5 + 4 + 7 + 2 + 0
    => return (274 % 10) + sommeNb(274 / 10) <= 4 + 7 + 2 + 0
        => return (27 % 10) + sommeNb(27 / 10) <= 7 + 2 + 0
            => return (2 % 10) + sommeNb(2 / 10) <= 2 + 0
                => if (nb == 0) return 0; <= cas de base
*/

public class Main {

    public static int sommeNb(int nb) {
        if (nb == 0) {
            return 0;
        }
        return (nb % 10) + sommeNb(nb / 10);
    }

    public static void main() {
        System.out.println("0 = " + sommeNb(0));
        System.out.println("6 = " + sommeNb(123));
        System.out.println("18 = " + sommeNb(2745));
    }
}
