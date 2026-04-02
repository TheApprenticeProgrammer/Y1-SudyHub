/*
Écrivez une fonction qui renvoie une copie en majuscule d’un string donné.
*/

public class Main {

    public static boolean estMin(char c) {
        return c >= 'a' && c <= 'z';
    }

    public static char toMaj(char c) {
        if (estMin(c)) {
            return (char) ((int)c + ((int)'A' - (int)'a'));
        }
        return c;
    }

    public static String allMaj(String s) {
        String res = "";
        for (int i = 0; i < s.length(); ++i) {
            res += toMaj(s.charAt(i));
        }
        return res;
    }

    public static void main(String[] args) {
        String s1 = "Hello";
        System.out.println(allMaj(s1));
        String s2 = "Hello World !";
        System.out.println(allMaj(s2));
    }
}
