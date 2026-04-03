/*
Écrivez une fonction (récursive, bien sûr) qui calcule le nombre de chiffres nécessaires pour écrire
un nombre entier positif ou nul. Par exemple, le nombre deux mille sept cent vingt-trois s’écrit à
l’aide de 4 chiffres.

Cas de base : if (nb == 0) return 0;

if (nb != 0) ++res;
return res += nbChiffres(nb / 10)

if (nb != 0) ++res; => res = 4
return res += nbChiffres(2745 / 10)

        => if (274 != 0) ++res; => res = 3
        => return res += nbChiffres(274 / 10)

                => if (27 != 0) ++res; => res = 2
                => return res += nbChiffres(27 / 10)

                        => if (2 != 0) ++res; => res = 1
                        => return res += nbChiffres(2 / 10)

                                => if (0 == 0) return 0; <= Cas de base
*/

public class Main {

    public static int nbChiffres(int nb) {
        int res = 0;
        if (nb == 0) {
            return 0;
        }
        if (nb != 0) {
            ++res;
        }
        return res += nbChiffres(nb / 10);
    }

    public static void main(String[] args) {
        System.out.println("0 = " + nbChiffres(0));
        System.out.println("1 = " + nbChiffres(1));
        System.out.println("4 = " + nbChiffres(2745));
    }
}
