import seqint.SeqInt;
import seqint.SeqIntIterator;

/*
Écrire une fonction qui calcule le nombre de plateaux de longueur supérieure ou égale à LG
(donnée et supposée strictement positive).

e = élément courant
prec = élément précédent
lgPlat = longueur du plateau courant
LG = paramètre fourni à la fonction
res = nombre de plateaux de longueur supérieure ou égale à LG

prec              5 2 1 1 1 2 2 7 7 7 7 1   =>  prec = e
e               5 2 1 1 1 2 2 7 7 7 7 1 2   =>  if (it.hasNext()) e = it.next()
lgPlat          1 1 1 2 3 1 2 1 2 3 4 1 1   =>  if (e != prec) lgPlat = 1 else ++lgPlat
LG[42]          0 0 0 0 0 0 0 0 0 0 0 0 0   =>  if (lgPlat == 42) ++res
LG[02]          0 0 0 1 1 1 2 2 3 3 3 3 3   =>  if (lgPlat == 2) ++res
LG[01]          1 2 3 3 3 4 4 5 5 5 5 6 7   =>  if (lgPlat == 1) ++res
    --> Attention : on constate ici que pour LG=1, nous sommes face à un cas particulier, car res doit être directement incrémenté de 1.
    --> if (lgPlat == LG) res = 1

Pré-initialisation :
    int res = 0
 */

public class Main {

    public static int nbPlateauxLongueurPlusGrandEgalLG(SeqInt s, int LG) {
        SeqIntIterator it = s.iterator();
        int res = 0;
        if (it.hasNext()) {
            int e = it.next();
            int lgPlat = 1;
            if (lgPlat == LG) {
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
                if (lgPlat == LG) {
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
