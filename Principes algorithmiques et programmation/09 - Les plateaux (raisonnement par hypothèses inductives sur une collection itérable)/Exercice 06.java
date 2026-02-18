import seqint.SeqInt;
import seqint.SeqIntIterator;

/*
Écrire une fonction qui calcule le nombre de plateaux de longueur supérieure ou égale à LG
(donnée et supposée strictement positive).

e = élément courant
prec = élément précédent
lgPlatCour = longueur du plateau courant
LG = paramètre envoyé à la fonction

prec              1 1 2 2 2 4 5 5 8 8 8 4 4 4   =>  prec = e
e               1 1 2 2 2 4 5 5 8 8 8 4 4 4 4   =>  e = it.next()
lgPlatCour      1 2 1 2 3 1 1 2 1 2 3 1 2 3 4   =>  if (e == prec) ++lgPlatCour else lgPlatCour = 1
LG[01]          1 1 2 2 2 3 4 4 5 5 5 6 6 6 6   =>  if (lgPlatCour == LG) ++res
    => Si LG == 1 je dois directement incrémenter res de 1  => if (LG == 1) res = 1
LG[02]          0 1 1 2 2 2 2 3 3 4 4 4 5 5 5   =>  if (lgPlatCour == LG) ++res
LG[03]          0 0 0 0 1 1 1 1 1 1 2 2 2 3 3   =>  if (lgPlatCour == LG) ++res

Pré-Initialisation :
    int res = 0   => retourne zéro si la séquence est vide ou si il n'y a pas de plateau de longueur LG

Initialisation :
    if (it.hasnext())
        int e = it.next()
        int lgPlatCour = 1
        if (LG == 1)
            res = 1
        while (it.hasNext())
            int prec = e
            e = it.next() ...

Version du corrigé :

        public static int nbPlateauxLongueurPlusGrandEgalLG(SeqInt s, int lg) {
        int res = 0;
        SeqIntIterator it = s.iterator();
        if (it.hasNext()) {
            int e = it.next();
            int lgPlatCourant = 1;
            if (lgPlatCourant == lg) {
                res = 1;
            }
            while (it.hasNext()) {
                int prec = e;
                e = it.next();
                if (e != prec) {
                    lgPlatCourant = 1;
                } else {
                    ++lgPlatCourant;
                }
                if (lgPlatCourant == lg) {
                    ++res;
                }
            }
        }
        return res;
*/

public class Main {

    public static int nbPlateauxLongueurPlusGrandEgalLG(SeqInt s, int LG) {
        SeqIntIterator it = s.iterator();
        int res = 0;
        if (it.hasNext()) {
            int e = it.next();
            int lgPlatCour = 1;
            if (lgPlatCour == LG) {
                res = 1;
            }
            while (it.hasNext()) {
                int prec = e;
                e = it.next();
                if (e == prec) {
                    ++lgPlatCour;
                    if (lgPlatCour == LG) {
                        ++res;
                    }
                }
                else {
                    lgPlatCour = 1;
                    if (LG == 1) {
                        ++res;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SeqInt s1 = new SeqInt();
        SeqInt s2 = new SeqInt(1);
        SeqInt s3 = new SeqInt(1, 1, 2, 2, 2, 4, 5, 5, 8, 8, 8, 4, 4, 4, 4);
        System.out.println("0 = " + nbPlateauxLongueurPlusGrandEgalLG(s1, 42));
        System.out.println("1 = " + nbPlateauxLongueurPlusGrandEgalLG(s2, 1));
        System.out.println("0 = " + nbPlateauxLongueurPlusGrandEgalLG(s2, 2));
        System.out.println("6 = " + nbPlateauxLongueurPlusGrandEgalLG(s3, 1));
        System.out.println("5 = " + nbPlateauxLongueurPlusGrandEgalLG(s3, 2));
        System.out.println("3 = " + nbPlateauxLongueurPlusGrandEgalLG(s3, 3));
    }
}
