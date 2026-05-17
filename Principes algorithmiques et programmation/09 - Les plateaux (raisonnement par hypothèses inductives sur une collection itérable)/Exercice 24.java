import seqint.SeqInt;
import seqint.SeqIntIterator;

/*
Écrire une fonction qui calcule la longueur du dernier plateau de hauteur H (donnée).

e = élément courant
prec = élément précédent
lgPlatCour = longueur du plateau de l'élément courant
res = longueur du dernier plateau de hauteur h

prec              1 1 2 8 5 5 8 8 8 4 8 5 7 7 3 => int prec = e;
e               1 1 2 8 5 5 8 8 8 4 8 5 7 7 3 3 => int e = it.next();
lgPlatCour      1 2 1 1 1 2 1 2 3 1 1 1 1 2 1 2 => if (e != prec) lgPlatCour = 1; else ++lgPlatCour;
res[08]       0 0 0 0 1 1 1 1 2 3 3 1 1 1 1 1 1 => if (e == h) res = lgPlatCour;

Pré-Initialisation :
    SeqIntIterator it = s.iterator();
    int res = 0;
    return res;
Initialisation :
    if (it.hasNext())
        int e = it.next();
        int lgPlatCour = 1;
        if (e == h)
            res = 1;
        while (it.hasNext())
            int prec = e;
            e = it.next();
                ...
*/

public class Main {

    public static int longDernierPlatHautH(SeqInt s, int h) {
        SeqIntIterator it = s.iterator();
        int res = 0;
        if (it.hasNext()) {
            int e = it.next();
            int lgPlatCour = 1;
            if (e == h) {
                res = 1;
            }
            while (it.hasNext()) {
                int prec = e;
                e = it.next();
                if (e != prec) {
                    lgPlatCour = 1;
                }
                else {
                    ++lgPlatCour;
                }
                if (e == h) {
                    res = lgPlatCour;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SeqInt s = new SeqInt(1, 1, 2, 8, 5, 5, 8, 8, 8, 4, 8, 5, 7, 7, 3, 3);
        System.out.println("1 = " + longDernierPlatHautH(s, 8));
        System.out.println("2 = " + longDernierPlatHautH(s, 1));
        System.out.println("0 = " + longDernierPlatHautH(s, 9));
        System.out.println("2 = " + longDernierPlatHautH(s, 3));
        SeqInt vide = new SeqInt();
        System.out.println("0 = " + longDernierPlatHautH(vide, 2));
    }
}
