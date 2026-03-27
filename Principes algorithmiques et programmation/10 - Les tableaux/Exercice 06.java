import eu.epfc.prm.Array;
import java.util.Scanner;

/*
Ecrivez une fonction qui échange les deux valeurs d’un tableau aux positions données. Que se
passe-t-il si les positions sont invalides ?
*/

public class Main {

    public static void switchValWithPos(Array<Integer> tab, int pos1, int pos2) {
        if ((pos1 < 0 || pos2 < 0) && (pos1 >= tab.size() || pos2 >= tab.size())) {
            throw new RuntimeException("Position non valide !");
        }
        int save = tab.get(pos2);
        tab.set(pos2, tab.get(pos1));
        tab.set(pos1, save);
    }

    // version du corrigé :
    public static void echange(Array<Integer> tab, int pos1, int pos2) {
        tab.set(pos1, tab.set(pos2, tab.get(pos1)));
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Array<Integer> tab = new Array<>(1, 2, 3, 4, 5, 6 ,7, 8, 9);
        System.out.println();
        System.out.println(tab);
        System.out.print("Position du premier élément à échanger : ");
        int pos1 = scan.nextInt();
        System.out.println();
        System.out.print("Position du deuxième élément à échanger : ");
        int pos2 = scan.nextInt();
        System.out.println();
        System.out.println("Après échange : ");
        echange(tab, pos1, pos2);
        System.out.println(tab);
        System.out.println(tab.size());
    }
}
