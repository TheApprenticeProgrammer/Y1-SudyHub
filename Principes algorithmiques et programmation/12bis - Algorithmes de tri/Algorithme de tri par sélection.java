import eu.epfc.prm.Array;

public class Main {

    public static void triParSelection(Array<Integer> tab) {
        for (int i = 0; i < tab.size() - 1; ++i) {
            int indiceMin = i;
            for (int j = indiceMin + 1; j < tab.size(); ++j) {
                if (tab.get(indiceMin) > tab.get(j)) {
                    indiceMin = j;
                }
            }
            int save = tab.get(i);
            tab.set(i, tab.get(indiceMin));
            tab.set(indiceMin, save);
        }
    }

    public static void main(String[] args) {
        int write = 0;
        System.out.println("Liste non-ordonnée :");
        Array<Integer> unorderedList = new Array<>(5, 9, 1, 3, 4);
        triParSelection(unorderedList);
        System.out.println(unorderedList);
    }
}
