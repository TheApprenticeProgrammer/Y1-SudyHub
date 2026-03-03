/*
Ecrivez une fonction qui renvoie une copie renversée d’un string. Par exemple le string "hello"
donne "olleh".
*/

public class Main {

    public static String reverseString(String s) {
        String res = "";
        for (int i = s.length() - 1; i > -1; --i) {
            res += s.charAt(i);
        }
        return res;
    }

    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "Toji Zenin";
        System.out.println(s1);
        System.out.println(reverseString(s1));
        System.out.println(s2);
        System.out.println(reverseString(s2));
    }
}
