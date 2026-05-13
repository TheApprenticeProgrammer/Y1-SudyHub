import eu.epfc.prm.Array;
/*
Algorithme de tri par insertion

Step one : trié les deux premiers éléments (position relative)
1       9       5       3       4
<--ok--><-------non trié-------->

Step two : trié le troisième élément par rapport aux deux premiers triés
1       9       5       3       4
                \ => 5 > 1 && 5 < 9
1       5       9       3       4
<------trié-----><---non trié--->

Step four : trié le quatrième élément par rapport aux trois premiers triés
1       5       9       3       4
                        \ 3 > 1 && 3 < 5
1       3       5       9       4
<----------trié--------><non trié>

Step five : trié le dernier éléments par rapport aux quatre premiers triés
1       3       5       9       4
                                \ 4 > 3 && 4 < 5
1       3       4       5       9
*/

public class Main {

    public static void triParInsertion(Array<Integer> tab) {
        for (int i = 1; i < tab.size(); ++i) {
            int val = tab.get(i);
            int posDebut = i;
            while (val < tab.get(posDebut - 1) && posDebut > 0) {
                tab.set(posDebut, tab.get(posDebut - 1));
                --posDebut;
            }
            tab.set(posDebut, val);
        }
    }

    public static void main(String[] args) {
        Array<Integer> tab = new Array<>(1, 9, 5, 3, 4);
        System.out.println(tab);
        triParInsertion(tab);
        System.out.println(tab);
    }
}
