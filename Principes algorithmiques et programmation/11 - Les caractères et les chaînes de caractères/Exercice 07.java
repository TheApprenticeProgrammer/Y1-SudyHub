/*
Ecrivez une fonction qui détermine si un string forme un palindrome (il est égal à sa copie
renversée). Par exemple radar forme un palindrome. Est-ce nécessaire de le renverser pour le
déterminer ?
*/

public class Main {

    public static boolean estPalindrome(String s) {
        boolean estPal = true;
        int otherSide = s.length() - 1;
        for (int i = 0; i < s.length() / 2 && estPal; ++i) {
            char min = s.charAt(i);
            char max = s.charAt(otherSide);
            if ((int) min != (int) max) {
                estPal = false;
            }
            --otherSide;
        }
        return estPal;
    }

    public static void main(String[] args) {
        String s1 = "radar";
        String s2 = "AroprA";
        String s3 = "ressasser";
        System.out.println("true = " + estPalindrome(s1));
        System.out.println("false = " + estPalindrome(s2));
        System.out.println("true = " + estPalindrome(s3));
    }
}
