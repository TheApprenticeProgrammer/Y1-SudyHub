import eu.epfc.prm.Array;

/*
Ecrivez une fonction qui renverse l’ordre des éléments d’un tableau. Si le tableau contient
initialement les entiers [4, 7, 5, 2, 4, 3, 2, 3] ; il contiendra après renversement : [3,
2, 3, 4, 2, 5, 7, 4].

tab             4 7 5 2 4 3 2 3
boucle[01]      3 7 5 2 4 3 2 4     =>  int save = tab.get(i) tab.set(tab.size - 1, save)
boucle[02]      3 2 5 2 4 3 7 4     =>  int save = tab.get(i) tab.set(tab.size - 2, save)
boucle[03]      3 2 3 2 4 5 7 4     =>  int save = tab.get(i) tab.set(tab.size - 3, save)
boucle[04]      3 2 3 4 2 5 7 4     =>  int save = tab.get(i) tab.set(tab.size - 4, save)
res             3 2 3 4 2 5 7 4

Pré-Initialisation :
    int size = tab.size -1

Initialisation :
    for (int i = 0; i < (tab.size / 2); ++i)    => si nb pair 8 / 2 = 4 | si nb impair 9 / 2 = 4 ok car le nombre du centre ne doit
                                                                                                    pas être changé.
*/

public class Main {

    public static Array<Integer> reverseArray(Array<Integer> tab) {
        int size = tab.size() - 1;
        for (int i = 0; i < (tab.size() / 2); ++i) {
            int save = tab.get(i);
            tab.set(i, tab.get(size));
            tab.set(size, save);
            --size;
        }
        return tab;
    }

    public static void main(String[] args) {
        Array<Integer> tab1 = new Array<>(4, 7, 5, 2, 4, 3, 2, 3);
        System.out.println(tab1);
        System.out.println();
        reverseArray(tab1);
        System.out.println(tab1);
        System.out.println();
        Array<Integer> tab2 = new Array<>(1, 5, 4, 3, 8, 2, 0, 7, 3, 6, 5);
        System.out.println(tab2);
        System.out.println();
        reverseArray(tab2);
        System.out.println(tab2);
    }
}

