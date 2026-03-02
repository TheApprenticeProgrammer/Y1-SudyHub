/*
Ecrivez une fonction qui détermine si un caractère est alphabétique minuscule. Ne vous occupez
pas des diacritiques (accents).
*/

public class Main {

    public static boolean estMin(char a) {
        return ((int) a >= (int) 'a' && (int) a <= (int) 'z');
    }

    public static void main(String[] args) {
        char c1 = 'a';
        char c2 = 'z';
        char c3 = '4';
        char c4 = 'M';
        System.out.println("true = " + estMin(c1));
        System.out.println("true = " + estMin(c2));
        System.out.println("false = " + estMin(c3));
        System.out.println("false = " + estMin(c4));
    }
}
