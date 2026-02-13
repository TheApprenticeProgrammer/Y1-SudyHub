import seqint.SeqInt;
import seqint.SeqIntIterator;

/*
Écrivez une fonction qui détermine si une séquence contient au moins un palier, c’est-à-dire deux
éléments consécutifs identiques. Essayez différentes séquences.
*/

public class Main {

    public static boolean contientPalier(SeqInt s) {
        SeqIntIterator it = s.iterator();
        boolean find = false;
        if (it.hasNext()) {
            int e = it.next();
            while (it.hasNext() && !find) {
                int prec = e;
                e = it.next();
                find = e == prec;
            }
        }
        return find;
    }

    public static void main(String[] args) {
        SeqInt s1 = new SeqInt();
        SeqInt s2 = new SeqInt(1, 2, 3, 4, 5, 5);
        SeqInt s3 = new SeqInt(1, 1, 2, 3, 4, 5);
        SeqInt s4 = new SeqInt(1, 1);
        System.out.println("La séquence s1 contient un palier : " + contientPalier(s1));
        System.out.println("La séquence s2 contient un palier : " + contientPalier(s2));
        System.out.println("La séquence s3 contient un palier : " + contientPalier(s3));
        System.out.println("La séquence s4 contient un palier : " + contientPalier(s4));
    }
}
