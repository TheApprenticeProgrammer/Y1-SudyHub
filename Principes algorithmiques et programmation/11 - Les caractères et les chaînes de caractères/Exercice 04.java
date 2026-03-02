/*
Ecrivez une fonction qui renvoie une copie en majuscule d’un string donné.
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

    public static String allStringToMaj(String s) {
        String res = "";
        for (int i = 0; i < s.length(); ++i) {
            res = res + toMaj(s.charAt(i));
        }
        return res;
    }

    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "AaAaAa";
        String s3 = "QrtP8";
        System.out.println("hello => " + allStringToMaj(s1));
        System.out.println("AaAaAa => " + allStringToMaj(s2));
        System.out.println(allStringToMaj(s3));
    }
}
