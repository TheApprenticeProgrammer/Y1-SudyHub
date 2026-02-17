import seqint.SeqInt;
import seqint.SeqIntIterator;

/*
Écrire une fonction qui calcule le nombre de plateaux de longueur supérieure ou égale à 3.

e = élément courant
prec = élément précédent
lgPlatCour = longueur du plateau courant
res = nombre de plateaux de longueur supérieure ou égale à 3

prec              1 1 2 2 2 4 1 1 1 5 5 5 5 5 8 8 2 2   =>  prec = e
e               1 1 2 2 2 4 1 1 1 5 5 5 5 5 8 8 2 2 2   =>  e = it.next()
lgPlatCour      1 2 1 2 3 1 1 2 3 1 2 3 4 5 1 2 1 2 3   =>  if (e == prec) ++lgPlatCour else lgPlatCour = 1
res             0 0 0 0 1 1 1 1 2 2 2 3 3 3 3 3 3 3 4   =>  if (lgPlatCour == 3) ++res

Pré-Initialisation :
    int res = 0   => retourne zéro si la séquence est vide ou si il n'y a pas de plateaux de longueur supérieure ou égale à 3

Initialisation :
    if (it.hasNext())
        int e = it.next()
        int lgPlatCour = 1
        while (it.hasNext())
            int prec = e
            e = it.next() ...
*/

public class Main {

    public static int nbPlateauxLongueurPlusGrandEgal3(SeqInt s) {
        SeqIntIterator it = s.iterator();
        int res = 0;
        if (it.hasNext()) {
            int e = it.next();
            int lgPlatCour = 1;
            while (it.hasNext()) {
                int prec = e;
                e = it.next();
                if (e == prec) {
                    ++lgPlatCour;
                    if (lgPlatCour == 3) {
                        ++res;
                    }
                }
                else {
                    lgPlatCour = 1;
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
