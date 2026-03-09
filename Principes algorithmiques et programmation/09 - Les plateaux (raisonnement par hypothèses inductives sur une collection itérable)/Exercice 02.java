import seqint.SeqInt;
import seqint.SeqIntIterator;

/*
Écrire une fonction qui calcule le nombre de blocs de même parité d’une séquence.

e = élément courant
prec = élément précédent
res = nombre de blocs de même parité de la séquence

prec              1 1 3 5 2 2 4 4 8 1 2 3   =>  int prec = e;
e               1 1 3 5 2 2 4 4 8 1 2 3 5   =>  e = it.next();
res           0 1 1 1 1 2 2 2 2 2 3 4 5 5   =>  if (e % 2 != prec % 2) ++res;

Pré-Initialisation :
    SeqIntIterator it = s.iterator();
    int res = 0;
    return res;

Initialisation :
    if (it.hasNext())
        int e = it.next();
        res = 1;
        while (it.hasNext())
            int prec = e;
            e = it.next();
                ...
*/

public class Main {

    public static int nbBlocs(SeqInt s) {
        SeqIntIterator it = s.iterator();
        int res = 0;    // retourne zéro si la séquence est vide
        if (it.hasNext()) {
            int e = it.next();
            res = 1;
            while (it.hasNext()) {
                int prec = e;
                e = it.next();
                if (e % 2 != prec % 2) {
                    ++res;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SeqInt sVide = new SeqInt();
        System.out.println(sVide);
        System.out.println("nbBlocs : 0 = " + nbBlocs(sVide));
        System.out.println();

        SeqInt s = new SeqInt(5, 5, 1, 1, 1, 2, 2, 4, 8, 2, 2, 1, 2);
        System.out.println(s);
        System.out.println("nbBlocs : 4 = " + nbBlocs(s));
        System.out.println();
    }
}

