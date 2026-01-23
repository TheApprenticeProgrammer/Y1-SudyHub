import seqint.SeqInt;
import seqint.SeqIntIterator;

/*
Écrire une fonction qui calcule le nombre de plateaux de longueur 1.

e = élément courant
prec = élément précédent
lgPlat = longueur du plateau courant
res = nombre de plateaux de longueur égale à 1

prec              1 2 1 2 3 3 3 6 6 4 8 8 5 2 2     =>  prec = e
e               1 2 1 2 3 3 3 6 6 4 8 8 5 2 2 1     => if (it.hasNext()) e = it.next()
lgPlat          1 1 1 1 1 2 3 1 2 1 1 2 1 1 2 1     => if (e != prec) lgPlat = 1 else ++lgPlat
LG[01]          1 2 3 4 5 4 4 5 4 5 6 5 6 7 6 7     => if (lgPlat == LG) ++res else if (lgPlat == (LG + 1)) --res

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

    public static int nombrePlatLong1(SeqInt s, int LG) {
        SeqIntIterator it = s.iterator();
        int res = 0;
        if (it.hasNext()) {
            int e = it.next();
            int lgPlat = 1;
            res = 1;
            while (it.hasNext()) {
                int prec = e;
                e = it.next();
                if (e != prec) {
                    lgPlat = 1;
                    ++res;
                }
                else {
                    ++lgPlat;
                    if (lgPlat == (LG + 1)) {
                        --res;
                    }
                }
            }
        }
        return  res;
    }

    public static void main(String[] args) {
        SeqInt s1 = new SeqInt();
        System.out.println("0 = " + nombrePlatLong1(s1, 1));
        SeqInt s2 = new SeqInt(1, 2, 1, 2, 3, 3, 3, 6, 6, 4, 8, 8, 5, 2, 2, 1);
        System.out.println("7 = " + nombrePlatLong1(s2, 1));
    }
}
