import seqint.SeqInt;
import seqint.SeqIntIterator;

/*
Écrire une fonction qui calcule le nombre de plateaux de longueur LG (donnée et supposée
strictement positive).

e = élément courant
prec = élément précédent
lgPlatCour = longueur du plateau courant
res = nombre de plateaux de longueur LG

prec              1 1 2 4 5 5 5 2 2 8 8 8 8 4 4 2 2 2   =>  int prec = e;
e               1 1 2 4 5 5 5 2 2 8 8 8 8 4 4 2 2 2 2   =>  int e = it.next();
lgPlatCour      1 2 1 1 1 2 3 1 2 1 2 3 4 1 2 1 2 3 4   =>  if (e != prec) lgPlatCour = 1 else ++lgPlatCour
res[01]       0 1 0 1 2 3 2 2 3 2 3 2 2 2 3 2 3 2 2 2   =>  if (lgPlatCour == LG) ++res; else if (lgPlatCour == LG + 1) --res;
res[02]       0 0 1 1 1 1 2 1 1 2 2 3 2 2 2 3 3 4 3 3   =>  if (lgPlatCour == LG) ++res; else if (lgPlatCour == LG + 1) --res;
res[03]       0 0 0 0 0 0 0 1 1 1 1 1 2 1 1 1 1 1 2 1   =>  if (lgPlatCour == LG) ++res; else if (lgPlatCour == LG + 1) --res;

Pré-Intialisation :
    SeqIntIterator it = s.iterator();
    int res = 0;
    return res;

Initialisation :
    if (it.hasNext())
        int e = it.next();
        int lgPlatCour = 1;
        if (lgPlatCour == LG)
            res = 1;
        while (it.hasNext())
            int prec = e;
            e = it.next();
                ...
*/

public class Main {
    public static int nbPlateauxLongLg(SeqInt s, int LG) {
        SeqIntIterator it = s.iterator();
        int res = 0;
        if (it.hasNext()) {
            int e = it.next();
            int lgPlatCour = 1;
            if (lgPlatCour == LG) {
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
                if (lgPlatCour == LG) {
                    ++res;
                }
                else if (lgPlatCour == LG + 1) {
                    --res;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SeqInt sVide = new SeqInt();
        System.out.println(sVide);
        System.out.println("nbPlateauxLongLg (lg = 42) : 0 = " + nbPlateauxLongLg(sVide, 42));
        System.out.println();

        SeqInt s1 = new SeqInt(5, 2, 1, 1, 1, 2, 2, 7, 7, 7, 7, 1, 2);
        System.out.println(s1);
        System.out.println("nbPlateauxLongLg (lg = 2) : 1 = " + nbPlateauxLongLg(s1, 2));
        System.out.println();

        SeqInt s2 = new SeqInt(5, 2, 1, 1, 2, 2, 5, 3, 3, 7, 1, 1, 7);
        System.out.println(s2);
        System.out.println("nbPlateauxLongLg (lg = 1) : 5 = " + nbPlateauxLongLg(s2, 1));
        System.out.println();
    }
}
