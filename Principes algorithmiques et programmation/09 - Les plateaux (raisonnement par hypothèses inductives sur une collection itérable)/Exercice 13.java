import seqint.SeqInt;
import seqint.SeqIntIterator;

/*
Écrire une fonction qui calcule le nombre de plateaux de hauteur maximale.

e = élément courant
prec = élément précédent
newPlat = si e est le premier élément d'un nouveau plateau
max = valeur du plateau de hauteur maximale
res = nombre de plateau de hauteur maximale

prec              4 4 2 1 2 4 5 5 4 1 1 5 5 2   =>  int prec = e;
e               4 4 2 1 2 4 5 5 4 1 1 5 5 2 5   =>  int e = it.next();
newPlat         t f t t t t t f t t f t f t t   =>  if (e != prec) newPlat = true;
max             4 4 4 4 4 4 5 5 5 5 5 5 5 5 5   =>  if (e > max) max = e;
res           0 1 1 1 1 1 2 1 1 1 1 1 2 2 2 3   =>  if (e == max && newPlat) ++res; newPlat = false;

Pré-Initialisation :
    SeqIntIterator it = s.iterator();
    int res = 0;
    return res;

Initialisation :
    if (it.hasNext())
        int e = it.next();
        int max = e;
        boolean newPlat = false;
        res = 1;
        while (it.hasNext())
            int prec = e;
            e = it.next();
                ...
*/

public class Main {

    public static int nbPlatHautMax(SeqInt s) {
        SeqIntIterator it = s.iterator();
        int res = 0;
        if (it.hasNext()) {
            int e = it.next();
            int max = e;
            boolean newPlat = false;
            res = 1;
            while (it.hasNext()) {
                int prec = e;
                e = it.next();
                if (e != prec) {
                    newPlat = true;
                    if (e > max) {
                        max = e;
                        res = 0;
                    }
                }
                if (max == e && newPlat) {
                    ++res;
                    newPlat = false;
                }
            }
        }
        return res;
    }

    public static int nbPlatHautMaxV2(SeqInt s) {
        SeqIntIterator it = s.iterator();
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
                    res = 0;
                }
                if (max == e && e != prec) {
                    ++res;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SeqInt s1 = new SeqInt();
        System.out.println("0 = " + nbPlatHautMaxV2(s1));
        SeqInt s2 = new SeqInt(1, 1, 2, 2, 1, 2, 2, 2, 4, 4, 2, 4, 4, 3, 4, 5);
        System.out.println("1 = " + nbPlatHautMaxV2(s2));
        SeqInt s3 = new SeqInt(1, 1, 2, 2, 1, 2, 2, 2, 4, 4, 2, 4, 4, 3, 4);
        System.out.println("3 = " + nbPlatHautMaxV2(s3));
    }
}
