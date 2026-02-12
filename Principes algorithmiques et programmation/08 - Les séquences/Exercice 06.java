import seqint.SeqInt;
import seqint.SeqIntIterator;

/*
Écrivez une fonction qui calcule le maximum d’une séquence d’entiers.
*/

public class Main {

    public static int maxSeq(SeqInt s) {
        SeqIntIterator it = s.iterator();
        if (!it.hasNext()) {
            throw new RuntimeException("Erreur : séquence vide");
        }
        int max = it.next();
        while (it.hasNext()) {
            int e = it.next();
            if (e > max) {
                max = e;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        SeqInt s1 = new SeqInt();
        SeqInt s2 = new SeqInt(1);
        SeqInt s3 = new SeqInt(4, 1, 2, 7, 8);
        SeqInt s4 = new SeqInt(9, 7, 4, 5, 2);
        System.out.println("9 = " + maxSeq(s4));
        System.out.println("8 = " + maxSeq(s3));
        System.out.println("1 = " + maxSeq(s2));
        System.out.println("0 = " + maxSeq(s1));
    }
}
