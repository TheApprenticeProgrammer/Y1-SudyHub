/*
Comme vu dans les slides, vous ne pouvez-pas utiliser l’opérateur == pour déterminer l’identité
de deux chaînes de caractères. Par contre vous pouvez bien sûr l’utiliser pour comparer des
caractères. Ecrivez, sans utiliser la méthode compareTo(), une fonction : boolean
sontEgaux(String s1, String s2)
*/

public class Main {

    public static boolean sontEgaux(String s1, String s2) {
        boolean egaux = true;
        if (s1.length() == s2.length()) {
            for (int i = 0; i < s1.length() && egaux; ++i) {
                char one = s1.charAt(i);
                char two = s2.charAt(i);
                if (one != two) {
                    egaux = false;
                }
            }
        }
        else {
            egaux = false;
        }
        return egaux;
    }

    public static void main(String[] args) {
        String s1 = "Toji";
        String s2 = "Zenin";
        String s3 = "Maki";
        String s4 = "Zenin";
        System.out.println("false = " + sontEgaux(s1, s2));
        System.out.println("false = " + sontEgaux(s1, s3));
        System.out.println("false = " + sontEgaux(s2, s3));
        System.out.println("true = " + sontEgaux(s2, s4));
    }
}
