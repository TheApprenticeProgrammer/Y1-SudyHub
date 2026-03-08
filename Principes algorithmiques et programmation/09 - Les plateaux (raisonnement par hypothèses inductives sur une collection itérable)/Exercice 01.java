import seqint.SeqInt;
import seqint.SeqIntIterator;

/*
Écrire une fonction qui calcule le nombre de plateaux d’une séquence.

e = élément courant
prec = élément précédent
res = nombre de plateaux de la séquence

prec              1 1 2 2 2 4 5 8 8 8 4 4 4 4 4 1   =>  int prec = e;
e               1 1 2 2 2 4 5 8 8 8 4 4 4 4 4 1 2   =>  e = it.next();
res           0 1 1 2 2 2 3 4 5 5 5 6 6 6 6 6 7 8   =>  if (e != prec) ++res;

Pré-Initialisation :
    SeqIntIterator it =s.iterator();
    int res = 0;
    return res;

Initialisation :
    if (it.hasNext())
        int e = it.next();
        res = 1;
        while (it.hasNext())
            int prec = e;
            e = it.next();
                ...
*/

public class Main {

    public static int nbPlatSeq(SeqInt s) {
        SeqIntIterator it =s.iterator();
        int res = 0; // renvoie zéro si la séquence est vide
        if (it.hasNext()) {
            int e = it.next();
            res = 1; // il y a au moins un élément donc un plateau dans la séquence
            while (it.hasNext()) {
                int prec = e;
                e = it.next();
                if (e != prec) {
                    ++res;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SeqInt sVide = new SeqInt();
        System.out.println(sVide);
        System.out.println("nbPlateaux : 0 = " + nbPlatSeq(sVide));
        System.out.println();

        SeqInt s = new SeqInt(5, 2, 1, 1, 1, 2, 2, 7, 7, 7, 7, 1, 2);
        System.out.println(s);
        System.out.println("nbPlateaux : 7 = " + nbPlatSeq(s));
        System.out.println();
    }
}
