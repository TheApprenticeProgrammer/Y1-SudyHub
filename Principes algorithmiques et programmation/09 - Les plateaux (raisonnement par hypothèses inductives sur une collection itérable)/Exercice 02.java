/*
Écrire une fonction qui calcule le nombre de nombre de blocs de même parité d’une séquence.
 */
import seqint.SeqInt;
import seqint.SeqIntIterator;

/*

res = 0

prec      1 1 2 2 2 5 5 / prec = e
e       1 1 2 2 2 5 5 8 / if (it.hasNext()) e = it.next()
res     1 1 2 2 2 3 3 4 / if (e % 2 != prec % 2) ++res

 */

public class Main {

    public static int nombreBlocsparité(SeqInt s) {

        SeqIntIterator it = s.iterator();

        int res = 0;

        if (it.hasNext()) {
            int e = it.next();
            res = 1;
            while (it.hasNext()) {
                int prec = e;
                e = it.next();
                if (e % 2 != prec % 2) {
                    ++res;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SeqInt s1 = new SeqInt();
        System.out.println("0 = " + nombreBlocsparité(s1));
        SeqInt s2 = new SeqInt(1, 1);
        System.out.println("1 = " + nombreBlocsparité(s2));
        SeqInt s3 = new SeqInt(1, 1, 2, 2, 2, 5, 5, 8);
        System.out.println("4 = " + nombreBlocsparité(s3));
    }
}
