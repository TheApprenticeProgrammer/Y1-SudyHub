import seqint.SeqInt;
import seqint.SeqIntIterator;

/*
Écrire une fonction qui calcule le nombre de blocs de même parité de longueur inférieure ou égale
à LG (donnée et supposée strictement positive).

e = élément courant
prec = élément précédent
lgBloc = longueur du bloc de même parité courant
LG = paramètre fourni à la fonction
res = nombre de blocs de longueur inférieure ou égale à LG

prec              2 4 1 3 1 8 6 8 8 2 4 1 7 8 8 8 1     =>  prec = e
e               2 4 1 3 1 8 6 8 8 2 4 1 7 8 8 8 1 2     =>  if (it.hasNext()) e = it.next()
lgBloc          1 2 1 2 3 1 2 3 4 5 6 1 2 1 2 3 1 1     =>  if (e % 2 == prec % 2) ++lgBloc else lgBloc = 1
LG[03]          1 1 2 2 2 3 3 3 2 2 2 3 3 4 4 4 5 6     =>  if (lgBloc == 1) ++res else if (lgBloc == (LG + 1)) --res
LG[02]          1 1 2 2 1 2 2 1 1 1 1 2 2 3 3 2 3 4     =>  if (lgBloc == 1) ++res else if (lgBloc == (LG + 1)) --res
LG[01]          1 0 1 0 0 1 0 0 0 0 0 1 0 1 0 0 1 2     =>  if (lgBloc == 1) ++res else if (lgBloc == (LG + 1)) --res

Pré-Initialisation :
    int res = 0

Inititialisation :
    int e = it.next()
    int lgBloc = 1
    res = 1
 */


public class Main {

    public static int nbBlocsMemePariteLongueurInfEgalLG(SeqInt s, int LG) {
        SeqIntIterator it = s.iterator();
        int res = 0;
        if (it.hasNext()) {
            int e = it.next();
            int lgBloc = 1;
            res = 1;
            while (it.hasNext()) {
                int prec = e;
                e = it.next();
                if (e % 2 == prec % 2) {
                    ++lgBloc;
                }
                else {
                    lgBloc = 1;
                }
                if (lgBloc == 1) {
                    ++res;
                }
                else if (lgBloc == (LG + 1)){
                    --res;
                }
            }
        }
        return res;
    }
    
/*
    Il est à noter que la fonction "nbBlocsMemePariteLongueurInfEgalLG" peut être re-factorisée comme ceci :

    public static int nbBlocsMemePariteLongueurInfEgalLG2(SeqInt s, int LG) {
        SeqIntIterator it = s.iterator();
        int res = 0;
        if (it.hasNext()) {
            int e = it.next();
            int lgBloc = 1;
            res = 1;
            while (it.hasNext()) {
                int prec = e;
                e = it.next();
                if (e % 2 == prec % 2) {
                    ++lgBloc;
                    if (lgBloc == (LG +1)) {
                        --res;
                    }
                }
                else {
                    lgBloc = 1;
                    ++res;
                }
            }
        }
        return res;
    }
*/

    public static void main(String[] args) {
        SeqInt s = new SeqInt(2, 4, 1, 3, 1, 8, 6, 8, 8, 2, 4, 1, 7, 8, 8, 8, 1, 2);
        System.out.println(s);
        System.out.println("nbBlocsMemePariteLongueurInfEgalLG (lg=3) : 6 = " + nbBlocsMemePariteLongueurInfEgalLG(s, 3));
        System.out.println("nbBlocsMemePariteLongueurInfEgalLG (lg=2) : 4 = " + nbBlocsMemePariteLongueurInfEgalLG(s, 2));
        System.out.println("nbBlocsMemePariteLongueurInfEgalLG (lg=1) : 2 = " + nbBlocsMemePariteLongueurInfEgalLG(s, 1));
    }


}
