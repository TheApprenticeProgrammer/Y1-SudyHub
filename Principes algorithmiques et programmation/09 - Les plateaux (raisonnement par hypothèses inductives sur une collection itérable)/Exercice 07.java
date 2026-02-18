import seqint.SeqInt;
import seqint.SeqIntIterator;

/*
Écrire une fonction qui calcule le nombre de blocs de même parité de longueur inférieure ou égale
à LG (donnée et supposée strictement positive).

e = élément courant
prec = élément précédent
lgBloc = longueur du bloc de même parité courant
LG = paramètre envoyé à la fonction
res = nombre de blocs de même parité de longueur inférieure ou égale à LG

prec              1 1 3 4 4 8 6 7 7 1 4 1 4 1 1 8 6     => prec = e
e               1 1 3 4 4 8 6 7 7 1 4 1 4 1 1 8 6 6     => e = it.next()
lgBloc          1 2 3 1 2 3 4 1 2 3 1 1 1 1 2 1 2 3     => if (e % 2 != prec % 2) lgBloc = 1 else ++lgBloc
LG[01]          1 0 0 1 0 0 0 1 0 0 1 2 3 4 3 4 3 3     => if (lgBloc == 1) ++res else if (lgBloc == LG + 1) --res
LG[02]          1 1 0 1 1 0 0 1 1 0 1 2 3 4 4 5 5 4     => if (lgBloc == 1) ++res else if (lgBloc == LG + 1) --res
LG[03]          1 1 1 2 2 2 1 2 2 2 3 4 5 6 6 7 7 7     => if (lgBloc == 1) ++res else if (lgBloc == LG + 1) --res

Pré-Initialisation :
    int res = 0   => retourne zéro si la séquence est vide ou si il n'y a pas de blocs de même parité de longueur
                     inférieure ou égale à LG

Initialisation :
    if (it.hasNext())
        int e = it.next()
        int lgBloc = 1
        res = 1
        while (it.hasNext())
            int prec = e
            e = it.next() ...
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
                if (e % 2 != prec % 2) {
                    lgBloc = 1;
                    ++res;
                }
                else {
                    ++lgBloc;
                    if (lgBloc == LG + 1) {
                        --res;
                    }
                }
            }
        }
        return  res;
    }

    public static void main(String[] args) {
        SeqInt s1 = new SeqInt();
        SeqInt s2 = new SeqInt(1);
        SeqInt s3 = new SeqInt(1, 1, 3, 4, 4, 8, 6, 7, 7, 1, 4, 1, 4, 1, 1, 8, 6, 6);
        System.out.println("0 = " + nbBlocsMemePariteLongueurInfEgalLG(s1, 42));
        System.out.println("1 = " + nbBlocsMemePariteLongueurInfEgalLG(s2, 1));
        System.out.println("1 = " + nbBlocsMemePariteLongueurInfEgalLG(s2, 2));
        System.out.println("3 = " + nbBlocsMemePariteLongueurInfEgalLG(s3, 1));
        System.out.println("4 = " + nbBlocsMemePariteLongueurInfEgalLG(s3, 2));
        System.out.println("7 = " + nbBlocsMemePariteLongueurInfEgalLG(s3, 3));
    }
}
