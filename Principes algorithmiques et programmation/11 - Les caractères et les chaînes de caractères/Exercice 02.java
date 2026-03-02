/*
Ecrivez une fonction qui renvoie la majuscule d’un caractère donné. Que renvoyez-vous si le
caractère n’est pas une minuscule ?

Si minuscule    => if ((int) c >= (int) 'a' && (int) c <= (int) 'z')
Si majuscule    => rien ...
Si autre        => else if ((int) c < (int) 'A' || (int) c > (int) 'Z')
*/

public class Main {

    public static char toMaj(char c) {
        int nbToMaj = (int) 'a' - (int) 'A';
        if ((int) c >= (int) 'a' && (int) c <= (int) 'z') {
            c = (char) ((int) c - nbToMaj);
        }
        else if ((int) c < (int) 'A' || (int) c > (int) 'Z') {
            throw new RuntimeException("Wrong character !");
        }
        return c;
    }

    public static void main(String[] args) {
        char c1 = 'a';
        char c2 = 'Z';
        char c3 = '5';
        System.out.println("A = " + toMaj(c1));
        System.out.println("Z = " + toMaj(c2));
        System.out.println(toMaj(c3));
    }
}
