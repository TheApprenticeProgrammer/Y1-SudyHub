import eu.epfc.prm.Array;
import seqint.SeqInt;
import seqint.SeqIntIterator;

/*
Écrire une fonction qui calcule la position et la longueur du dernier plateau de hauteur maximale.

prec              1 1 2 5 5 4 4 5 5 5 8 5 8 => int prec = e;
e               1 1 2 5 5 4 4 5 5 5 8 5 8 8 => int e = it.next();
lgPlatCour      1 2 1 1 2 1 2 1 2 3 1 1 1 2 => if (e != prec) lgPlatCour = 1; else ++lgPlatCour;
posCour         1 2 3 4 5 6 7 8 9 ...       => while (it.hasNext()) ++posCour;
max             1 1 2 5 5 5 5 5 5 5 8 8 8 8 => if (e > max) e = max; resPos = posCour;
resPos          1 1 3 4 4 4 4 8 8 8 11...12 => if (e >= max) resPos = posCour;
resLg           1 2 1 1 2 2 2 2 2 3 1 1 1 2 => if (e >= max)

*/

public class Main {

    public static Array<Integer> posEtLongDernPlatHautMax(SeqInt s) {
        SeqIntIterator it = s.iterator();
        int resPos = 0;
        int resLg = 0;
        if (it.hasNext()) {
            int e = it.next();
            int max = e;
            int posCour = 1;
            int lgPlatCour = 1;
            resPos = 1;
            resLg = 1;
            while (it.hasNext()) {
                int prec = e;
                e = it.next();
                ++posCour;
                if (e != prec) {
                    lgPlatCour = 1;
                    if (e >= max) {
                        resPos = posCour;
                        resLg = 1;
                        if (e > max) {
                            max = e;
                        }
                    }
                }
                else {
                    ++lgPlatCour;
                    if (e == max) {
                        ++resLg;
                    }
                }
            }
        }
        return new Array<>(resPos, resLg);
    }

    public static void main(String[] args) {
        SeqInt s = new SeqInt(1, 1, 2, 5, 5, 4, 4, 5, 5, 5, 8, 5, 8, 8);
        Array<Integer> res = posEtLongDernPlatHautMax(s);
        System.out.println("13 = " + res.get(0));
        System.out.println("2 = " + res.get(1));
    }
}
