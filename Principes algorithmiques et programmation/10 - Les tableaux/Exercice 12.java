import eu.epfc.prm.Array;
import java.util.Scanner;

/*
Ecrivez une fonction qui supprime, dans un tableau, toutes les apparitions d’une valeur donnée.
Par exemple, supprimer toutes les apparitions de 4 dans le tableau [4, 3, 7, 2, 5, 4, 4, 4,
4, 3, 5, 4] donnerait [3, 7, 2, 5, 3, 5]. Refaites le même exercice mais en commençant
à partir d’une position donnée et plus à partir du début du tableau.
*/

public class Main {

    public static void deleteVal(Array<Integer> tab, int val) {
        int setTab = 0;
        for (int i = 0; i < tab.size(); ++i) {
            if (tab.get(i) != val) {
                tab.set(setTab, tab.get(i));
                ++setTab;
            }
        }
        tab.reduceTo(setTab);
    }

    public static void deleteValStartingFrom(Array<Integer> tab, int pos, int val) {
        int setTab = pos;
        for (int i = pos; i < tab.size(); ++i) {
            if (tab.get(i) != val) {
                tab.set(setTab, tab.get(i));
                ++setTab;
            }
        }
        tab.reduceTo(setTab);
    }

    public static void main(String[] args) {
        Array<Integer> tab = new Array<>(4, 3, 7, 2, 5, 4, 4, 4, 4, 3, 5, 4);
        System.out.println(tab);
        deleteVal(tab, 4);
        System.out.println(tab);
        System.out.println("[3, 7, 2, 5, 3, 5]");
        deleteVal(tab, 5);
        System.out.println(tab);
        System.out.println("[3, 7, 2, 3]");
        System.out.println();
        Array<Integer> tab2 = new Array<>(4, 3, 7, 2, 5, 4, 4, 4, 4, 3, 5, 4);
        System.out.println(tab2);
        deleteValStartingFrom(tab2, 10, 4);
        System.out.println(tab2);
        System.out.println("[4, 3, 7, 2, 5, 4, 4, 4, 4, 3, 5]");
        deleteValStartingFrom(tab2, 4, 4);
        System.out.println(tab2);
        System.out.println("[4, 3, 7, 2, 5, 3, 5]");
        deleteValStartingFrom(tab2, 0, 4);
        System.out.println(tab2);
        System.out.println("[3, 7, 2, 5, 3, 5]");
    }
}
