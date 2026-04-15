import seqint.SeqInt;
import seqint.SeqIntIterator;

/*
Écrire une fonction qui calcule le nombre de plateaux de hauteur maximale et de longueur LG
(donnée et supposée strictement positive).

prec              1 5 5 2 5 5 5 2 5 5 3 5 2 5 5 5 2 5   =>  int prec = e;
e               1 5 5 2 5 5 5 2 5 5 3 5 2 5 5 5 2 5 5   =>  int e = it.next();
lgPlatCour      1 1 2 1 1 2 3 1 1 2 1 1 1 1 2 3 1 1 2   =>  if (e != prec) lgPlatCour = 1; else ++lgPlatCour;
max             1 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5   =>  if (e > max) max = e;
LG[01]        0 1 1 0 0 1 0 0 0 1 0 0 1 1 2 1 1 1 2 1   =>  if (e == max && lgPlatCour == LG) ++res; else if (e == max && lgPlatCour == LG + 1) --res;
LG[02]        0 0 0 1 1 1 2 1 1 1 2 2 2 2 2 3 2 2 2 3   =>  if (e == max && lgPlatCour == LG) ++res; else if (e == max && lgPlatCour == LG + 1) --res;
LG[03]        0 0 0 0 0 0 0 1 1 1 1 1 1 1 1 1 2 2 2 2   =>  if (e == max && lgPlatCour == LG) ++res; else if (e == max && lgPlatCour == LG + 1) --res;

Pré-Initialisation :
    SeqIntIterator it = s.iterator();
    int res = 0;
    return res;

Initialisation :
    if (it.hasNext())
        int e = it.next();
        int max = e;
        int lgPlatCour = 1;
        if (lgPlatCour == LG)
            res = 1;
        while (it.hasNext())
            int prec = e;
            int e = it.next();
                ...
*/

public class Main {

    public static int nbPlateauxHauteurMaxLongLG(SeqInt s, int LG) {
        SeqIntIterator it = s.iterator();
        int res = 0;
        if (it.hasNext()) {
            int e = it.next();
            int max = e;
            int lgPlatCour = 1;
            if (lgPlatCour == LG) {
                res = 1;
            }
            while (it.hasNext()) {
                int prec = e;
                e = it.next();
                if (e != prec) {
                    lgPlatCour = 1;
                    if (e > max) {
                        max = e;
                        res = 0;
                    }
                } else {
                    ++lgPlatCour;
                }
                if (e == max && lgPlatCour == LG) {
                    ++res;
                } else if (e == max && lgPlatCour == LG + 1) --res;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SeqInt s1 = new SeqInt(5, 5, 1, 5, 5, 5, 5, 1, 5, 1, 5, 5, 9, 9, 4, 4, 9, 4, 9, 9, 9, 9, 4, 9, 9);
        System.out.println("1 = " + nbPlateauxHauteurMaxLongLG(s1, 1));
        System.out.println("2 = " + nbPlateauxHauteurMaxLongLG(s1, 2));
        System.out.println("0 = " + nbPlateauxHauteurMaxLongLG(s1, 3));
        SeqInt s2 = new SeqInt(5, 1, 5, 5, 5, 5, 1, 5, 1, 5, 9);
        System.out.println("1 = " + nbPlateauxHauteurMaxLongLG(s2, 1));
        SeqInt s3 = new SeqInt(5, 1, 5, 5, 5, 5, 1, 5, 1, 5);
        System.out.println("3 = " + nbPlateauxHauteurMaxLongLG(s3, 1));
    }
}

