/*
Écrivez une fonction qui compte le nombre d’apparitions d’un caractère donné dans un string.
Par exemple, le caractère 'o' apparaît 2 fois dans le mot "Onomatopée" car nous distinguons
minuscules et majuscules.
*/

public class Main {

    public static int nbApparitions(String s, char c) {
        int res = 0;
        for (int i = 0; i < s.length(); ++i) {
            char x = s.charAt(i);
            if ((int)c == (int)x) {
                ++res;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s1 = "Onomatopée";
        char c = 'O';
        System.out.println("Le caractère " + c + " apparait " + nbApparitions(s1, c) + " fois.");
    }
}
