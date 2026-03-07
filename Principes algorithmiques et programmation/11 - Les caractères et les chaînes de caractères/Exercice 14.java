/*
Écrivez une fonction intPositifToString() qui reçoit un entier positif ou nul et renvoie un string
contenant la représentation décimale de cet entier. Par exemple l’entier 123 donne le String (texte)
"123". Votre fonction doit déclencher une exception si l’entier est négatif. Écrivez une autre
fonction intToString() qui peut recevoir tout entier positif ou négatif. Utilisez la première fonction.
*/

import seqint.SeqInt;

public class Main {

    public static String intPositifToString(int val) {
        String res = "";
        if (val < 0) {
            throw new RuntimeException("Negative number");
        }
        if (val == 0) {
            res = "0";
        }
        while (val != 0) {
            int valDiv = val % 10;
            res = valDiv + res;
            val /= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        int val1 = 123;
        int val2 = 0;
        int val3 = 987654321;
        String s1 = intPositifToString(val1);
        System.out.println(s1);
        String s2 = intPositifToString(val2);
        System.out.println(s2);
        String s3 = intPositifToString(val3);
        System.out.println(s3);
    }
}
