import seqint.SeqInt;
import seqint.SeqIntIterator;

/*
Écrire une fonction qui calcule le nombre de plateaux de longueur comprise entre LG1 et LG2,
LG1 et LG2 inclus (données et on suppose LG1 > 0 et LG1 <= LG2).

e = élément courant
prec = élément précédent
lgPlatCour = longueur du plateau courant
res = nombre de plateaux de longueur comprise entre LG1 et LG2

prec              1 1 2 3 3 3 4 4 5 5 8 4 4 8 8 8   =>  int prec = e;
e               1 1 2 3 3 3 4 4 5 5 8 4 4 8 8 8 8   =>  int e = it.next();
lgPlatCour      1 2 1 1 2 3 1 2 1 2 1 1 2 1 2 3 4   =>  if (e != prec) lgPlatCour = 1; else ++lgPlatCour;
res[1 à 2]    0 1 1 2 3 3 2 3 3 4 4 5 6 6 7 7 6 6   =>  if (lgPlatCour == LG1) ++res; else if (lgPlatCour == LG2 + 1) --res;
res[3 à 4]    0 0 0 0 0 0 1 1 1 1 1 1 1 1 1 1 2 2   =>  if (lgPlatCour == LG1) ++res; else if (lgPlatCour == LG2 + 1) --res;
res[1 à 1]    0 1 0 1 2 1 1 2 1 2 1 2 3 2 3 2 2 2   =>  if (lgPlatCour == LG1) ++res; else if (lgPlatCour == LG2 + 1) --res;

Pré-Initialisation :
    SeqIntIterator it = s.iterator();
    int res = 0;
    return res;

Initialisation :
    if (it.hasNext() && LG1 <= LG2)
        int e = it.next();
        int lgPlatCour = 1;
        if (lgPlatCour == LG1)
            res = 1;
        while (it.hasNext())
            int prec = e;
            e = it.next();
                ...
*/

public class Main {

    public static int nbPlateauxLongEntreLg1EtLg2(SeqInt s, int LG1, int LG2) {
        SeqIntIterator it = s.iterator();
        int res = 0;
        if (it.hasNext() && LG1 <= LG2) {
            int e = it.next();
            int lgPlatCour = 1;
            if (lgPlatCour == LG1) {
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
                if (lgPlatCour == LG1) {
                    ++res;
                }
                else if (lgPlatCour == LG2 + 1) {
                    --res;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SeqInt sVide = new SeqInt();
        System.out.println(sVide);
        System.out.println("nbPlateauxLongEntreLg1EtLg2 (lg1 = 4, lg2 = 42) : 0 = " + nbPlateauxLongEntreLg1EtLg2(sVide, 4, 42));
        System.out.println();

        SeqInt s1 = new SeqInt(5, 2, 1, 1, 1, 2, 2, 7, 7, 7, 7, 1, 2);
        System.out.println(s1);
        System.out.println("nbPlateauxLongEntreLg1EtLg2 (lg1 = 2, lg2 = 3) : 2 = " + nbPlateauxLongEntreLg1EtLg2(s1, 2, 3));
        System.out.println();

        SeqInt s2 = new SeqInt(5, 2, 1, 1, 2, 2, 5, 3, 3, 3, 7, 1, 1, 1, 1, 7);
        System.out.println(s2);
        System.out.println("nbPlateauxLongEntreLg1EtLg2 (lg1 = 2, lg2 = 2) : 2 = " + nbPlateauxLongEntreLg1EtLg2(s2, 2, 2));
        System.out.println();

        SeqInt s3 = new SeqInt(5, 2, 1, 1, 2, 2, 5, 3, 3, 3, 7, 1, 1, 1, 1, 7);
        System.out.println(s2);
        System.out.println("nbPlateauxLongEntreLg1EtLg2 (lg1 = 3, lg2 = 2) : 0 = " + nbPlateauxLongEntreLg1EtLg2(s3, 3, 2));
        System.out.println();
    }
}
