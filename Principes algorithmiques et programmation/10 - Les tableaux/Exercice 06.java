import eu.epfc.prm.Array;

/*
Ecrivez une fonction qui échange les deux valeurs d’un tableau aux positions données. Que se
passe-t-il si les positions sont invalides ?
*/

public class Main {

    public static Array<Integer> switchVal(Array<Integer> tab, int pos1, int pos2) {
        if ((pos1 < 0 || pos1 >= tab.size()) && (pos2 < 0 || pos2 >= tab.size())) {
            throw new RuntimeException("Position invalide !");
        }
        int save = tab.get(pos1);
        tab.set(pos1, tab.get(pos2));
        tab.set(pos2, save);
        return tab;
    }

    public static void main(String[] args) {
        Array<Integer> tab = new Array<>(1, 2, 3, 4, 5);
        System.out.println(tab);
        System.out.println();
        Array<Integer> newTab = switchVal(tab, 0, 4);
        System.out.println(newTab);
        System.out.println();
        newTab = switchVal(tab, 1, 3);
        System.out.println(newTab);

    }
}
