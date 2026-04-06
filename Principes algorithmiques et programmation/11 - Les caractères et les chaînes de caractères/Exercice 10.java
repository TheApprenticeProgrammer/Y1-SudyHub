/*
Comme vu dans les slides, vous ne pouvez-pas utiliser l’opérateur == pour déterminer l’identité
de deux chaînes de caractères. Par contre, vous pouvez bien sûr l’utiliser pour comparer des
caractères. Ecrivez, sans utiliser la méthode compareTo(), une fonction : boolean
sontEgaux(String s1, String s2)
*/

public class Main {

    public static boolean sontEgaux(String s1, String s2) {
        boolean egaux = true;
        if (s1.length() != s2.length()) {
            egaux = false;
        }
        for (int i = 0; i < s1.length() && egaux; ++i) {
            char a = s1.charAt(i), b = s2.charAt(i);
            if ((int) a != (int) b) {
                egaux = false;
            }
        }
        return egaux;
    }

    public static boolean sontEgauxV2(String s1, String s2) {
        boolean egaux = s1.length() == s2.length();
        int count = 0;
        while (egaux && count < s1.length()) {
            egaux = s1.charAt(count) == s2.charAt(count);
            ++count;
        }
        return egaux;
    }

    public static void main(String[] args) {
        String s1 = new String ("Hello World !");
        String s2 = new String ("Hello Java !");
        String s3 = new String ("Hello World !");
        System.out.println("false = " + sontEgauxV2(s1, s2));
        System.out.println("false = " + sontEgauxV2(s2, s3));
        System.out.println("true = " + sontEgauxV2(s1, s3));
    }
}
