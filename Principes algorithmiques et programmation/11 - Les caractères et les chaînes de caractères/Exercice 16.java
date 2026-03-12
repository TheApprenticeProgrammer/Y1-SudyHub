import java.util.Scanner;

/*
Ecrivez un programme qui affiche les fréquences d’apparitions des caractères alphabétiques d’un
texte entré par l’utilisateur. Les autres caractères sont ignorés. Majuscules et minuscules sont
comptabilisées conjointement. Par exemple, le texte « La vie est belle » donnera l’affichage :
A: 1, B: 1, E: 4, I: 1, L: 3, S: 1, T: 1, V: 1. Pour permettre à l’utilisateur
d’entrer une phrase entière, utilisez un Scanner avec la méthode nextLine(). Utilisez un tableau
(Array) pour mémoriser les nombres d’apparitions des différents caractères.
*/
public class Main {

    public static int nbAppChar(String s, int val) {
        int cpt = 0;
        for (int i = 0; i < s.length(); ++i) {
            if ((int) s.charAt(i) == val || (val + ((int) 'a' - (int) 'A')) == (int) s.charAt(i)) {
                ++cpt;
            }
        }
        return cpt;
    }

    public static void sout(String s) {
        int val = (int) 'A';
        for (int i = 0; i <= 26; ++i) {
            if (nbAppChar(s, val) != 0) {
                System.out.print((char) val + " : " + nbAppChar(s, val));
                System.out.print(", ");
            }
            ++val;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s1 = new String("La vie est belle");
        sout(s1);
        System.out.println();
        System.out.println("À vous :");
        String phrase = scan.nextLine();
        sout(phrase);
    }
}
