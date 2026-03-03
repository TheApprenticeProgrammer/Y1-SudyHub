/*
Refaites l’exercice précédent pour un string pouvant être formé de plusieurs mots. Dans ce
cas, il convient d’ignorer les espaces et les différences entre minuscules et majuscules. Par
exemple : "Esope reste ici et se repose". Pour permettre à l’utilisateur d’entrer une phrase entière,
utilisez un Scanner avec la méthode nextLine().
*/

public class Main {

    public static boolean estPalindrome(String s) {
        boolean estPal = true;
        int otherSide = s.length() - 1;
        int space = ' ';
        int diffMajMin = (int) 'a' - (int) 'A';
        for (int i = 0; i < s.length() / 2 && estPal; ++i) {
            char min = s.charAt(i);
            while (min == space) {
                ++i;
                min = s.charAt(i);
            }
            char max = s.charAt(otherSide);
            while (max == space) {
                --otherSide;
                max = s.charAt(otherSide);
            }
            if ((int) min != (int) max) {
                if (((int) min + diffMajMin != (int) max) && ((int) max + diffMajMin != (int) min)) {
                    estPal = false;
                }
            }
            --otherSide;
        }
        return estPal;
    }

    public static void main(String[] args) {
        String s1 = "E so pe Re s te   IcI e t S e   repOse";
        String s2 = "Esope reste ici ou se repose";
        System.out.println("true = " + estPalindrome(s1));
        System.out.println("false = " + estPalindrome(s2));
    }
}
