import seqint.SeqInt;
import seqint.SeqIntIterator;

/*
Écrire une fonction qui calcule le nombre de plateaux de longueur LG (donnée et supposée
strictement positive).

e = élément courant
prec = élément précédent
lgPlat = longueur plateau courant
LG = paramètre fourni à la fonction
res = nombre de plateaux de longueur égale à LG

prec              1 2 5 5 5 4 4 6 8 8 8 8 8 8 3 2 2 1 1     => prec = e
e               1 2 5 5 5 4 4 6 8 8 8 8 8 8 3 2 2 1 1 2     => if (it.hasNext()) e = it.next()
lgPlat          1 1 1 2 3 1 2 1 1 2 3 4 5 6 1 1 2 1 2 1     => if (e != prec) lgPlat = 1 else ++lgPlat
LG[42]          0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0     => if (lgPlat == LG) ++res else if (lgPlat == (LG + 1)) --res
LG[02]          0 0 0 1 0 0 1 1 1 2 1 1 1 1 1 1 2 2 3 3     => if (lgPlat == LG) ++res else if (lgPlat == (LG + 1)) --res
LG[01]          1 2 3 2 2 3 2 3 4 3 3 3 3 3 4 5 4 5 4 5     => if (lgPlat == LG) ++res else if (lgPlat == (LG + 1)) --res

Pré-Initialisation :
    int res = 0;

Initialisation :
    if (it.hasNext())
    int e = it.next()
    int lgPlat = 1;
    if (LG == 1) res = 1
    while (it.hasNext())
    int prec = e
    e = it.next()
*/

public class Main {

    public static int nombrePlatLongLG(SeqInt s, int LG) {
        SeqIntIterator it = s.iterator();
        int res = 0;
        if (it.hasNext()) {
            int e = it.next();
            int lgPlat = 1;
            if (LG == 1) {
                res = 1;
            }
            while (it.hasNext()) {
                int prec = e;
                e = it.next();
                if (e != prec) {
                    lgPlat = 1;
                }
                else {
                    ++lgPlat;
                }
                if (lgPlat == LG) {
                    ++res;
                }
                else if (lgPlat == (LG + 1)) {
                    --res;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SeqInt s1 = new SeqInt();
        System.out.println("0 = " + nombrePlatLongLG(s1, 1));
        SeqInt s2 = new SeqInt(1, 2, 5, 5, 5, 4, 4, 6, 8, 8, 8, 8, 8, 8, 3, 2, 2, 1, 1, 2);
        System.out.println("0 = " + nombrePlatLongLG(s2, 42));
        System.out.println("3 = " + nombrePlatLongLG(s2, 2));
        System.out.println("5 = " + nombrePlatLongLG(s2, 1));
    }
}
