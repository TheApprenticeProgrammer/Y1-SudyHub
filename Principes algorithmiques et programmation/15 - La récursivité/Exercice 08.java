import eu.epfc.prm.Array;

/*
Écrivez une fonction qui calcule la somme des entiers d’un Array<Integer>.

return res = tab.get(0) + sommeArray(tab, cpt + 1); <= 1 + 2 + 3 + 4 + 5
    return res = tab.get(1) + sommeArray(tab, cpt + 1); <= 2 + 3 + 4 + 5
        return res = tab.get(2) + sommeArray(tab, cpt + 1); <= 3 + 4 + 5
            return res = tab.get(3) + sommeArray(tab, cpt + 1); <= 4 + 5
                if (4 == tab.size() -1) return tab.get(4);
*/

public class Main {

    public static int sommeArray(Array<Integer> tab, int cpt) {
        if (cpt == tab.size() - 1) {
            return tab.get(cpt);
        }
        return tab.get(cpt) + sommeArray(tab, cpt + 1);
    }

    public static void main(String[] args) {
        Array<Integer> tab = new Array<>(1, 2, 3, 4, 5);
        System.out.println("15 = " + sommeArray(tab, 0));
    }
}
