import seqint.SeqInt;
import seqint.SeqIntIterator;

/*
Écrivez une fonction qui calcule la position de la première apparition du maximum d’une
séquence d’entiers.
*/

public class Main {

    public static int posPremMax(SeqInt s) {
        SeqIntIterator it = s.iterator();
        int res = 0;
        if (it.hasNext()) {
            int max = it.next();
            int posCour = 1;
            res = 1;
            while (it.hasNext()) {
                int e = it.next();
                ++posCour;
                if (e > max) {
                    max = e;
                    res = posCour;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SeqInt s1 = new SeqInt();
        SeqInt s2 = new SeqInt(1, 1, 1, 1);
        SeqInt s3 = new SeqInt(1, 2, 8, 4, 5, 8);
        System.out.println("0 = " + posPremMax(s1));
        System.out.println("1 = " + posPremMax(s2));
        System.out.println("3 = " + posPremMax(s3));
    }
}
