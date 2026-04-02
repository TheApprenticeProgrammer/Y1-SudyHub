/*
Écrivez une fonction qui renvoie une copie renversée d’un string. Par exemple le string "hello"
donne "olleh".
*/

public class Main {

    public static String reverse(String s) {
        String res = "";
        for (int i = s.length() - 1; i >= 0; --i) {
            res += s.charAt(i);
        }
        return res;
    }

    public static void main(String[] args) {
        String s1 = "Hello";
        System.out.println(reverse(s1));
        String s2 = "Hello World !";
        System.out.println(reverse(s2));
    }
}
