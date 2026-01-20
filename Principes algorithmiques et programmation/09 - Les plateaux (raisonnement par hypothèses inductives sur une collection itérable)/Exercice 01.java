import seqint.SeqInt;
import seqint.SeqIntIterator;

/*
Écrire une fonction qui calcule le nombre de plateaux d’une séquence.

e = élément courant
prec = élément précédent
nbPlateaux = nombre de plateaux rencontrès

prec             5 2 1 1 1 2 2 7 7 7 7 1    =>  prec = e
-----------------------------------------
e               5 2 1 1 1 2 2 7 7 7 7 1 2   => e = it.next();
-----------------------------------------
nbPlateaux      5 2 1 1 1 2 2 7 7 7 7 1 2   => if (e != prec) ++nbPlateaux;
*/

public class Main {

    public static int nombrePlateaux(SeqInt s) {
        SeqIntIterator it = s.iterator();
        int nbPlateaux = 0;
        if (it.hasNext()) {
            int e = it.next();
            nbPlateaux = 1;
            while (it.hasNext()) {
                int prec = e;
                e = it.next();
                if (e != prec) {
                    ++nbPlateaux;
                }
            }
        }
        return nbPlateaux;
    }

    public static void main(String[] args) {
        SeqInt sVide = new SeqInt();
        System.out.println(sVide);
        System.out.println("nbPlateaux : 0 = " + nombrePlateaux(sVide));
        System.out.println();

        SeqInt s = new SeqInt(5, 2, 1, 1, 1, 2, 2, 7, 7, 7, 7, 1, 2);
        System.out.println(s);
        System.out.println("nbPlateaux : 7 = " + nombrePlateaux(s));
        System.out.println();
    }
}

