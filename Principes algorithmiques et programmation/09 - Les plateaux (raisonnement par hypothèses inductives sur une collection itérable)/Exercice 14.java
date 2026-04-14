import seqint.SeqInt;
import seqint.SeqIntIterator;

/*
Écrire une fonction qui calcule le nombre de plateaux de hauteur maximale et de longueur
strictement supérieure à 1.

e = élément courant
prec = élément précédent
max = valeur du plateau de hauteur maximale
lgPlatCour = longueur du plateau courant
res = nombre de plateaux de hauteur maximale et de longueur strictement supérieure à 1

prec              4 2 2 3 4 4 2 5 5 5 2 5 5 2 2 1   =>  int prec = e;
e               4 2 2 3 4 4 2 5 5 5 2 5 5 2 2 1 5   =>  int e = it.next();
lgPlatCour      1 1 2 1 1 2 1 1 2 3 1 1 2 1 2 1 1   =>  if (e != prec) lgPlatCour = 1; else ++lgPlatCour;
max             4 4 4 4 4 4 4 5 5 5 5 5 5 5 5 5 5   =>  if (e > max) max = e; res = 0;
res           0 0 0 0 0 0 1 1 0 1 1 1 1 2 2 2 2 2   =>  if (e == max && lgPlatCour == 2) ++res;

Pré-Initialisation :
    SeqIntIterator it = s.iterator();
    int res = 0;
    return res;

Initialisation :
    if (it.hasNext())
        int e = it.next();
        int max = e;
        int lgPlatCour = 1;
        while (it.hasNext())
            int prec = e;
            e = it.next();
                ...
*/

public class Main {

    public static int nbPlateauxHautMaxLongPlusGrand1(SeqInt s) {
        SeqIntIterator it = s.iterator();
        int res = 0;
        if (it.hasNext()) {
            int e = it.next();
            int max = e;
            int lgPlatCour = 1;
            while (it.hasNext()) {
                int prec = e;
                e = it.next();
                if (e != prec) {
                    lgPlatCour = 1;
                    if (e > max) {
                        max = e;
                        res = 0;
                    }
                }
                else {
                    ++lgPlatCour;
                    if (e == max && lgPlatCour == 2) {
                        ++res;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SeqInt s1 = new SeqInt(1, 1, 3, 3, 3, 2, 3, 1, 3, 3, 3, 5, 1, 1, 5, 5, 5, 4, 5, 5, 5, 9);
        System.out.println("0 = " + nbPlateauxHautMaxLongPlusGrand1(s1));
        SeqInt s2 = new SeqInt(1, 1, 3, 3, 3, 2, 3, 1, 3, 3, 3, 5, 1, 1, 5, 5, 5, 4, 5, 5, 5);
        System.out.println("2 = " + nbPlateauxHautMaxLongPlusGrand1(s2));
        SeqInt s3 = new SeqInt(1, 1, 3, 3, 3, 2, 3, 1, 3, 3, 3);
        System.out.println("2 = " + nbPlateauxHautMaxLongPlusGrand1(s3));
        SeqInt s4 = new SeqInt();
        System.out.println("0 = " + nbPlateauxHautMaxLongPlusGrand1(s4));
    }
}
