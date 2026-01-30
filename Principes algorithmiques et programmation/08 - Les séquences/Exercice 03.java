import seqint.SeqInt;
import seqint.SeqIntIterator;

/*
Écrivez une fonction qui calcule la somme des entiers d’une séquence.
*/

public class Main {

    public static int sumSeq(SeqInt s) {
        SeqIntIterator it = s.iterator();
        int somme = 0;
        while (it.hasNext()) {
            somme += it.next();
        }
        return somme;
    }

    public static void main(String[] args) {
        SeqInt s1 = new SeqInt();
        System.out.println("0 = " + sumSeq(s1));
        SeqInt s2 = new SeqInt(1, 2, 3, 4, 5);
        System.out.println("15 = " + sumSeq(s2));
    }
}
