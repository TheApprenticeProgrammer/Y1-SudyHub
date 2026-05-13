import eu.epfc.prm.Array;

public class Main {

    public static void triParSelection(Array<Integer> tab) {
        for (int i = 0; i < tab.size() - 1; ++i) {
            int posMin = posMinList(tab, i);
            switchMin(tab, posMin, i);
        }
    }

    public static int posMinList(Array<Integer> unorderedList, int write) {
        int res = 0;
        if (unorderedList.isEmpty()) {
            throw new RuntimeException("Empty list !");
        }
        else {
            int min = unorderedList.get(write);
            for (int i = write + 1; i < unorderedList.size(); ++i) {
                if (min > unorderedList.get(i)) {
                    res = i;
                    min = unorderedList.get(i);
                }
            }
        }
        return res;
    }

    public static void switchMin(Array<Integer> unorderedList, int posMin, int write) {
        int save = unorderedList.get(write);
        unorderedList.set(write, unorderedList.get(posMin));
        unorderedList.set(posMin, save);
    }

    public static void main(String[] args) {
        int write = 0;
        System.out.println("Liste non-ordonnée :");
        Array<Integer> unorderedList = new Array<>(5, 9, 1, 3, 4);
        System.out.println(unorderedList);
        triParSelection(unorderedList);
        System.out.println(unorderedList);
    }
}
