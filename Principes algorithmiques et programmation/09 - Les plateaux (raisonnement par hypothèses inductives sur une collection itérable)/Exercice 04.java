import seqint.SeqInt;
import seqint.SeqIntIterator;

/*
Écrire une fonction qui calcule le nombre de plateaux qui suivent la dernière occurrence du
maximum.

e = élément courant
prec = élément précédent
max = maximum courant
res = nombre de plateaux depuis la dernière occurrence du maximum

prec              5 2 1 1 1 2 2 5 3 3 7 1 1     => prec = e
-------------------------------------------
e               5 2 1 1 1 2 2 5 3 3 7 1 1 2     => if (it.hasNext()) e = it.next()
-------------------------------------------
max             5 5 5 5 5 5 5 5 5 5 7 7 7 7     => if (e > max) max = e
-------------------------------------------
res             0 1 2 2 2 3 3 0 1 1 0 1 1 2     => if (e >= max) res = 0 else if (prec != e) ++res

Pré-initialisation :
    int res = 0
 */

public class Main {

    public static int nbPlateauxApresDernierMax(SeqInt s) {
        SeqIntIterator it = s.iterator();
        int res = 0;
        if (it.hasNext()) {
            int e = it.next();
            int max = e;
            while (it.hasNext()) {
                int prec = e;
                e = it.next();
                if (e > max) {
                    max = e;
                }
                if (e >= max) {
                    res = 0;
                }
                else if (e != prec) {
                    ++res;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SeqInt sVide = new SeqInt();
        System.out.println(sVide);
        System.out.println("nbPlateauxApresDernierMax : 0 = " + nbPlateauxApresDernierMax(sVide));
        System.out.println();

        SeqInt s1 = new SeqInt(5, 2, 1, 1, 1, 2, 2, 5, 3, 3, 7, 1, 1, 2);
        System.out.println(s1);
        System.out.println("nbPlateauxApresDernierMax : 2 = " + nbPlateauxApresDernierMax(s1));
        System.out.println();

        SeqInt s2 = new SeqInt(5, 2, 1, 1, 1, 2, 2, 5, 3, 3, 7, 1, 1, 7);
        System.out.println(s2);
        System.out.println("nbPlateauxApresDernierMax : 0 = " + nbPlateauxApresDernierMax(s2));
        System.out.println();
    }
}

/*
Cette version peut être légèrement améliorée en fusionnent le "if (e > max)" et le "if (e >= max)" :

   public static int nbPlateauxApresDernierMax(SeqInt s) {
        SeqIntIterator it = s.iterator();
        int res = 0;
        if (it.hasNext()) {
            int e = it.next();
            int max = e;
            while (it.hasNext()) {
                int prec = e;
                e = it.next();
                if (e >= max) {
                    max = e;
                    res = 0;
                }
                else if (e != prec) {
                    ++res;
                }
            }
        }
        return res;
    }
 */
