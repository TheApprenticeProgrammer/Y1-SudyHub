import seqint.SeqInt;
import seqint.SeqIntIterator;

/*
Écrivez une fonction qui calcule le nombre d’apparitions du maximum d’une séquence.
*/

public class Main {

    public static int nbApparitionsMax(SeqInt s) {
        SeqIntIterator it = s.iterator();
        int res = 0;
        if (it.hasNext()) {
            int max = it.next();
            res = 1;
            while (it.hasNext()) {
                int e = it.next();
                if (e == max) {
                    ++res;
                }
                else if (e > max) {
                    max = e;
                    res = 1;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SeqInt s1 = new SeqInt();
        SeqInt s2 = new SeqInt(1);
        SeqInt s3 = new SeqInt(4, 4, 3, 5, 3, 4, 5);
        SeqInt s4 = new SeqInt(8, 8, 5, 5, 8, 2);
        System.out.println("0 = " + nbApparitionsMax(s1));
        System.out.println("1 = " + nbApparitionsMax(s2));
        System.out.println("2 = " + nbApparitionsMax(s3));
        System.out.println("3 = " + nbApparitionsMax(s4));
    }
}
