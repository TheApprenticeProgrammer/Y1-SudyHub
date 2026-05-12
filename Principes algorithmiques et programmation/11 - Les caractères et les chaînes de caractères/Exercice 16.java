import eu.epfc.prm.Array;
import java.util.Scanner;

/*
Écrivez un programme qui affiche les fréquences d’apparitions des caractères alphabétiques d’un
texte entré par l’utilisateur. Les autres caractères sont ignorés. Majuscules et minuscules sont
comptabilisées conjointement. Par exemple, le texte « La vie est belle » donnera l’affichage :
A: 1, B: 1, E: 4, I: 1, L: 3, S: 1, T: 1, V: 1. Pour permettre à l’utilisateur
d’entrer une phrase entière, utilisez un Scanner avec la méthode nextLine(). Utilisez un tableau
(Array) pour mémoriser les nombres d’apparitions des différents caractères.
*/

public class Main {

    public static boolean estLettre(char c) {
        return c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z';
    }

    public static boolean estMin(char c) {
        return c >= 'a' && c <= 'z';
    }

    public static char toMaj(char c) {
        if (estMin(c)) {
            c = (char) (c - ('a' - 'A'));
        }
        return c;
    }

    public static Array<Integer> nbApparition(String s) {
        Array<Integer> tab = new Array<>(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (estLettre(c)) {
                c = toMaj(c);
                tab.set((int)c - 'A', tab.get((int)c - 'A') + 1);
            }
        }
        return tab;
    }

    public static void affiche(String s) {
        Array<Integer> tab = nbApparition(s);
        for (int i = 0; i < tab.size(); ++i) {
            if (tab.get(i) != 0) {
                char lettre = (char) ((int)'A' + i);
                System.out.print(lettre + ": " + tab.get(i) + ", ");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        System.out.println(s);
        affiche(s);
    }
}
