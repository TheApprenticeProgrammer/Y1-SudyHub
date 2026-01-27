import seqint.SeqInt;
import seqint.SeqIntIterator;

/*
Écrire une fonction qui calcule le nombre de plateaux de hauteur maximale et de longueur
strictement supérieure à 1.

prec              1 1 2 2 2 5 5 3 5 3 5 5 8 8 8 4 4 8 2 8   => int prec = e
e               1 1 2 2 2 5 5 3 5 3 5 5 8 8 8 4 4 8 2 8 8   => if (it.hasNext()) e = it.next()
lgPlat          1 2 1 2 3 1 2 1 1 1 1 2 1 2 3 1 2 1 1 1 2   => if (e == prec) ++lgPlat else lgPlat = 1
max             1 1 2 2 2 5 5 5 5 5 5 5 8 8 8 8 8 8 8 8 8   => if (e > max) max = e res = 0
res             0 1 0 1 1 0 1 1 1 1 1 2 0 1 1 1 1 1 1 1 2   => if (lgPlat == 2 && e == max) ++res

Pré-Initialisation :
    int res = 0

Initialisation :
    if (it.hasNext())
    int e = it.next()
    int lgPlat = 1
    int max = e;
    while (it.hasnext())
    int prec = e
    e = it.next()
*/

public class Main {

    public static int nombrePlatHautMaxLongSup1(SeqInt s) {
        SeqIntIterator it = s.iterator();
        int res = 0;
        if (it.hasNext()) {
            int e = it.next();
            int lgPlat = 1;
            int max = e;
            while(it.hasNext()) {
                int prec = e;
                e = it.next();
                if (e == prec) {
                    ++lgPlat;
                    if (lgPlat == 2 && e == max) {
                        ++res;
                    }
                }
                else {
                    lgPlat = 1;
                    if (e > max) {
                        max = e;
                        res = 0;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SeqInt s1 = new SeqInt();
        System.out.println("0 = " + nombrePlatHautMaxLongSup1(s1));
        SeqInt s2 = new SeqInt(1, 1, 2, 2, 2, 5, 5, 3, 5, 3, 5, 5, 8, 8, 8, 4, 4, 8, 2, 8, 8);
        System.out.println("2 = " + nombrePlatHautMaxLongSup1(s2));
    }
}
