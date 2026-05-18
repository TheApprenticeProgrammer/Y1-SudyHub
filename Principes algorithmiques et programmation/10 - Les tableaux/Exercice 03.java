import eu.epfc.prm.Array;

/*
Écrivez une fonction qui détermine si un entier donné apparaît, oui ou non, dans un tableau
d’entiers. Refaites le même exercice pour déterminer si une valeur apparaît dans le tableau en
commençant à chercher à partir d'une position donnée (commencez à compter les positions à 0).
Qu’envisagez-vous si la position de recherche n’est pas valide (est en dehors du tableau) ?
*/

public class Main {

    public static boolean apparait(Array<Integer> tab, int val) {
        boolean res = false;
        int cpt = 0;
        while (!res && cpt < tab.size()) {
            res = val == tab.get(cpt);
            ++cpt;
        }
        return res;
    }

    public static boolean apparaitAPartirDe(Array<Integer> tab, int val, int pos) {
        boolean res = false;
        if (pos >= tab.size() || pos < 0) {
            throw new RuntimeException("Position incorrecte !");
        }
        while (!res && pos < tab.size()) {
            res = val == tab.get(pos);
            ++pos;
        }
        return res;
    }

    public static boolean versionCoursApparait(Array<Integer> tab, int val) {
        int cpt = 0;
        while (cpt < tab.size() && val != tab.get(cpt)) {
            ++cpt;
        }
        return cpt < tab.size();
    }

    public static boolean versionCoursAPartirDe(Array<Integer> tab, int val, int pos) {
        if (pos >= tab.size() || pos < 0) {
            throw new RuntimeException("Position incorrecte !");
        }
        while (pos < tab.size() && val != tab.get(pos)) {
            ++pos;
        }
        return pos < tab.size();
    }

    public static void main(String[] args) {
        Array<Integer> tab = new Array<>(1, 5, 5, 7, 8, 1, 6, 3, 5, 5);
        System.out.println(versionCoursApparait(tab, 9));
    }
}
