import eu.epfc.prm.Array;

/*
Ecrivez une fonction qui renvoie la position de la 1ère apparition d’une valeur dans un tableau. On
considère que le premier se trouve en position 0. Et si la valeur cherchée n'apparaît pas ? Que
renvoyez-vous ?
*/

public class Main {

    public static int firstPos(Array<Integer> tab, int val) {
        int res = -1;
        boolean find = false;
        for (int i = 0; i < tab.size() && !find; ++i) {
            int e = tab.get(i);
            if (e == val) {
                find = true;
                res = i;
            }
        }
        return res;
    }

    public static int lastPos(Array<Integer> tab, int val) {
        int res = -1;
        for (int i = 0; i < tab.size(); ++i) {
            int e = tab.get(i);
            if (e == val) {
                res = i;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Array<Integer> tab = new Array<>(1, 2, 3, 4, 5, 1, 2, 2, 2);
        System.out.println("Première apparition :");
        System.out.println("0 = " + firstPos(tab, 1));
        System.out.println("1 = " + firstPos(tab, 2));
        System.out.println("-1 = " + firstPos(tab, 42));
        System.out.println();
        System.out.println("Dernière apparition :");
        System.out.println("5 = " + lastPos(tab, 1));
        System.out.println("8 = " + lastPos(tab, 2));

    }
}
