import eu.epfc.prm.Array;
import java.util.Scanner;

/*
Ecrivez une fonction qui renverse l’ordre des éléments d’un tableau. Si le tableau contient
initialement les entiers [4, 7, 5, 2, 4, 3, 2, 3] ; il contiendra après renversement : [3,
2, 3, 4, 2, 5, 7, 4].
*/

public class Main {

    public static void switchWithWhile(Array<Integer> tab) {
        int g = 0;
        int d = tab.size() -1;
        while (g < tab.size() / 2) {
            int save = tab.get(g);
            tab.set(g, tab.get(d));
            tab.set(d, save);
            ++g;
            --d;
        }
    }

    public static void switchWithFor(Array<Integer> tab) {
        int d = tab.size() - 1;
        for (int i = 0; i < tab.size() / 2; ++i) {
            int save = tab.get(i);
            tab.set(i, tab.get(d));
            tab.set(d, save);
            --d;
        }
    }

    public static void echange(Array<Integer> tab, int id1, int id2) {
        int tmp = tab.get(id1);
        tab.set(id1, tab.get(id2));
        tab.set(id2, tmp);
    }

    public static void switchWithEchange(Array<Integer> tab) {
        int g = 0;
        int d = tab.size() - 1;
        while (g < d) {
            echange(tab, g, d);
            ++g;
            --d;
        }
    }

    public static void main(String[] args) {
        Array<Integer> tab = new Array<>(4, 7, 5, 2, 4, 3, 2, 3);
        System.out.println(tab);
        System.out.println("Switch 01 : ");
        switchWithWhile(tab);
        System.out.println(tab);
        System.out.println("Switch 02 : ");
        switchWithFor(tab);
        System.out.println(tab);
        System.out.println("Switch 03 : ");
        switchWithEchange(tab);
        System.out.println(tab);
    }
}
