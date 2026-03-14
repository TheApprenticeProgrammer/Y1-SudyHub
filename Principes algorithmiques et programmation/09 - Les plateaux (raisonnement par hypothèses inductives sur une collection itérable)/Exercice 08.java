import seqint.SeqInt;
import seqint.SeqIntIterator;

/*
Écrire une fonction qui calcule le nombre de plateaux de longueur 3.

e = élément courant
prec = élément précédent
lgPlatCour = longueur du plateau courant
res = nombre de plateaux de longueur 3

prec              1 2 2 2 2 1 1 1 2 2 3 3 5 5 5 8 8 8   =>  int prec = e;
e               1 2 2 2 2 1 1 1 2 2 3 3 5 5 5 8 8 8 8   =>  int e = it.next();
lgPlatCour      1 1 2 3 4 1 2 3 1 2 1 2 1 2 3 1 2 3 4   =>  if (e != prec) lgPlat = 1; else ++lgPlat;
res           0 0 0 0 1 0 0 0 1 1 1 1 1 1 1 2 2 2 3 2   =>  if (lgPlat == 3) ++res; else if (lgPlat == 3 + 1) --res;

Pré-Initialisation :
    SeqIntIterator it = s.iterator();
    int res = 0;
    return res;

Initialisation :
    if (it.hasNext())
        int e = it.next();
        int lgPlatCour = 1;
        while (it.hasNext())
            int prec = e;
            e = it.next();
                ...
*/

public class Main {

    public static int nbPlateauxLong3(SeqInt s) {
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
        System.out.println("nbPlateauxLong3 : 0 = " + nbPlateauxLong3(sVide));
        System.out.println();

        SeqInt s1 = new SeqInt(5, 2, 1, 1, 1, 2, 2, 7, 7, 7, 7, 1, 2);
        System.out.println(s1);
        System.out.println("nbPlateauxLong3 : 1 = " + nbPlateauxLong3(s1));
        System.out.println();

        SeqInt s2 = new SeqInt(5, 2, 1, 1, 2, 2, 5, 3, 3, 7, 1, 1, 7);
        System.out.println(s2);
        System.out.println("nbPlateauxLong3 : 0 = " + nbPlateauxLong3(s2));
        System.out.println();
    } 
}
