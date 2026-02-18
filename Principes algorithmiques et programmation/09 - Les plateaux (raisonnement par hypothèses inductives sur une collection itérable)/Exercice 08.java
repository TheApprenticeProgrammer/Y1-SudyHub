import seqint.SeqInt;
import seqint.SeqIntIterator;

/*
Écrire une fonction qui calcule le nombre de plateaux de longueur 3.

e = élément courant
prec = élément précédent
lgPlatCour = longueur du plateau courant
res = nombre de plateaux de longueur 3

prec              1 1 2 2 2 4 5 8 8 8 2 2 2 1 1 2 2 2   => prec = e
e               1 1 2 2 2 4 5 8 8 8 2 2 2 1 1 2 2 2 2   => e = it.next()
lgPlatCour      1 2 1 2 3 1 1 1 2 3 1 2 3 1 2 1 2 3 4   => if (e != prec) lgPlatCour = 1 else ++lgPlatCour
res             0 0 0 0 1 1 1 1 1 2 2 2 3 3 3 3 3 4 3   => if (lgPlatCour == 3) ++res else if (lgPlatCour == 4) --res

Pré-Initialisation :
    int res = 0

Initialisation :
    if (it.hasNext())
        int e = it.next()
        int lgPlatCour = 1
        while (it.hasNext())
            int prec = e
            e = it.next() ...
*/

public class Main {

    public static int nbPlatLongTrois(SeqInt s) {
        SeqIntIterator it = s.iterator();
        int res = 0;
        if (it.hasNext()) {
            int e = it.next();
            int lgPlatCour = 1;
            while (it.hasNext()) {
                int prec = e;
                e = it.next();
                if (e != prec) {
                    lgPlatCour = 1;
                }
                else {
                    ++lgPlatCour;
                    if (lgPlatCour == 3) {
                        ++res;
                    }
                    else if (lgPlatCour == 4) {
                        --res;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SeqInt sVide = new SeqInt();
        System.out.println(sVide);
        System.out.println("nbPlateauxLong3 : 0 = " + nbPlatLongTrois(sVide));
        System.out.println();

        SeqInt s1 = new SeqInt(5, 2, 1, 1, 1, 2, 2, 7, 7, 7, 7, 1, 2);
        System.out.println(s1);
        System.out.println("nbPlateauxLong3 : 1 = " + nbPlatLongTrois(s1));
        System.out.println();

        SeqInt s2 = new SeqInt(5, 2, 1, 1, 2, 2, 5, 3, 3, 7, 1, 1, 7);
        System.out.println(s2);
        System.out.println("nbPlateauxLong3 : 0 = " + nbPlatLongTrois(s2));
        System.out.println();
    }
}
