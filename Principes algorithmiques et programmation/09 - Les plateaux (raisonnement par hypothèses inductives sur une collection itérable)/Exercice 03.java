import seqint.SeqInt;
import seqint.SeqIntIterator;

/*
Écrire une fonction qui calcule le nombre de plateaux qui précèdent la première occurrence du
maximum.

e = élément courant
prec = élément précédent
nbPlat = nombre de plateaux rencontés jusqu'ici indépendamment du max
res = nombre de plateaux qui précèdent la première occurence du max 

prec              1 1 3 3 3 2 2 5 5 5 4 4   =>  int prec = e;
e               1 1 3 3 3 2 2 5 5 5 4 4 2   =>  int e = it.next();
max             1 1 3 3 3 3 3 5 5 5 5 5 5   =>  if (e > max) max = e;
res           0 0 0 1 1 1 1 1 3 3 3 3 3 3   =>  if (e > max) res = nbPlat;
nbPlat        0 1 1 2 2 2 3 3 4 4 4 5 5 6   =>  if (e != prec) ++nbPlat;

Pré-Intialisation :
    SeqIntIterator it = s.iterator();
    int res = 0;
    return res;

Initialisation :
    if (it.hasNext())
        int e = it.next();
        int max = e;
        int nbPlat = 1;
        while (it.hasNext())
            int prec = e;
            e = it.next();
                ...
*/

public class Main {

    public static int nbPlateauxAvantMax(SeqInt s) {
        SeqIntIterator it = s.iterator();
        int res = 0; // retourne zéro si la séquence est vide ou si la première occurence du max est en premier
        if (it.hasNext()) {
            int e = it.next();
            int max = e;
            int nbPlat = 1;
            while (it.hasNext()) {
                int prec = e;
                e = it.next();
                if (e != prec) {
                    if (e > max) {
                        max = e;
                        res = nbPlat;
                    }
                    ++nbPlat;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SeqInt sVide = new SeqInt();
        System.out.println(sVide);
        System.out.println("nbPlateauxAvantMax : 0 = " + nbPlateauxAvantMax(sVide));
        System.out.println();

        SeqInt s = new SeqInt(5, 2, 1, 1, 1, 2, 2, 7, 7, 7, 7, 1, 2);
        System.out.println(s);
        System.out.println("nbPlateauxAvantMax : 4 = " + nbPlateauxAvantMax(s));
        System.out.println();
    }
}
