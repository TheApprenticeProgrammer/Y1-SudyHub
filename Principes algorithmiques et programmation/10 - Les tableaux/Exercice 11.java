import eu.epfc.prm.Array;
import java.util.Scanner;

/*
Ecrivez une fonction qui supprime l’élément d’un tableau se trouvant en une position donnée (en
commençant à compter à 0). La suppression se fait par décalage vers la gauche de tous les
éléments se trouvant plus loin que celui à supprimer dans le tableau. Utilisez reduceTo() pour
prendre en compte le changement du nombre d’éléments dans le tableau ? Que faites-vous si la
position donnée n’est pas dans le tableau ?
*/

public class Main {

    public static void delete(Array<Integer> tab, int pos) {
        if (pos >= 0 && pos < tab.size()) {
            for (int i = pos; i < tab.size() - 1; ++i) {
                tab.set(i, tab.get(i + 1));
            }
            tab.reduceTo(tab.size() - 1);
        }
    }

    public static void deleteV2(Array<Integer> tab, int pos) {
        if (pos >= 0 && pos < tab.size()) {
            for (int i = pos + 1; i < tab.size() - 1; ++i) {
                tab.set(i - 1, tab.get(i));
            }
            tab.reduceTo(tab.size() - 1);
        }
    }

    public static boolean supprimePos(Array<Integer> tab, int idx) {
        if (idx < 0 || idx >= tab.size()) {
            return false;
        }
        int tmp = tab.get(tab.size() - 1);
        for (int k = tab.size() - 2; k >= idx; --k) {
            tmp = tab.set(k, tmp);
        }
        tab.reduceTo(tab.size() - 1);
        return true;
    }

    public static void main(String[] args) {
        Array<Integer> tab = new Array<>(1, 5, 6, 8, 4, 4, 5, 6, 8);
        System.out.println(tab);
        delete(tab, 2);
        System.out.println(tab);
    }
}
