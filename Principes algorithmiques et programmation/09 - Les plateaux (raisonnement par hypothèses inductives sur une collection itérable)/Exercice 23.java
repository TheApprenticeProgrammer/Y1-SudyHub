import seqint.SeqInt;
import seqint.SeqIntIterator;

/*
Écrire une fonction qui calcule la position du dernier plateau de hauteur H (donnée).

e = élément courant
prec = élément précédent
posCour = position courante de l'élément courant
res[01] = position de dernier plateau de hauteur H (01)

prec              1 1 5 5 1 8 4 4 3 9 9 9   => int prec = e;
e               1 1 5 5 1 8 4 4 3 9 9 9 9   => int e = it.next();
posCour         1 2 3 4 5 6 7 8 9 ...       => while (it.hasNext()) ++posCour;
res[01]       0 1 1 1 1 5 5 5 5 5 5 5 5 5   => if (e == h) res = posCour;
*/

public class Main {

    public static int posDernierPlatHautH(SeqInt s, int h) {
        SeqIntIterator it = s.iterator();
        int res = 0;
        if (it.hasNext()) {
            int e = it.next();
            int posCour = 1;
            if (e == h) {
                res = posCour;
            }
            while (it.hasNext()) {
                int prec = e;
                e = it.next();
                ++posCour;
                if (e != prec && e == h) {
                    res = posCour;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SeqInt s = new SeqInt(1, 1, 5, 5, 1, 8, 4, 4, 3, 9, 9, 9, 9);
        System.out.println("5 = " + posDernierPlatHautH(s, 1));
        System.out.println("9 = " + posDernierPlatHautH(s, 3));
        System.out.println("0 = " + posDernierPlatHautH(s, 7));
        System.out.println("6 = " + posDernierPlatHautH(s, 8));
        SeqInt vide = new SeqInt();
        System.out.println("0 = " + posDernierPlatHautH(vide, 1));
    }
}
