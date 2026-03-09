import seqint.SeqInt;
import seqint.SeqIntIterator;

/*
Écrire une fonction qui calcule le nombre de plateaux qui suivent la dernière occurrence du
maximum.

e = élément courant
prec = élément précédent
res = nombre de plateaux qui suivent ma dernière occurrence du maximum

prec              1 1 2 2 2 5 5 3 3 3 4 4 2     =>  prec = e;
e               1 1 2 2 2 5 5 3 3 3 4 4 2 3     =>  e = it.next();
max             1 1 2 2 2 5 5 5 5 5 5 5 5 5     =>  if (e > max) max = e;
res           0 0 0 0 0 0 0 0 1 1 1 2 2 3 4     =>  if (e >= max) res = 0; else if (e != prec) ++res;

Pré-Initialisation :
    SeqIntIterator it = s.iterator();
    int res = 0;
    return res;

Initialisation :
    if (it.hasNext())
        int e = it.next()
        int max = e;
        while (it.hasNext())
            int prec = e;
            int e = it.next();
                ...
*/

public class Main {

    public static int nbPlateauxApresDernierMax(SeqInt s) {
        SeqIntIterator it = s.iterator();
        int res = 0; // retourne zéro si la séquence est vide
        if (it.hasNext()) {
            int e = it.next();
            int max = e;
            while (it.hasNext()) {
                int prec = e;
                e = it.next();
                if (e >= max) {
                    max = e;
                    res = 0;
                }
                else if (e != prec) {
                    ++res;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SeqInt sVide = new SeqInt();
        System.out.println(sVide);
        System.out.println("nbPlateauxApresDernierMax : 0 = " + nbPlateauxApresDernierMax(sVide));
        System.out.println();

        SeqInt s1 = new SeqInt(5, 2, 1, 1, 1, 2, 2, 5, 3, 3, 7, 1, 1, 2);
        System.out.println(s1);
        System.out.println("nbPlateauxApresDernierMax : 2 = " + nbPlateauxApresDernierMax(s1));
        System.out.println();

        SeqInt s2 = new SeqInt(5, 2, 1, 1, 1, 2, 2, 5, 3, 3, 7, 1, 1, 7);
        System.out.println(s2);
        System.out.println("nbPlateauxApresDernierMax : 0 = " + nbPlateauxApresDernierMax(s2));
        System.out.println();
    }
}
