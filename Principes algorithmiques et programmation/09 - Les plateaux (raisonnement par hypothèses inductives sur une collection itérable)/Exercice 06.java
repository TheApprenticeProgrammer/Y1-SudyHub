import seqint.SeqInt;
import seqint.SeqIntIterator;

/*
Écrire une fonction qui calcule le nombre de plateaux de longueur supérieure ou égale à lg
(donnée et supposée strictement positive).

e = élément courant
prec = élément précédent
lgPlat = longueur du plateau courant
res = nombre de plateaux de longueur supérieure ou égale à lg

prec              1 1 2 2 2 1 2 3 3 4 4 4 2 2 8 8 8 8   =>  int prec = e;
e               1 1 2 2 2 1 2 3 3 4 4 4 2 2 8 8 8 8 1   =>  int e = it.next();
lgPlat        0 1 2 1 2 3 1 1 1 2 1 2 3 1 2 1 2 3 4 1   =>  if (e != prec) lgPlat = 1; else ++lgPlat;
res[01]       0 1 1 2 2 2 3 4 5 5 6 6 6 7 7 8 8 8 8 9   =>  if (lgPlat == lg) ++res;
res[02]       0 0 1 1 2 2 2 2 2 3 3 4 4 4 5 5 6 6 6 6   =>  if (lgPlat == lg) ++res;

Pré-Initialisation :
    SeqIntIterator it = s.iterator();
    int res = 0;
    return res;

Initialisation :
    if (it.hasNext())
        int e = it.next()
        int lgPlat = 1;
        if (lgPlat == lg)
            res = 1;
        while (it.hasNext())
            int prec = e;
            e = it.next();
                ...
*/

public class Main {

    public static int nbPlateauxLongueurPlusGrandEgalLG(SeqInt s, int lg) {
        SeqIntIterator it = s.iterator();
        int res = 0;
        if (it.hasNext()) {
            int e = it.next();
            int lgPlat = 1;
            if (lgPlat == lg) {    // si lg vaut 1 je dois directement incrémenter mon res
                res = 1;
            }
            while (it.hasNext()) {
                int prec = e;
                e = it.next();
                if (e != prec) {
                    lgPlat = 1;
                }
                else {
                    ++lgPlat;
                }
                if (lgPlat == lg) {
                    ++res;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SeqInt sVide = new SeqInt();
        System.out.println(sVide);
        System.out.println("nbPlateauxLongueurPlusGrandEgalLG (lg = 42) : 0 = " + nbPlateauxLongueurPlusGrandEgalLG(sVide, 42));
        System.out.println();

        SeqInt s1 = new SeqInt(5, 2, 1, 1, 1, 2, 2, 7, 7, 7, 7, 1, 2);
        System.out.println(s1);
        System.out.println("nbPlateauxLongueurPlusGrandEgalLG (lg = 2) : 3 = " + nbPlateauxLongueurPlusGrandEgalLG(s1, 2));
        System.out.println();

        SeqInt s2 = new SeqInt(5, 2, 1, 1, 2, 2, 5, 3, 3, 7, 1, 1, 7);
        System.out.println(s2);
        System.out.println("nbPlateauxLongueurPlusGrandEgalLG (lg = 1) : 9 = " + nbPlateauxLongueurPlusGrandEgalLG(s2, 1));
        System.out.println();
    }
}
