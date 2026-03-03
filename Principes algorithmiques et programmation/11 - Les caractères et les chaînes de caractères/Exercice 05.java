/*
Ecrivez une fonction qui compte le nombre d’apparitions d’un caractère donné dans un string.
Par exemple, le caractère 'o' apparaît 2 fois dans le mot "Onomatopée" car nous distinguons
minuscules et majuscules.
*/

public class Main {

    public static int nbAppChar(String s, char c) {
        int res = 0;
        for (int i = 0; i < s.length(); ++i) {
            char carCourant = s.charAt(i);
            if ((int) carCourant == (int) c) {
                ++res;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s1 = "Onomatopée";
        String s2 = "11éé2é";
        System.out.println("2 = " + nbAppChar(s1, 'o'));
        System.out.println("1 = " + nbAppChar(s1, 'O'));
        System.out.println("3 = " + nbAppChar(s2, 'é'));
        System.out.println("2 = " + nbAppChar(s2, '1'));
    }
}
