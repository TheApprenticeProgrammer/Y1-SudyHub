import eu.epfc.prm.Array;

/*
Ecrivez une fonction qui calcule la somme des entiers d’un Array<Integer>.
*/

public class Main {

    public static int sommeJusqua(Array<Integer> tab, int pos) {
        if (pos == 0) {
            return tab.get(pos);
        }
        return tab.get(pos) + sommeJusqua(tab, pos - 1);
    }

    public static int sommeAPartirDe(Array<Integer> tab, int pos) {
        if (pos == tab.size() - 1) {
            return tab.get(pos);
        }
        return tab.get(pos) + sommeAPartirDe(tab, pos + 1);
    }

    public static int sommeEntre(Array<Integer> tab, int begin, int end) {
        if (begin == end) {
            return tab.get(end);
        }
        return tab.get(begin) + sommeEntre(tab, begin + 1, end);
    }

    public static int sommeArray(Array<Integer> tab, int size) {
        if (size == tab.size() - 1) {
            return tab.get(size);
        }
        return tab.get(size) + sommeArray(tab, size + 1);
    }

    public static void main(String[] args) {
        Array<Integer> tab = new Array<>(1, 2, 3, 4, 5);
        System.out.println(sommeArray(tab, 0));
        System.out.println(sommeJusqua(tab, 3));
        System.out.println(sommeAPartirDe(tab, 2));
        System.out.println(sommeEntre(tab, 1, 3));
    }
}
