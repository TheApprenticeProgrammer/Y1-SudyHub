import seqint.SeqInt;
import seqint.SeqIntIterator;

/*
Écrire une fonction qui calcule la longueur du dernier plateau de hauteur maximale.

e = élément courant
prec = élément précédent
lgPlatCour = longueur du plateau courant
max = valeur du plateau de hauteur maximale
res = longueur du dernier plateau de longueur maximale

prec              5 5 2 5 4 4 5 5 5 2 2 5 5 5 5 => int prec = e;
e               5 5 2 5 4 4 5 5 5 2 2 5 5 5 5 5 => int e = it.next();
lgPlatCour      1 2 1 1 1 2 1 2 3 1 2 1 2 3 4 5 => if (e != prec) lgPlatCour = 1; else ++lgPlatCour;
max             5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 => if (e > max) max = e; res = 1;
res           0 1 2 2 2 2 2 2 2 3 3 3 3 3 3 4 5 => if (e == max && lgPlatCour > res) res = lgPlatCour;

Pré-Initialisation :
    SeqIntIterator it = s.iterator();
    int res = 0;
    return res;

Initialisation :
    if (it.hasNext())
        int e = it.next();
        int max = e;
        int lgPlatCour = 1;
        res = 1;
        while (it.hasNext())
            int prec = e;
            e = it.next();
                ...
*/

public class Main {

    public static int longueurDernierPlateau(SeqInt s) {
        SeqIntIterator it = s.iterator();
        int res = 0;
        if (it.hasNext()) {
            int e = it.next();
            int max = e;
            int lgPlatCour = 1;
            res = 1;
            while (it.hasNext()) {
                int prec = e;
                e = it.next();
                if (e != prec) {
                    lgPlatCour = 1;
                    if (e > max) {
                        max = e;
                        res = 1;
                    }
                }
                else {
                    ++lgPlatCour;
                }
                if (e == max && lgPlatCour > res) {
                    res = lgPlatCour;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SeqInt s1 = new SeqInt(5, 5, 2, 5, 4, 4, 5, 5, 5, 2, 2, 5, 5, 5, 5, 5);
        SeqInt s2 = new SeqInt(2, 2, 1, 2, 7, 7, 2, 2, 2, 7, 3, 7, 7, 1);
        SeqInt s3 = new SeqInt(5, 2, 1, 1, 2, 2, 5, 3, 7, 7, 7, 4, 6, 6, 5);
        System.out.println("5 = " + longueurDernierPlateau(s1));
        System.out.println("2 = " + longueurDernierPlateau(s2));
        System.out.println("3 = " + longueurDernierPlateau(s3));
    }
}
