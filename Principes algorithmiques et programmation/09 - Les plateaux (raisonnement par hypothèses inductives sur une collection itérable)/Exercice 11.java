import seqint.SeqInt;
import seqint.SeqIntIterator;

/*
Écrire une fonction qui calcule le nombre de blocs de même parité de longueur LG (donnée et
supposée strictement positive).

e = élément courant
prec = élément précédent
lgBlocCour = longueur du bloc courant
res = nombre de bloc de même parité de longueur LG

prec              1 1 3 2 3 1 5 2 2 8 8 5 3 2 8     =>  int prec = e;
e               1 1 3 2 3 1 5 2 2 8 8 5 3 2 8 8     =>  int e = it.next();
lgBlocCour      1 2 3 1 1 2 3 1 2 3 4 1 2 1 2 3     =>  if (e % 2 != prec % 2) lgBlocCour = 1; else ++lgBlocCour;
res[01]       0 1 0 0 1 2 1 1 2 1 1 1 2 1 2 1 1     =>  if (lgBlocCour == LG) ++res; else if (lgBlocCour == LG + 1) --res;
    => Attention que si LG = 1 nous devons directement incrémenter le res => if (lgBlocCour == LG) res = 1;
res[02]       0 0 1 0 0 0 1 0 0 1 0 0 0 1 1 2 1     =>  if (lgBlocCour == LG) ++res; else if (lgBlocCour == LG + 1) --res;
res[03]       0 0 0 1 1 1 1 2 2 2 3 2 2 2 2 2 3     =>  if (lgBlocCour == LG) ++res; else if (lgBlocCour == LG + 1) --res;

Pré-Initialisation :
    SeqIntIterator it = s.iterator();
    int res = 0;
    return res;

Initialisation :
    if (it.hasNext())
        int e = it.next();
        int lgBlocCour = 1;
        if (lgBlocCour == LG)
            res = 1;
        while (it.hasNext())
            int prec = e;
            e = it;next();
                ...
*/

public class Main {

    public static int nbBlocsMemePariteLongueurLG(SeqInt s, int LG) {
        SeqIntIterator it = s.iterator();
        int res = 0;
        if (it.hasNext()) {
            int e = it.next();
            int lgBlocCour = 1;
            if (lgBlocCour == LG) {
                res = 1;
            }
            while (it.hasNext()) {
                int prec = e;
                e = it.next();
                if (e % 2 != prec % 2) {
                    lgBlocCour = 1;
                }
                else {
                    ++lgBlocCour;
                }
                if (lgBlocCour == LG) {
                    ++res;
                }
                else if (lgBlocCour == LG + 1) {
                    --res;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SeqInt s = new SeqInt(2, 4, 1, 3, 1, 8, 6, 8, 8, 2, 4, 1, 7, 8, 8, 8, 1, 2);
        System.out.println(s);
        System.out.println("nbBlocsMemePariteLongueurLG (lg=3) : 2 = " + nbBlocsMemePariteLongueurLG(s, 3));
        System.out.println("nbBlocsMemePariteLongueurLG (lg=2) : 2 = " + nbBlocsMemePariteLongueurLG(s, 2));
        System.out.println("nbBlocsMemePariteLongueurLG (lg=1) : 2 = " + nbBlocsMemePariteLongueurLG(s, 1));
    }
}
