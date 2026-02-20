import seqint.SeqInt;
import seqint.SeqIntIterator;

/*
Écrire une fonction qui calcule le nombre de plateaux de longueur LG (donnée et supposée
strictement positive).

e = élément courant
prec = élément précédent
lgPlatCour = longueur de plateau courant
LG = paramètre envoyé à la fonction
res = nombre de plateaux de longueur LG

prec              1 1 2 4 4 4 2 2 1 1 1 8 4 4 4 4 8     =>  prec = e
e               1 1 2 4 4 4 2 2 1 1 1 8 4 4 4 4 8 8     =>  e = it.next()
lgPlatCour      1 2 1 1 2 3 1 2 1 2 3 1 1 2 3 4 1 2     =>  if (e != prec) lgPlatCour = 1 else ++lgPlatCour
LG[01]          1 0 1 2 1 1 2 1 2 1 1 2 3 2 2 2 3 2     =>  if (lgPlatCour == LG) ++res else if (lgPlatCour == LG + 1) --res
        => Quand LG est égale à 1 il doit être incrémenté de 1 dés le début
LG[02]          0 1 1 1 2 1 1 2 2 3 2 2 2 3 2 2 2 3     =>  if (lgPlatCour == LG) ++res else if (lgPlatCour == LG + 1) --res
LG[03]          0 0 0 0 0 1 1 1 1 1 2 2 2 2 3 2 2 2     =>  if (lgPlatCour == LG) ++res else if (lgPlatCour == LG + 1) --res

Pré-Initialisation :
    int res = 0

Initialisation :
    if (it.hasNext())
        int e = it.next()
        int lgPlatCour = 1
        if (lgPlatCour == LG)
            res = 1
        while (it.hasNext())
            int prec = e
            e = it.next() ...
*/

public class Main {

    public static int nbPlatLongLG(SeqInt s, int LG) {
        SeqIntIterator it = s.iterator();
        int res = 0;
        if (it.hasNext()) {
            int e = it.next();
            int lgPlatCour = 1;
            if (lgPlatCour == LG) {
                res = 1;
            }
            while (it.hasNext()) {
                int prec = e;
                e = it.next();
                if (e != prec) {
                    lgPlatCour = 1;
                }
                else {
                    ++lgPlatCour;
                }
                if (lgPlatCour == LG) {
                    ++res;
                }
                else if (lgPlatCour == LG + 1) {
                    --res;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SeqInt s1 = new SeqInt();
        SeqInt s2 = new SeqInt(1);
        SeqInt s3 = new SeqInt(1, 1, 2, 4, 4, 4, 2, 2, 1, 1, 1, 8, 4, 4, 4, 4, 8, 8);
        System.out.println("0 = " + nbPlatLongLG(s1, 42));
        System.out.println("1 = " + nbPlatLongLG(s2, 1));
        System.out.println("2 = " + nbPlatLongLG(s3, 1));
        System.out.println("3 = " + nbPlatLongLG(s3, 2));
        System.out.println("2 = " + nbPlatLongLG(s3, 3));
    }
}
