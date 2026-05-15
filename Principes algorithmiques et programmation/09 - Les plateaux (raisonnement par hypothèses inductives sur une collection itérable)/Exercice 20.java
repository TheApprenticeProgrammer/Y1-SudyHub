/*
Écrire une fonction qui calcule la position du dernier plateau de hauteur maximale.

e = élément courant
prec = élément précédent
posCour = posistion de l'élément courant
max = valeur du plateau de hauteur maximale
res = position du plateau de hauteur maximale

prec              1 1 2 4 5 5 3 2 5 5 5 => int prec = e;
e               1 1 2 4 5 5 3 2 5 5 5 4 => int e = it.next();
posCour         1 2 3 4 5 6 7 8 9 ...   => while (it.hasNext()) ++posCour;
max             1 1 2 2 4 5 5 5 5 5 5 5 => if (e > max) max = e;
res           0 0 0 3 4 5 5 5 5 9 9 9 9 => if (e >= max) res = posCour;

Pré-Initialisation :
    SeqIntIterator it = s.iterator();
    int res = 0;
    return res;

Initialisation :
    if (it.hasNext())
        int e = it.next();
        int max = e;
        int posCour = 1;
        res = 1;
        while (it.hasNext())
            ++posCour;
            int prec = e;
            e = it.next();
                ...
*/

import seqint.SeqInt;
import seqint.SeqIntIterator;

public class Main {

    public static int posDernPlatHautMax(SeqInt s) {
        SeqIntIterator it = s.iterator();
        int res = 0;
        if (it.hasNext()) {
            int e = it.next();
            int max = e;
            int posCour = 1;
            res = 1;
            while (it.hasNext()) {
                ++posCour;
                int prec = e;
                e = it.next();
                if (e != prec) {
                    if (e >= max) {
                        res = posCour;
                        if (e > max) {
                            max = e;
                        }
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SeqInt s = new SeqInt(1, 1, 2, 4, 5, 5, 3, 2, 5, 5, 5, 4);
        System.out.println(posDernPlatHautMax(s));
    }
}
