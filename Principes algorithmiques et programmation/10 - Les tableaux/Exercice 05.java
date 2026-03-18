import eu.epfc.prm.Array;
import java.util.Scanner;

/*
Refaites le même exercice mais en renvoyant la position de la dernière apparition.

Version du cours :
        public static int posDerniere(int val, Array<Integer> tab) {
            int pos = tab.size() - 1;
            while (pos >= 0 && tab.get(pos) != val) {
                --pos;
            }
            if (pos == -1) {
                pos = tab.size();
            }
            return pos;
        }
*/

public class Main {

    public static int posDern(Array<Integer> tab, int val) {
        int res = tab.size();
        for (int i = 0; i < tab.size(); ++i) {
            if (tab.get(i) == val) {
                res = i;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Array<Integer> tab = new Array<>(4, 7, 5, 2, 4, 3, 2, 3);
        System.out.println(tab);
        System.out.print("Quelle valeur chercher ? : ");
        int val = scan.nextInt();
        int pos = posDern(tab, val);
        if (pos != tab.size()) {
            System.out.println("La dernière apparition de " + val +
                    " est à l'indice " + pos);
        } else {
            System.out.println(val + " n'apparait pas dans le tableau");
        }
    }
}
