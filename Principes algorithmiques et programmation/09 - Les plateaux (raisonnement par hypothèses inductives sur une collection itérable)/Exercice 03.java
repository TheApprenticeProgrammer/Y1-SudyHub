import seqint.SeqInt;
import seqint.SeqIntIterator;

/*
Écrire une fonction qui calcule le nombre de plateaux qui précèdent la première occurrence du
maximum.

prec = élément précédent
e = élément courant
res = réponse
nbPlateaux = nombre de plateaux rencontrés

prec              5 2 1 1 1 2 2 7 7 7 7 1   =>  prec = e
-----------------------------------------
e               5 2 1 1 1 2 2 7 7 7 7 1 2   =>  if(it.hasNext()) e = it.next()
-----------------------------------------
max             5 5 5 5 5 5 5 7 7 7 7 7 7   =>  if (e > max) max = e
-----------------------------------------
res             0 0 0 0 0 0 0 4 4 4 4 4 4   =>  if (e > max) res = nbPlateaux
-----------------------------------------
nbPlateaux      1 2 3 3 3 4 4 5 5 5 5 6 7   =>  if (e != prec) ++nbPlateaux

Pré-initialisation :
    int res = 0
*/

public class Main {

    public static int nombrePlatAvantMax(SeqInt s) {
        SeqIntIterator it = s.iterator();
        int res = 0;
        if (it.hasNext()) {
            int e = it.next();
            int max = e;
            int nbPlateaux = 1;
            while (it.hasNext()) {
                int prec = e;
                e = it.next();
                if (e != prec) {
                    if (e > max) {
                        max = e;
                        res = nbPlateaux;
                    }
                    ++nbPlateaux;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SeqInt sVide = new SeqInt();
        System.out.println(sVide);
        System.out.println("nbPlateauxAvantMax : 0 = " + nombrePlatAvantMax(sVide));
        System.out.println();

        SeqInt s = new SeqInt(5, 2, 1, 1, 1, 2, 2, 7, 7, 7, 7, 1, 2);
        System.out.println(s);
        System.out.println("nbPlateauxAvantMax : 4 = " + nombrePlatAvantMax(s));
        System.out.println();
    }
}
