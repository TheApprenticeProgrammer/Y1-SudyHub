import seqint.SeqInt;
import seqint.SeqIntIterator;

/*
Écrivez une fonction qui calcule le nombre de valeurs dans une séquence (sa longueur).
*/

public class Main {

    public static int longSeq(SeqInt s) {
        SeqIntIterator it = s.iterator();
        int lg = 0;
        while (it.hasNext()) {
            it.next();
            ++lg;
        }
        return lg;
    }

    public static void main(String[] args) {
        SeqInt s1 = new SeqInt();
        System.out.println("0 = " + longSeq(s1));
        SeqInt s2 = new SeqInt(1);
        System.out.println("1 = " + longSeq(s2));
        SeqInt s3 = new SeqInt(1, 2, 3, 4, 5);
        System.out.println("5 = " + longSeq(s3));
    }
}
