import seqint.SeqInt;
import seqint.SeqIntIterator;

/*
Écrire une fonction qui calcule le nombre de blocs de même parité de longueur inférieure ou égale
à lg (donnée et supposée strictement positive).

e = élément courant
prec = élément précédent
lgBloc = longueur du bloc courant
res = nombre de blocs de même parité de longueur inférieure ou égale à lg

prec              1 1 3 2 2 4 4 5 2 3 6 6 8 8   =>  int prec = e;
e               1 1 3 2 2 4 4 5 2 3 6 6 8 8 2   =>  int e = it.next();
lgBloc        0 1 2 3 1 2 3 4 1 1 1 1 2 3 4 1   =>  if (e % 2 != prec % 2) lgBloc = 1; else ++lgBloc;
res[01]       0 1 0 0 1 0 0 0 1 2 3 4 3 3 3 4   =>  if (lgBloc == 1) ++res; else if (lgBloc == lg + 1) --res;
res[02]       0 1 1 0 1 1 0 0 1 2 3 4 4 3 3 4   =>  if (lgBloc == 1) ++res; else if (lgBloc == lg + 1) --res;

Pré-Initialisation :
    SeqIntIterator it = s.iterator();
    int res = 0;
    return res;

Initialisation :
    if (it.hasNext())
        int e = it.next();
        int lgBloc = 1;
        res = 1;
        while (it.hasNext())
            int prec = e;
            e = it.next();
                ...
*/

public class Main {

    public static int nbBlocsMemePariteLongueurInfEgalLG(SeqInt s, int lg) {
        SeqIntIterator it = s.iterator();
        int res = 0;
        if (it.hasNext()) {
            int e = it.next();
            int lgBloc = 1;
            res = 1;
            while (it.hasNext()) {
                int prec = e;
                e = it.next();
                if (e % 2 != prec % 2) {
                    lgBloc = 1;
                    ++res;
                }
                else {
                    ++lgBloc;
                    if (lgBloc == lg + 1) {
                        --res;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SeqInt s = new SeqInt(2, 4, 1, 3, 1, 8, 6, 8, 8, 2, 4, 1, 7, 8, 8, 8, 1, 2);
        System.out.println(s);
        System.out.println("nbBlocsMemePariteLongueurInfEgalLG (lg=3) : 6 = " + nbBlocsMemePariteLongueurInfEgalLG(s, 3));
        System.out.println("nbBlocsMemePariteLongueurInfEgalLG (lg=2) : 4 = " + nbBlocsMemePariteLongueurInfEgalLG(s, 2));
        System.out.println("nbBlocsMemePariteLongueurInfEgalLG (lg=1) : 2 = " + nbBlocsMemePariteLongueurInfEgalLG(s, 1));
    }
}
