import eu.epfc.prm.Array;

/*
Ecrivez une fonction qui renvoie la somme des éléments d’un tableau d’entiers (Integer).

Autre exemple :
    public static int somme(Array<Integer> tab) {
        int somme = 0;
        for (int x : tab)
            somme += x;
        return somme;
    }
*/

public class Main {

    public static int somme(Array<Integer> tab) {
        int res = 0;
        for (int i = 0; i < tab.size(); ++i) {
            res += tab.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        Array<Integer> tab = new Array<>(4, 7, 5, 2, 4, 3, 2, 3);
        System.out.print("La somme des valeurs du tableau ");
        System.out.println(tab);
        System.out.println("Vaut: " + somme(tab));
    }
}
