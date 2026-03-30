import seqint.SeqInt;
import seqint.SeqIntIterator;

/*
Écrire une fonction qui calcule le nombre de plateaux de hauteur maximale.

e = élément courant
prec = élément précédent
max = valeur du/des plateau(x) de hauteur maximale
res = nombre de plateaux de hauteur maximale

prec              1 1 5 4 4 5 5 8 8 8 2 2 8 8 5     =>  int prec = e;
e               1 1 5 4 4 5 5 8 8 8 2 2 8 8 5 8     =>  int e = it.next();
max             1 1 5 5 5 5 5 8 8 8 8 8 8 8 8 8     =>  if (e > max) max = e; res = 1;
res           0 1 1 1 1 1 2 2 1 1 1 1 1 2 2 2 3     =>  if (e != prec && e == max) ++res;

Pré-Initialisation :
    SeqIntIterator it =s.iterator();
    int res = 0;
    return res;

Initialisation :
    if (ithasNext())
        int e = it.next();
        int max = e;
        int res = 1;
        while (it.hasNext())
            int prec = e;
            e = it.next();
                ...
*/

public class Main {

    public static int nbAppMax(SeqInt s) {
        SeqIntIterator it =s.iterator();
        int res = 0;
        if (it.hasNext()) {
            int e = it.next();
            int max = e;
            res = 1;
            while (it.hasNext()) {
                int prec = e;
                e = it.next();
                if (e > max) {
                    max = e;
                    res = 1;
                }
                else if (e != prec && e == max) {
                    ++res;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SeqInt s = new SeqInt(1, 1, 5, 4, 4, 5, 5, 8, 8, 8, 2, 2, 8, 8, 5, 8);
        System.out.println("3 = " + nbAppMax(s));
    }
}
