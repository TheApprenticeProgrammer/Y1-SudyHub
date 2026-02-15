import seqint.SeqInt;
import seqint.SeqIntIterator;

/*
Écrire une fonction qui calcule le nombre de plateaux d’une séquence.

e = élément courant
prec = élément précédent
nbPlat = nombre de plateaux de la séquence

prec          1 1 2 3 3 4 5 5 5 5 8     =>  prec = e
e           1 1 2 3 3 4 5 5 5 5 8 8     =>  e = it.next()
nbPlat      1 1 2 3 3 4 5 5 5 5 6 6     =>  if (e != prec) ++nbPlat

Pré-Initialisation :
    int nbPlat = 0     => renvoi zéro si la séquence est vide

Initialisation :
    if (it.hasNext())
        int e = it.next()
        nbPlat = 1     => il y a au moins un plateau
        while (it.hasNext())
            int prec = e
            e = it.next() ...
*/

public class Main {

    public static int nombrePlateaux(SeqInt s) {
        SeqIntIterator it = s.iterator();
        int nbPlat = 0;
        if (it.hasNext()) {
            int e = it.next();
            nbPlat = 1;
            while (it.hasNext()) {
                int prec = e;
                e = it.next();
                if (e != prec) {
                    ++nbPlat;
                }
            }
        }
        return nbPlat;
    }

    public static void main(String[] args) {
        SeqInt s1 = new SeqInt();
        SeqInt s2 = new SeqInt(1);
        SeqInt s3 = new SeqInt(5, 5, 5, 5, 5);
        SeqInt s4 = new SeqInt(1, 1, 4, 5, 4, 4, 8, 8, 8, 7, 3, 1, 1);
        System.out.println("0 = " + nombrePlateaux(s1));
        System.out.println("1 = " + nombrePlateaux(s2));
        System.out.println("1 = " + nombrePlateaux(s3));
        System.out.println("8 = " + nombrePlateaux(s4));
    }
}
