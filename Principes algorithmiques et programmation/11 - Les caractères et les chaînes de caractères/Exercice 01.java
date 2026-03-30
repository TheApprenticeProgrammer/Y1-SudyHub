/*
Écrivez une fonction qui détermine si un caractère est alphabétique minuscule. Ne vous occupez
pas des diacritiques (accents).

Autre version :
    public static boolean estMin(char c) {
        return c >= 'a' && c <= 'z';
    }
*/

public class Main {

    public static boolean estMin(char c) {
        return (int) c >= (int) 'a' && (int) c <= (int) 'z';
    }

    public static void main(String[] args) {
        char c = 'b';
        if (estMin(c)) {
            System.out.println("Le caractère '" + c + "' est une minuscule");
        } else {
            System.out.println("Le caractère '" + c + "' n'est pas une minuscule");
        }

        c = 'Z';
        if (estMin(c)) {
            System.out.println("Le caractère '" + c + "' est une minuscule");
        } else {
            System.out.println("Le caractère '" + c + "' n'est pas une minuscule");
        }
    }
}
