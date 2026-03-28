import eu.epfc.prm.Array;

/*
Écrivez une fonction qui ajoute (insère) une valeur à une position donnée dans un tableau. On
commence à compter les positions à 0. Par exemple, ajouter la valeur 9 en position 3 dans le
tableau [4, 7, 5, 2, 4, 3, 2, 3] donnerait le tableau [4, 7, 5, 9, 2, 4, 3, 2, 3].
La valeur 9 est venue prendre la place du 2 qui occupait la position 3. En conséquence, les valeurs
suivantes ont été décalées vers la droite. Remarquez que le tableau s’est agrandi : son nombre
d’éléments a augmenté de 1. Pour ce faire, vous devez utiliser add(). Que faites-vous si la
position donnée n’est pas dans le tableau ?
*/

public class Main {

    public static void insertion(Array<Integer> tab, int pos, int val) {
        if (pos >= 0 && pos <= tab.size() - 1) {
            tab.add(0);
            int save1 = tab.get(pos);
            tab.set(pos, val);
            for (int i = pos + 1; i < tab.size(); ++i) {
                int save2 = tab.get(i);
                tab.set(i, save1);
                save1 = save2;
            }
        }
    }

    public static void insertionV2(Array<Integer> tab, int pos, int val) {
        if (pos >= 0 && pos <= tab.size() - 1) {
            tab.add(0);
            for (int i = tab.size() - 1; i > pos; --i) {
                tab.set(i, tab.get(i - 1));
            }
            tab.set(pos, val);
        }
    }

    public static boolean ajouterPos(Array<Integer> tab, int val, int idx) {
        if (idx < 0 || idx > tab.size()) {
            return false;
        }
        for (int k = idx; k < tab.size(); ++k) {
            val = tab.set(k, val);
        }
        tab.add(val);
        return true;
    }

    public static void main(String[] args) {
        Array<Integer> tab = new Array<>(4, 7, 5, 2, 4, 3, 2, 3);
        System.out.println(tab);
        insertionV2(tab, 3, 9);
        System.out.println(tab);
        System.out.println("[4, 7, 5, 9, 2, 4, 3, 2, 3]");
    }
}
