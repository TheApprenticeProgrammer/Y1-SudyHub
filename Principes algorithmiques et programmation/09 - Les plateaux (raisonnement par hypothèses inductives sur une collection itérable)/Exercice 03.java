import seqint.SeqInt;
import seqint.SeqIntIterator;

/*
Écrire une fonction qui calcule le nombre de plateaux qui précèdent la première occurrence du
maximum.

e = élément courant
prec = élément précédent
nbPlat = nombre de plateaux rencontrés jusqu'ici indépendamment du max
res = nombre de plateaux avant la première occurrence du max

prec              1 1 5 5 5 4 4 3 3 3 5 5 5     =>  prec = e
e               1 1 5 5 5 4 4 3 3 3 5 5 5 7     =>  e = it.next()
max             1 1 5 5 5 5 5 5 5 5 5 5 5 7     =>  if (e > max) max = e
nbPlat          1 1 2 2 2 3 3 4 4 4 5 5 5 6     =>  if (e != prec) ++nbPlat
res             0 0 1 1 1 1 1 1 1 1 1 1 1 5     =>  if (e > max) res = nbPlat

Pré-Initialisation :
    int res = 0  => retourne zéro si la séquence est vide ou si il n'y a pas de plateau qui précèdent la première
                    occurence du max

Initialisation :
    if (it.hasNext())
        int e = it.next()
        int max = e
        nbPlat = 1
        while (it.hasNext())
            int prec = e
            e = it.next() ...
*/

public class Main {

    public static int nbPlatBeforeMax(SeqInt s) {
        SeqIntIterator it = s.iterator();
        int res = 0;
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
        SeqInt s1 = new SeqInt();
        SeqInt s2 = new SeqInt(1, 1, 5, 5, 5, 4, 4, 3, 3, 3, 5, 5, 5, 7);
        SeqInt s3 = new SeqInt(5, 1, 2, 2, 3, 3, 4, 4, 5, 5);
        System.out.println("0 = " + nbPlatBeforeMax(s1));
        System.out.println("5 = " + nbPlatBeforeMax(s2));
        System.out.println("0 = " + nbPlatBeforeMax(s3));
    }
}
