/*
Écrivez une fonction qui détermine si un string forme un palindrome (il est égal à sa copie
renversée). Par exemple radar forme un palindrome. Est-ce nécessaire de le renverser pour le
déterminer ?
*/

public class Main {

    public static boolean estPalindrome(String s) {
        boolean palindrome = true;
        int cpt = s.length() - 1;
        for (int i = 0; i < s.length() / 2 && palindrome; ++i) {
            char a = s.charAt(cpt - i);
            if ((int) s.charAt(i) != (int) a) {
                palindrome = false;
            }
        }
        return palindrome;
    }

    public static boolean estPalindromeV2(String s) {
        int g = 0, d = s.length() - 1;
        while (g < d && s.charAt(g) == s.charAt(d)) {
            ++g;
            --d;
        }
        return g >= d;
    }

    public static void main(String[] args) {
        String s1 = new String("radar");
        System.out.println(s1 + " est un palindrome : " + estPalindrome(s1));
        String s2 = new String("rador");
        System.out.println(s2 + " est un palindrome : " + estPalindrome(s2));
        String s3 = new String("ressasser");
        System.out.println(s3 + " est un palindrome : " + estPalindrome(s3));
    }
}
