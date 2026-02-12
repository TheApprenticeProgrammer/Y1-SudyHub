import seqint.SeqInt;
import seqint.SeqIntIterator;

/*
Écrivez une fonction qui détermine le nombre d'apparitions, dans une séquence, d'un entier n,
donné.
*/

public class Main {

    public static int nombreApparitions(SeqInt s, int val) {
        SeqIntIterator it = s.iterator();
        int res = 0;
        while (it.hasNext()) {
            if (it.next() == val) {
                ++res;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SeqInt s1 = new SeqInt();
        SeqInt s2 = new SeqInt(1);
        SeqInt s3 = new SeqInt(2, 1, 1, 2, 4, 2);
        System.out.println("0 = " + nombreApparitions(s1, 42));
        System.out.println("1 = " + nombreApparitions(s2, 1));
        System.out.println("3 = " + nombreApparitions(s3, 2));
    }
}
