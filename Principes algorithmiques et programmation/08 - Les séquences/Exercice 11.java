import seqint.SeqInt;
import seqint.SeqIntIterator;

/*
Écrivez une fonction qui calcule la position de la dernière apparition du maximum d’une séquence
d’entiers.
*/

public class Main {

    public static int dernPosMax(SeqInt s) {
        SeqIntIterator it = s.iterator();
        int res = 0;
        if (it.hasNext()) {
            int max = it.next();
            int posCour = 1;
            res = 1;
            while (it.hasNext()) {
                int e = it.next();
                ++posCour;
                if (e >= max) {
                    max = e;
                    res = posCour;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SeqInt s1 = new SeqInt();
        SeqInt s2 = new SeqInt(5);
        SeqInt s3 = new SeqInt(5, 1, 1, 2, 5, 5);
        SeqInt s4 = new SeqInt(4, 4, 4, 4, 4);
        System.out.println("0 = " + dernPosMax(s1));
        System.out.println("1 = " + dernPosMax(s2));
        System.out.println("6 = " + dernPosMax(s3));
        System.out.println("5 = " + dernPosMax(s4));
    }
}
