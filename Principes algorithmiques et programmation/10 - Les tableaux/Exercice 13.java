import eu.epfc.prm.Array;

/*
Écrivez une fonction qui supprime d’un tableau tous les doubles pour ne laisser qu’une seule
occurrence de chaque valeur de départ. Si le tableau contient initialement les 8 entiers [4, 7,
5, 2, 4, 3, 2, 3] ; il contiendrait après suppression 5 entiers : [4, 7, 5, 2, 3]. Une
autre possibilité serait que le tableau contienne les mêmes valeurs mais dans l’ordre suivant : [7,
5, 4, 2, 3]. Comprenez-vous la différence ? Pouvez-vous réaliser aussi cette solution ?
*/

public class Main {

    public static void removeDuplicateFromPos(Array<Integer> tab, int pos, int val) {
        int setTab = pos;
        for (int i = pos; i < tab.size(); ++i) {
            if (tab.get(i) != val) {
                tab.set(setTab, tab.get(i));
                ++setTab;
            }
        }
        tab.reduceTo(setTab);
    }

    public static void removeAllDuplicates(Array<Integer> tab) {
        for (int i = 0; i < tab.size(); ++i) {
            removeDuplicateFromPos(tab, i + 1, tab.get(i));
        }
    }

    // Version du corrigé :
    public static boolean apparaitAPartirDe(int val, Array<Integer> tab, int pos) {
        int k = Math.max(0, pos);
        while (k < tab.size() && tab.get(k) != val) {
            ++k;
        }
        return k < tab.size();
    }

    public static void supprimeDoubles(Array<Integer> tab) {
        int dest = 0;
        for (int orig = 0; orig < tab.size(); ++orig) {
            if (!apparaitAPartirDe(tab.get(orig), tab, orig + 1)) {
                tab.set(dest, tab.get(orig));
                ++dest;
            }
        }
        tab.reduceTo(dest);
    }

    public static void main(String[] args) {
        Array<Integer> tab = new Array<>(4, 7, 5, 2, 4, 3, 2, 3);
        System.out.println(tab);
        removeAllDuplicates(tab);
        System.out.println(tab);
        System.out.println("[4, 7, 5, 2, 3]");
    }
}
