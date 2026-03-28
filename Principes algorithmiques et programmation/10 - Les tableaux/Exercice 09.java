import eu.epfc.prm.Array;
import java.util.Scanner;

/*
Écrivez une fonction qui effectue une permutation cyclique vers la droite des éléments d’un
tableau. Si le tableau contient initialement les 5 entiers [4, 7, 5, 2, 4, 3, 2, 3] ; il
contiendra après permutation : [3, 4, 7, 5, 2, 4, 3, 2].
*/

public class Main {

    public static void rightSlide(Array<Integer> tab) {
        int save = tab.get(tab.size() - 1);
        for (int i = tab.size() - 1; i > 0; --i) {
            tab.set(i, tab.get(i - 1));
        }
        tab.set(0, save);
    }

    public static void rightSlideV2(Array<Integer> tab) {
        int save = tab.get(tab.size() - 1);
        int save1 = tab.get(0);
        for (int i = 0; i < tab.size() - 1; ++i) {
            int save2 = tab.get(i + 1);
            tab.set(i + 1, save1);
            save1 = save2;
        }
        tab.set(0, save);
    }

    public static void cyclDroite(Array<Integer> tab) {
        if (tab.size() > 0) {
            int tmp = tab.get(tab.size() - 1);
            for (int i = 0; i < tab.size(); ++i) {
                tmp = tab.set(i, tmp);
            }
        }
    }

    public static void main() {
        Array<Integer> tab = new Array<>(4, 7, 5, 2, 4, 3, 2, 3);
        System.out.println(tab);
        rightSlide(tab);
        System.out.println(tab);
        System.out.println("[3, 4, 7, 5, 2, 4, 3, 2]");
    }
}
