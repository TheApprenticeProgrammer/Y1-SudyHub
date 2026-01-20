import seqint.SeqInt;
import seqint.SeqIntIterator;

/*
Écrire une fonction qui calcule le nombre de nombres
de blocs de même parité d’une séquence.

prec  = élément précédent
e = élément courant
nbBlocs = nombre de blocs de même parité

prec          5 5 1 1 1 2 2 4 8 2 2 1 2     =>  prec = e
---------------------------------------
e           5 5 1 1 1 2 2 4 8 2 2 1 2 2     => e = it.next();
---------------------------------------
nbBlocs     1 1 1 1 1 2 2 2 2 2 2 3 4 4     => if (e % 2 != prec % 2) ++nbBlocs

Pré-initialisation :
    int nbBlocs  = 0
 */

public class Main {

    public static int nombreBlocs(SeqInt s) {
        SeqIntIterator it = s.iterator();
        int nbBlocs = 0;
        if (it.hasNext()) {
            int e = it.next();
            nbBlocs = 1;
            while (it.hasNext()) {
                int prec = e;
                e = it.next();
                if (e % 2 != prec % 2) {
                    ++nbBlocs;
                }
            }
        }
        return nbBlocs;
    }

    public static void main(String[] args) {
        SeqInt sVide = new SeqInt();
        System.out.println(sVide);
        System.out.println("nbBlocs : 0 = " + nombreBlocs(sVide));
        System.out.println();

        SeqInt s = new SeqInt(5, 5, 1, 1, 1, 2, 2, 4, 8, 2, 2, 1, 2);
        System.out.println(s);
        System.out.println("nbBlocs : 4 = " + nombreBlocs(s));
        System.out.println();
    }
}
