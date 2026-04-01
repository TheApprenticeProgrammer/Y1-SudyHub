/*
Ecrivez une fonction qui détermine si un string est formé exclusivement de minuscules. Utilisez
votre fonction de la question 1.
*/

public class Main {

    public static boolean estMin(char a) {
        return ((int) a >= (int) 'a' && (int) a <= (int) 'z');
    }

    public static boolean stringFullMin(String s) {
        boolean onlyMin = true;
        for (int i = 0; i < s.length() && onlyMin; ++i) {
            onlyMin = estMin(s.charAt(i));
        }
        return onlyMin;
    }

    // Autre version :
    public static boolean onlyMin(String s) {
        boolean min = true;
        for (int i = 0; i < s.length() && min; ++i) {
            if (!estMin(s.charAt(i))) {
                min = false;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "Hello";
        String s3 = "hEllo";
        String s4 = "heLLo";
        String s5 = "hellO";
        System.out.println("true = " + stringFullMin(s1));
        System.out.println("false = " + stringFullMin(s2));
        System.out.println("false = " + stringFullMin(s3));
        System.out.println("false = " + stringFullMin(s4));
        System.out.println("false = " + stringFullMin(s5));
    }
}
