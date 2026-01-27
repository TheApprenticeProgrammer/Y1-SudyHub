import seqint.SeqInt;
import seqint.SeqIntIterator;

/*
Écrire une fonction qui calcule le nombre de plateaux de hauteur maximale.

e = élément courant
prec = élément précédent
max = valeur du/des plateaux de hauteur maximale de la séquence
res = nombre de plateaux de hauteur maximale.

prec              1 1 2 2 1 5 5 5 5 3 3 2 3 5 8 8 8 5 8     => prec = e
e               1 1 2 2 1 5 5 5 5 3 3 2 3 5 8 8 8 5 8 8     => if (it.hasNext()) int e = it.next()
res             1 1 1 1 1 1 1 1 1 1 1 1 1 2 1 1 1 1 2 2     => if (e == max && e != prec) ++res
max             1 1 2 2 2 5 5 5 5 5 5 5 5 8 8 8 8 8 8 8     => if (e > max) max = e res = 1

Pré-Initialisation :
    int res = 0

Initialisation :
    if (it.hasnext())
    int e = it.next()
    int max = e
    int res = 1
*/

public class Main {

    public static int nombrePlatHautMax(SeqInt s) {
        SeqIntIterator it = s.iterator();
        int res = 0;
        if (it.hasNext()) {
            int e = it.next();
            int max = e;
            res = 1;
            while (it.hasNext()) {
                int prec = e;
                e = it.next();
                if (e == max && e != prec) {
                    ++res;
                }
                else if (e > max) {
                    max = e;
                    res = 1;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SeqInt s1 = new SeqInt(1, 2, 3, 4, 5);
        System.out.println("1 = " + nombrePlatHautMax(s1));
        SeqInt s2 = new SeqInt(1, 1, 2, 2, 1, 5, 5, 5, 5, 3, 3, 2, 3, 5, 8, 8, 8, 5, 8, 8);
        System.out.println("2 = " + nombrePlatHautMax(s2));
    }
}
