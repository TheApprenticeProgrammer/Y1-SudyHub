/*
Refaites l’exercice précédent pour un string pouvant être formé de plusieurs mots. Dans ce
cas, il convient d’ignorer les espaces et les différences entre minuscules et majuscules. Par
exemple : "Esope reste ici et se repose". Pour permettre à l’utilisateur d’entrer une phrase entière,
utilisez un Scanner avec la méthode nextLine().
*/

import java.util.Scanner;

public class Main {

    public static char toMin(char c) {
        return (char) ((int) c + ((int) 'a' - (int) 'A'));
    }

    public static boolean estMin(char c) {
        return (c >= 'a' && 'z' >= c);
    }

    public static boolean estLettre(char c) {
        return ((c >= 'a' && 'z' >= c) || (c >= 'A' && 'Z' >= c));
    }

    public static boolean estPalindrome(String s) {
        boolean palindrome = true;
        int g = 0, d = s.length() - 1;
        while (g < d && palindrome) {
            char lg = s.charAt(g);
            char ld = s.charAt(d);
            while (!estLettre(lg)) {
                ++g;
                lg = s.charAt(g);
            }
            while (!estLettre(ld)) {
                --d;
                ld = s.charAt(d);
            }
            if (!estMin(lg)) {
                lg = toMin(lg);
            }
            if (!estMin(ld)) {
                ld = toMin(ld);
            }
            if ((int) lg != (int) ld) {
                palindrome = false;
            }
            ++g;
            --d;
        }
        return palindrome;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String s1 = new String("Esope reste ici et se repose");
        System.out.println("true = " + estPalindrome(s1));

        String s2 = new String("Elu par cette crapule");
        System.out.println("true = " + estPalindrome(s2));

        String s3 = new String("A man a plan a canal Panama");
        System.out.println("true = " + estPalindrome(s3));

        String s4 = new String("Laval");
        System.out.println("true = " + estPalindrome(s4));

        String s5 = new String("A a");
        System.out.println("true = " + estPalindrome(s5));

        String s6 = new String("hello");
        System.out.println("false = " + estPalindrome(s6));

        String s7 = new String("Bonjour");
        System.out.println("false = " + estPalindrome(s7));

        String s8 = new String("Java est cool");
        System.out.println("false = " + estPalindrome(s8));

        System.out.print("Entrez une phrase : ");
        String s = scan.nextLine();
        System.out.println(estPalindrome(s));
    }
}
