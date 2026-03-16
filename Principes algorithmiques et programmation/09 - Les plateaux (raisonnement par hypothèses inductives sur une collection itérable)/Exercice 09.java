import seqint.SeqInt;
import seqint.SeqIntIterator;

/*
Écrire une fonction qui calcule le nombre de plateaux de longueur 1.

e = élément courant
prec = élément précédent
lgPlatCour = longueur du plateau courant
res = nombre de plateaux de longueur 1

prec              1 2 2 3 3 3 4 5 8 8 1 2   =>  int prec = e;
e               1 2 2 3 3 3 4 5 8 8 1 2 3   =>  int e = it.next();
lgPlatCour      1 1 2 1 2 3 1 1 1 2 1 1 1   =>  if (e != prec) lgPlatCour = 1; else ++lgPlatCour;
res           0 1 2 1 2 1 1 2 3 4 3 4 5 6   =>  if (lgPlatCour == 1) ++lgPlatCour; else if (lgPlatCour == 2) --lgPlatCour;

Pré-Initialisation :
    SeqIntIterator it = s.iterator();
    int res = 0;
    return res;

Initialisation :
    if (it.hasNext())
        int e = it.next();
        int lgPlatCour = 1;
        int res = 1;
        while (it.hasNext())
            int prec = e;
            e = it.next();
                ...
*/

public class Main {

    public static int nbPlateauxLong1(SeqInt s) {
        SeqIntIterator it = s.iterator();
        int res = 0;
        if (it.hasNext()) {
            int e = it.next();
            int lgPlatCour = 1;
            res = 1;
            while (it.hasNext()) {
                int prec = e;
                e = it.next();
                if (e != prec) {
                    lgPlatCour = 1;
                    ++res;
                }
                else {
                    ++lgPlatCour;
                    if (lgPlatCour == 2) {
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
        System.out.println("nbPlateauxLong1 : 0 = " + nbPlateauxLong1(sVide));
        System.out.println();

        SeqInt s1 = new SeqInt(5, 2, 1, 1, 1, 2, 2, 7, 7, 7, 7, 1, 2);
        System.out.println(s1);
        System.out.println("nbPlateauxLong1 : 4 = " + nbPlateauxLong1(s1));
        System.out.println();

        SeqInt s2 = new SeqInt(5, 2, 1, 1, 2, 2, 5, 3, 3, 7, 1, 1, 7);
        System.out.println(s2);
        System.out.println("nbPlateauxLong1 : 5 = " + nbPlateauxLong1(s2));
        System.out.println();
    }
}
