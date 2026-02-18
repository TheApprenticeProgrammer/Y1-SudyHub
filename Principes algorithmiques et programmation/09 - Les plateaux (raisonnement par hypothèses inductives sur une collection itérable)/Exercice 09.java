import seqint.SeqInt;
import seqint.SeqIntIterator;

/*
Écrire une fonction qui calcule le nombre de plateaux de longueur 1.

e = élément courant
prec = élément précédent
lgPlatCour = longueur du plateau courant
res = nombre de plateaux de longueur 1

prec              1 1 2 3 4 4 5 5 5 8 4 4 5 5   =>  prec = e
e               1 1 2 3 4 4 5 5 5 8 4 4 5 5 4   =>  e = it.next()
lgPlatCour      1 2 1 1 1 2 1 2 3 1 1 2 1 2 1   =>  if (e != prec) lgPlatCour = 1 else ++lgPlatCour
res             1 0 1 2 3 2 3 2 2 3 4 3 4 3 4   =>   if (lgPlatCour == 1) ++res else if (lgPlatCour == 2) --res

Pré-Initialisation :
    int res = 0   => retourne zéro si la séquence est vide ou si il n'y a pas de plateaux de longueur 1

Initialisation :
    if (it.hasNext())
        int e = it.next()
        int lgPlatCour = 1
        res = 1
        while (it.hasNext())
            int prec = e
            e = it.next() ...
*/

public class Main {

    public static int nbPlatLong1(SeqInt s) {
        SeqIntIterator it = s.iterator();
        int res = 0;
        if (it.hasNext()) {
            int e = it.next();
            int lgPlatCour = 1;
            res = 1;
            while (it.hasNext()) {
                int prec = e;
                e = it.next();
                if (e != prec) {
                    lgPlatCour = 1;
                }
                else {
                    ++lgPlatCour;
                }
                if (lgPlatCour == 1) {
                    ++res;
                }
                else if (lgPlatCour == 2) {
                    --res;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SeqInt sVide = new SeqInt();
        System.out.println(sVide);
        System.out.println("nbPlateauxLong1 : 0 = " + nbPlatLong1(sVide));
        System.out.println();

        SeqInt s1 = new SeqInt(5, 2, 1, 1, 1, 2, 2, 7, 7, 7, 7, 1, 2);
        System.out.println(s1);
        System.out.println("nbPlateauxLong1 : 4 = " + nbPlatLong1(s1));
        System.out.println();

        SeqInt s2 = new SeqInt(5, 2, 1, 1, 2, 2, 5, 3, 3, 7, 1, 1, 7);
        System.out.println(s2);
        System.out.println("nbPlateauxLong1 : 5 = " + nbPlatLong1(s2));
        System.out.println();
    }
}
