/*
Ecrivez une fonction qui renvoie l’indice de la première apparition d’un caractère dans un
string. Que renvoyez-vous si le caractère n’apparaît pas dans le string ?
*/

public class Main {

    public static int firstPosCar(String s, char c) {
        int res = 0;
        if (s.length() > 0) {
            int posCour = 1;
            boolean find = false;
            for (int i = 0; i < s.length() && !find; ++i) {
                int car = s.charAt(i);
                if (car == c) {
                    res = posCour;
                    find = true;
                }
                ++posCour;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s1 = "";
        String s2 = "azeAtyuiop";
        String s3 = "Ahhhhhhhha";
        String s4 = "Ahhhhahhhhha";
        System.out.println("0 = " + firstPosCar(s1, 'a'));
        System.out.println("4 = " + firstPosCar(s2, 'A'));
        System.out.println("10 = " + firstPosCar(s3, 'a'));
        System.out.println("1 = " + firstPosCar(s4, 'A'));
    }
}
