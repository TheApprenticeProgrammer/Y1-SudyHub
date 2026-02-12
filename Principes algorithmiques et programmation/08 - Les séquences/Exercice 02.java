import seqint.SeqInt;
import seqint.SeqIntIterator;

/*
Écrivez une fonction qui calcule le nombre de valeurs dans une séquence (sa longueur).
*/

public class Main {

    public static int longueurSeq(SeqInt s) {
        SeqIntIterator it = s.iterator();
        int longueur = 0;
        while (it.hasNext()) {
            it.next();
            ++longueur;
        }
        return longueur;
    }

    public static void main(String[] args) {
        SeqInt s1 = new SeqInt();
        SeqInt s2 = new SeqInt(1);
        SeqInt s3 = new SeqInt(1, 2, 3, 4, 5);
        System.out.println("0 = " + longueurSeq(s1));
        System.out.println("1 = " + longueurSeq(s2));
        System.out.println("5 = " + longueurSeq(s3));
    }
}
