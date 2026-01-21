import seqint.SeqInt;
import seqint.SeqIntIterator;

/*
Écrire une fonction qui calcule le nombre de plateaux de longueur supérieure ou égale à 3.

e = élément courant
prec = élément précédent
lgPlat = longueur du plateau courant
res = nombre de plateaux de longueur supérieure ou égale à 3

prec              5 2 1 1 1 2 2 7 7 7 7 1   =>  prec = e
e               5 2 1 1 1 2 2 7 7 7 7 1 1   =>  if (it.hasNext()) e = it.next()
lgPlat          1 1 1 2 3 1 2 1 2 3 4 1 2   => if (e != prec) lgPlat = 1 else ++lgPlat
res             0 0 0 0 1 1 1 1 1 2 2 2 2   => if (lgPlat == 3) ++res

Pré-initialisation :
    int res = 0
 */

public class Main {

    public static int nbPlateauxLongueurPlusGrandEgal3(SeqInt s) {
        SeqIntIterator it = s.iterator();
        int res = 0;
        if (it.hasNext()) {
            int e = it.next();
            int lgPlat = 1;
            while (it.hasNext()) {
                int prec = e;
                e = it.next();
                if (e != prec) {
                    lgPlat = 1;
                }
                else {
                    ++lgPlat;
                    if (lgPlat == 3) {  // Dans le correctif le if (lgPlat == 3) est en dehors du else. Est-ce une bonne pratique ?
                        ++res;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SeqInt sVide = new SeqInt();
        System.out.println(sVide);
        System.out.println("nbPlateauxLongueurPlusGrandEgal3 : 0 = " + nbPlateauxLongueurPlusGrandEgal3(sVide));
        System.out.println();

        SeqInt s1 = new SeqInt(5, 2, 1, 1, 1, 2, 2, 7, 7, 7, 7, 1, 2);
        System.out.println(s1);
        System.out.println("nbPlateauxLongueurPlusGrandEgal3 : 2 = " + nbPlateauxLongueurPlusGrandEgal3(s1));
        System.out.println();

        SeqInt s2 = new SeqInt(5, 2, 1, 1, 2, 2, 5, 3, 3, 7, 1, 1, 7);
        System.out.println(s2);
        System.out.println("nbPlateauxLongueurPlusGrandEgal3 : 0 = " + nbPlateauxLongueurPlusGrandEgal3(s2));
        System.out.println();
    }
}
