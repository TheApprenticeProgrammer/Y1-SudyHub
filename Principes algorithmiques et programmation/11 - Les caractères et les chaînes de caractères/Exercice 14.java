/*
Ecrivez une fonction intPositifToString() qui reçoit un entier positif ou nul et renvoie un string
contenant la représentation décimale de cet entier. Par exemple l’entier 123 donne le String (texte)
"123". Votre fonction doit déclencher une exception si l’entier est négatif. Ecrivez une autre
fonction intToString() qui peut recevoir tout entier positif ou négatif. Utilisez la première fonction.

Version du corrigé :
public static String intPositifToString(int val) {
        String res = "";
        do {
            int x = val % 10;
            char c = (char)(x + (int)'0');
            res = c + res;
            val /= 10;
        } while (val != 0);
        return res;
    }
*/

public class Main {

    public static String intPositifToString(int val) {
        String res = "";
        while (val != 0) {
            int valDiv = val % 10;
            val /= 10;
            char c = (char) ((int)'0' + (int) valDiv);
            res = c + res;
        }
        return res;
    }

    public static String intToString(int val) {
        String res = intPositifToString(Math.abs(val));
        if (val < 0) {
            res = "-" + res;
        }
        return res;
    }

    public static void main(String[] args) {
        int val = 45720;
        System.out.println("Ceci est un entier : " + val);
        String sVal = intToString(val);
        System.out.println("Ceci est un String : " + sVal);
        val = -45720;
        System.out.println("Ceci est un entier : " + val);
        sVal = intToString(val);
        System.out.println("Ceci est un String : " + sVal);
    }
}
