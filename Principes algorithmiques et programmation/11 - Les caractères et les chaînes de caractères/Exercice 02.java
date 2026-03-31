/*
Écrivez une fonction qui renvoie la majuscule d’un caractère donné. Que renvoyez-vous si le
caractère n’est pas une minuscule ?
*/

public class Main {

    public static char toMaj(char c) {
        if (c >= 'a' && c <= 'z') {
            c = (char) ((int) c - ((int) 'a' - (int) 'A'));
        }
        return c;
    }

    public static void main(String[] args) {
        char c = 'b';
        System.out.println("La majuscule (si c'est une minuscule) de " + c + " est " + toMaj(c));

        c = 'Z';
        System.out.println("La majuscule (si c'est une minuscule) de " + c + " est " + toMaj(c));
    }
}
