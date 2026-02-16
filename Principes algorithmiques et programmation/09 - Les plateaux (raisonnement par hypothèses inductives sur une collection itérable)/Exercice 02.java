import seqint.SeqInt;
import seqint.SeqIntIterator;

/*
Écrire une fonction qui calcule le nombre de nombre de blocs de même parité d’une séquence.

e = élément courant
prec = élément précédent
nbBlocs = nombre de blocs de même parité

prec              1 1 5 4 4 4 3 3 2 1 1 8   =>  prec = e
e               1 1 5 4 4 4 3 3 2 1 1 8 8   =>  e = it.next()
nbBlocs         1 1 1 2 2 2 3 3 4 5 5 6 6   =>  if (e % 2 != pre % 2) ++nbBlocs

Pré-Initialisation :
    int nbBlocs = 0     => si la séquence est vide renvoi zéro

Initialisation :
    if (it.hasNext())
        int e = it.next()
        nbBlocs = 1     => il y a au moins un bloc
        while (it.hasNext())
            int prec = e
            e = it.next() ...
*/

public class Main {

    public static int nbBlocs(SeqInt s) {
        SeqIntIterator it = s.iterator();
        int nbBlocs = 0;
        if (it.hasNext()) {
            int e = it.next();
            nbBlocs = 1;
            while (it.hasNext()) {
                int prec = e;
                e = it.next();
                if (e % 2 != prec % 2) {
                    ++nbBlocs;
                }
            }
        }
        return nbBlocs;
    }

    public static void main(String[] args) {
        SeqInt s1 = new SeqInt();
        SeqInt s2 = new SeqInt(1, 1, 1, 1, 1);
        SeqInt s3 = new SeqInt(1, 1, 5, 4, 4, 4, 3, 3, 2, 1, 1, 8, 8);
        System.out.println("0 = " + nbBlocs(s1));
        System.out.println("1 = " + nbBlocs(s2));
        System.out.println("6 = " + nbBlocs(s3));
    }
}

