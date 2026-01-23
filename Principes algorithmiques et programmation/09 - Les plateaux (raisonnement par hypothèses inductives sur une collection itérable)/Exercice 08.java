import seqint.SeqInt;
import seqint.SeqIntIterator;

/*
Écrire une fonction qui calcule le nombre de plateaux de longueur 3.

e = élément courant
prec = élément précédent
lgPlat = longueur du plateau courant
res = nombre de plateaux de longueur égale à 3

prec              1 1 1 2 3 3 2 5 5 5 5 8 8 9 1 1 1 2   =>  prec = e
e               1 1 1 2 3 3 2 5 5 5 5 8 8 9 1 1 1 2 5   =>  if (it.hasNext()) e = it.next()
lgPlat          1 2 3 1 1 2 1 1 2 3 4 1 2 1 1 2 3 1 1   =>  if (e != prec) lgPlat = 1 else ++lgPlat
LG[03]          0 0 1 1 1 1 1 1 1 2 1 1 1 1 1 1 2 2 2   =>  if (lgPlat == LG) ++res else if (lgPlat == (LG + 1)) --res

Pré-Initialisation :
    int res = 0

Initialisation :
    int e = it.next()
    int lgPlat = 1
    while (it.hasNext())
    int prec = e
    e = it.next()
*/

public class Main {

    public static int nombrePlatLong3(SeqInt s, int LG) {
        SeqIntIterator it = s.iterator();
        int res = 0;
        if (it.hasNext()) {
            int e = it.next();
            int lgPlat = 1;
            while (it.hasNext()) {
                int prec = e;
                e = it.next();
                if (e != prec) {
                    lgPlat = 1;
                }
                else {
                    ++lgPlat;
                    if (lgPlat == LG) {
                        ++res;
                    }
                    else if (lgPlat == (LG + 1)) {
                        --res;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SeqInt s1 = new SeqInt(1, 1, 1, 2, 3, 3, 2, 5, 5, 5, 5, 8, 8, 9, 1, 1, 1, 2, 5);
        System.out.println("2 = " + nombrePlatLong3(s1, 3));
        SeqInt s2 = new SeqInt();
        System.out.println("0 = " + nombrePlatLong3(s2, 3));
    }
}
