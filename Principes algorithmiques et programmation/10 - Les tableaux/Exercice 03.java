import eu.epfc.prm.Array;
import java.util.Scanner;

/*
Écrivez une fonction qui détermine si un entier donné apparaît, oui ou non, dans un tableau
d’entiers. Refaites le même exercice pour déterminer si une valeur apparaît dans le tableau en
commençant à chercher à partir d'une position donnée (commencez à compter les positions à 0).
Qu’envisagez-vous si la position de recherche n’est pas valide (est en dehors du tableau) ?

Version du cours :
    public static boolean apparait(int val, Array<Integer> tab) {
        int k = 0;
        while(k < tab.size() && tab.get(k) != val)
            ++k;
        // Nous sommes sûr que: k == tab.size() || tab.get(k) == val;
        return k < tab.size();
    }

//    public static boolean apparait(int val, Array<Integer> tab) {
//        return apparaitAPartirDe(val, tab, 0);
//    }

    // Si pos < 0, commence à chercher en 0
    // Si pos >= tab.size(), ne trouve rien
    public static boolean apparaitAPartirDe(int val, Array<Integer> tab, int pos) {
        int k = Math.max(0, pos);
        while(k < tab.size() && tab.get(k) != val)
            ++k;
        // Nous sommes sûr que: k == tab.size() || tab.get(k) == val;
        return k < tab.size();
    }
*/

public class Main {
    public static boolean apparait(Array<Integer> tab, int val) {
        boolean res = false;
        for (int i = 0; i < tab.size() && !res; ++i) {
            int a = tab.get(i);
            if (i == val) {
                res = true;
            }
        }
        return res;
    }

    public static boolean apparaitAPartirDe(Array<Integer> tab, int val, int pos) {
        boolean res = false;
        if (pos >= tab.size()) {
            throw new RuntimeException("Wrong position !");
        }
        else {
            for (int i = pos; i < tab.size() && !res; ++i) {
                int a = tab.get(i);
                if (a == val) {
                    res = true;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Array<Integer> tab = new Array<>(4, 7, 5, 2, 4, 3, 2, 3);
        System.out.println(tab);
        System.out.print("Quelle valeur chercher ? : ");
        int val = scan.nextInt();
        if(apparait(tab, val))
            System.out.println(val + " apparait dans le tableau");
        else
            System.out.println(val + " n'apparait pas dans le tableau");

        val = 5;
        if(apparait(tab, val))
            System.out.println(val + " apparait dans le tableau");
        else
            System.out.println(val + " n'apparait pas dans le tableau");
        if(apparaitAPartirDe(tab, val, 3))
            System.out.println(val + " apparait dans la fin du tableau en commençant en position 3");
        else
            System.out.println(val + " n'apparait pas dans le tableau au dela de la position 3");
    }
}
