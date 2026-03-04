/*
Comme vu dans les slides, en Java, les opérateurs de comparaison (<, >, …) ne sont pas définis
sur les chaînes de caractères (mais bien sur les caractères eux-mêmes). Ecrivez, sans utiliser la
méthode compareTo(), la fonction int compare(String ch1, String ch2) qui renvoie
un résultat négatif (quelconque) si ch1 < ch2, nul si ch1 == ch2 et positif si ch1 > ch2.
*/

public class Main {

    public static int compare(String ch1, String ch2) {
        int res = 0;
        int lg = 0;
        if (ch1.length() >= ch2.length()) {
            lg = ch2.length();
        }
        else {
            lg = ch1.length();
        }
        boolean end = false;
        for (int i = 0; i < lg && !end; ++i) {
            char car1 = ch1.charAt(i);
            char car2 = ch2.charAt(i);
            if ((int) car1 != (int) car2) {
                if ((int) car1 > (int) car2) {
                    res = 1;
                    end = true;
                }
                else {
                    res = -1;
                    end = true;
                }
            }
        }
        if (res == 0 && ch1.length() > ch2.length()) {
            res = 1;
        }
        else if (res == 0 && ch2.length() > ch1.length()) {
            res = -1;
        }
        return res;
    }

    public static void main(String[] args) {

        // Cas identiques
        System.out.println("== Cas identiques ==");
        System.out.println("0 -> " + compare("Hello", "Hello"));

        // Cas simples (différence interne)
        System.out.println("\n== Différence dans les caractères ==");
        System.out.println("1 -> " + compare("Hello", "Hella"));  // 'o' > 'a'
        System.out.println("-1 -> " + compare("Hella", "Hello")); // 'a' < 'o'

        // Cas longueurs différentes mais mêmes débuts
        System.out.println("\n== Longueurs différentes, mêmes préfixes ==");
        System.out.println("-1 -> " + compare("abc", "abcd"));   // devrait être -1
        System.out.println("1 -> " + compare("abcd", "abc"));    // devrait être 1

        // Cas où ch2 est vide
        System.out.println("\n== Cas avec chaîne vide ==");
        System.out.println("1 -> " + compare("abc", ""));        // devrait être 1
        System.out.println("-1 -> " + compare("", "abc"));       // devrait être -1
        System.out.println("0 -> " + compare("", ""));           // égalité

        // Cas complètement différents
        System.out.println("\n== Cas différents ==");
        System.out.println("-1 -> " + compare("Apple", "Banana"));
        System.out.println("1 -> " + compare("Banana", "Apple"));
    }
}
