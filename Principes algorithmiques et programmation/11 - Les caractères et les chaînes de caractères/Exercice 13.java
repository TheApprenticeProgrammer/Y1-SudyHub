import java.util.Scanner;

/*
Ecrivez une fonction qui renvoie une copie d’un string donné en mettant en majuscule la
première lettre de chaque mot du string. On suppose (sans le vérifier) que le string est composé
uniquement de caractères alphabétiques et d'espaces, ces derniers séparant les mots. Il n’y a pas
de ponctuation, par exemple. Pour permettre à l’utilisateur d’entrer une phrase entière, utilisez un
Scanner avec la méthode nextLine().
*/

public class Main {

    public static boolean estMin(char c) {
        return c >= 'a' && c <= 'z';
    }
    public static char toMaj(char c) {
        return (char) (c + ('A' - 'a'));
    }
    public static String firstToMaj(String s) {
        String res = "";
        boolean nouveauMot = true;
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (nouveauMot) {
                if (estMin(s.charAt(i))) {
                    c = toMaj(c);
                    nouveauMot = false;
                }
            }
            if (s.charAt(i) == ' ') {
                nouveauMot = true;
            }
            res += c;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String s1 = "hello les amis";
        System.out.println(s1);
        System.out.println(firstToMaj(s1));

        String s2 = "a b c d e f";
        System.out.println(s2);
        System.out.println(firstToMaj(s2));

        System.out.println("Entrer une phrase : ");
        String s3 = scan.nextLine();
        System.out.println(firstToMaj(s3));
    }
}
