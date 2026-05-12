/*
Écrivez une fonction boolean sousChaine(String ssch, String ch) qui renvoie
true si et seulement si ssch est une sous-chaîne de ch (ssch apparaît comme une partie de ch). Par
exemple :
sousChaine("mai", " primaire") => true
sousChaine("mai", "machin") => false
*/

public class Main {

    public static boolean sousChaine(String ssch, String ch) {
        boolean result = false;
        if (ssch.length() <= ch.length()) {
            for (int i = 0; i <= ch.length() - ssch.length() && !result; ++i) {
                int cpt = 0;
                while (cpt < ssch.length() && ssch.charAt(cpt) == ch.charAt(i + cpt)) {
                    ++cpt;
                }
                result = cpt == ssch.length(); // Si au bout -> ssch trouvé
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s1 = "mai";
        String s2 = "primaire";
        String s3 = "machin";
        System.out.println(sousChaine(s1, s2));
        System.out.println(sousChaine(s1, s3));
    }
}
