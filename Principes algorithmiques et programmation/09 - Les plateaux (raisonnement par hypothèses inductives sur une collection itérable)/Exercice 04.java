import seqint.SeqInt;
import seqint.SeqIntIterator;

/*
Écrire une fonction qui calcule le nombre de plateaux qui suivent la dernière occurrence du
maximum.

prec              1 1 8 5 5 2 2 8 8 8 4 4 1     => prec = e
e               1 1 8 5 5 2 2 8 8 8 4 4 1 1     => e = it.next()
max             1 1 8 8 8 8 8 8 8 8 8 8 8 8     => if (e > max) max = e
res             0 0 0 1 1 2 2 0 0 0 1 1 2 2     => if (e >= max) res = 0 else if (e != prec) ++res

Pré-Initialisation :
    int res = 0     => retourne zéro si la séquence est vide

Initialisation :
    if (it.hasNext())
        int e = it.next()
        int nbPlat = 1
        int max = e
        while (it.hasNext())
            int prec = e
            e = it.next() ...
*/

public class Main {

    public static int nbPlatAfterMax(SeqInt s) {
        SeqIntIterator it = s.iterator();
        int res = 0;
        if (it.hasNext()) {
            int e = it.next();
            int max = e;
            while (it.hasNext()) {
                int prec = e;
                e = it.next();
                if (e >= max) {
                    max = e;
                    res = 0;
                }
                else if (e != prec) {
                    ++res;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SeqInt s1 = new SeqInt();
        SeqInt s2 = new SeqInt(1, 1, 8, 5, 5, 2, 2, 8, 8, 8, 4, 4, 1, 1);
        SeqInt s3 = new SeqInt(1, 1, 2, 2, 3, 3, 4, 4, 5, 5);
        System.out.println("0 = " + nbPlatAfterMax(s1));
        System.out.println("2 = " + nbPlatAfterMax(s2));
        System.out.println("0 = " + nbPlatAfterMax(s3));
    }
}
