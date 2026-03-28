import eu.epfc.prm.Array;
import java.util.Scanner;

/*
Écrivez une fonction qui effectue une permutation cyclique vers la gauche des éléments d’un
tableau. Si le tableau contient initialement les 8 entiers [4, 7, 5, 2, 4, 3, 2, 3] ; il
contiendra après permutation : [7, 5, 2, 4, 3, 2, 3, 4]. Les éléments « glissent » vers
la gauche. Le premier vient en dernier. Attention si le tableau est vide !
*/

public class Main {

    public static void leftSlide(Array<Integer> tab) {
        if (tab.size() == 0) {
            throw new RuntimeException("Séquence vide !");
        }
        int save = tab.get(0);
        for (int i = 0; i < tab.size() - 1; ++i) {
            tab.set(i, tab.get(i + 1));
        }
        tab.set(tab.size() - 1, save);
    }

    public static void cyclGauche(Array<Integer> tab) {
        if (tab.size() > 0) {
            int tmp = tab.get(0);
            for(int i = tab.size() - 1; i >= 0; --i) {
                tmp = tab.set(i, tmp); // je ne comprends pas ce que fait cette partie du code.
            }
        }
    }

    public static void main(String[] args) {
        Array<Integer> tab = new Array<>(4, 7, 5, 2, 4, 3, 2, 3);
        System.out.println(tab);
        leftSlide(tab);
        System.out.println(tab);
        System.out.println("[7, 5, 2, 4, 3, 2, 3, 4]");
    }
}
