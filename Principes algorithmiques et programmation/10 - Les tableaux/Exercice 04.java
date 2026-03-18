import eu.epfc.prm.Array;
import java.util.Scanner;

/*
Écrivez une fonction qui renvoie la position de la 1ère apparition d’une valeur dans un tableau. On
considère que le premier se trouve en position 0. Et si la valeur cherchée n'apparaît pas ? Que
renvoyez-vous ?
*/

public class Main {

    public static int posPrem(int val, Array<Integer> tab) {
        int i = 0;
        while (i < tab.size() && tab.get(i) != val) {
            ++i;
        }
        return i;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Array<Integer> tab = new Array<>(4, 7, 5, 2, 4, 3, 2, 3);
        System.out.println(tab);
        System.out.print("Quelle valeur chercher ? : ");
        int val = scan.nextInt();
        int pos = posPrem(val, tab);
        if (pos != tab.size()) {
            System.out.println(val + " apparait dans le tableau à l'indice " + pos);
        } else {
            System.out.println(val + " n'apparait pas dans le tableau");
        }
    }
}
