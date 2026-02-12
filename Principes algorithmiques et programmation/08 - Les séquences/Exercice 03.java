import seqint.SeqInt;
import seqint.SeqIntIterator;

/*
Écrivez une fonction qui calcule la somme des entiers d’une séquence.
*/

public class Main {

    public static int sommeSeq(SeqInt s) {
        SeqIntIterator it =s.iterator();
        int somme = 0;
        while (it.hasNext()) {
            somme += it.next();
        }
        return somme;
    }

    public static void main(String[] args) {
        SeqInt s1 = new SeqInt();
        SeqInt s2 = new SeqInt(1);
        SeqInt s3 = new SeqInt(1, 2, 3, 4, 5);
        SeqInt s4 = new SeqInt(1, 2, 0, -1, -2);
        System.out.println("0 + " + sommeSeq(s1));
        System.out.println("1 + " + sommeSeq(s2));
        System.out.println("10 + " + sommeSeq(s3));
        System.out.println("0 + " + sommeSeq(s4));
    }
}
