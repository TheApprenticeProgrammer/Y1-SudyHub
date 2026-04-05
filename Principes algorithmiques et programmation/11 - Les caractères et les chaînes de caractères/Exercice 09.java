/*
Écrivez une fonction qui renvoie l’indice de la première apparition d’un caractère dans un
string. Que renvoyez-vous si le caractère n’apparaît pas dans le string ?

Version du corrigé :
    public static int pos(char c, String s) {
        int k = 0;
        while (k < s.length() && s.charAt(k) != c) {
            ++k;
        }
        return k;
    }
*/

public class Main {

    public static int indicePremApp(String s, char c) {
        int res = - 1;
        boolean find = false;
        for (int i = 0; i < s.length() && !find; ++i) {
            if ((int) s.charAt(i) == (int) c) {
                res = i;
                find = true;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s1 = "Hello World !";
        System.out.println("2 = " + indicePremApp(s1, 'l'));
        System.out.println("6 = " + indicePremApp(s1, 'W'));
        System.out.println("5 = " + indicePremApp(s1, ' '));
        System.out.println("12 = " + indicePremApp(s1, '!'));
        System.out.println("-1 = " + indicePremApp(s1, 'y'));
    }
}
