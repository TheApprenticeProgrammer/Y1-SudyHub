import seqint.SeqInt;
import seqint.SeqIntIterator;

/*
Écrire une fonction qui reçoit une séquence d’entiers et qui vérifie si elle contient uniquement des
plateaux de longueur strictement croissante. Autrement dit, chaque plateau, hormis le premier,
doit avoir une longueur strictement plus grande que celle du plateau précédent.

Remarque : on considère qu'une séquence vide ne répond pas à cette condition, mais qu'une
séquence composée d'un seul plateau y répond.

Ajoutez un invariant qui permet d'arrêter le parcours de la séquence dès que possible

prec              1 2 2 3 3 3 4 4 4 4 5 5 5 5   =>  int prec = e;
e               1 2 2 3 3 3 4 4 4 4 5 5 5 5 5   =>  int e = it.next();
lgPlatCour      1 1 2 1 2 3 1 2 3 4 1 2 3 4 5   =>  if (e != prec) lgPlatPrec = lgPlatCour; lgPlatCour = 1; else ++lgPlatCour
lgPlatPrec    0 0 1 1 2 2 2 3 3 3 3 4 4 4 4 4   =>  if (e != prec) lgPlatPrec = lgPlatCour; lgPlatCour = 1; else ++lgPlatCour
estCrsst      f t f t f f t f f f t f f f f t   =>  estCrsst = lgPlatPrec < lgPlatCour;

prec              1 2 2 3 3 3 4 4 4 4 4 5 5 5   =>  int prec = e;
e               1 2 2 3 3 3 4 4 4 4 4 5 5 5 5   =>  int e = it.next();
lgPlatCour      1 1 2 1 2 3 1 2 3 4 5 1 2 3 4   =>  if (e != prec) lgPlatPrec = lgPlatCour; lgPlatCour = 1; else ++lgPlatCour
lgPlatPrec    0 0 1 1 2 2 2 3 3 3 3 3 5 5 5 5   =>  if (e != prec) lgPlatPrec = lgPlatCour; lgPlatCour = 1; else ++lgPlatCour
estCrsst      f t f t f f t f f f t t f f f f   =>  estCrsst = lgPlatPrec < lgPlatCour;

Pré-Initialisation :
    SeqIntIterator it = s.iterator();
    boolean estCrsst = false;
    return estCrsst;

Initialisation :
    if (it.hasNext())
        int e = it.next();
        int lgPlatCour = 1;
        estCrsst = true;
        while (it.hasNext())
            int prec = e;
            e = it.next();
                ...
*/

public class Main {

    public static boolean estCroissantV2(SeqInt s) {
        SeqIntIterator it = s.iterator();
        boolean estCrsst = false;
        if (it.hasNext()) {
            int e = it.next();
            int lgPlatPrec = 0;
            int lgPlatCour = 1;
            estCrsst = true;
            while (it.hasNext() && estCrsst) {
                int prec = e;
                e = it.next();
                if (e != prec) {
                    estCrsst = lgPlatPrec < lgPlatCour;
                    lgPlatPrec = lgPlatCour;
                    lgPlatCour = 1;
                }
                else {
                    ++lgPlatCour;
                }
            }
            if (estCrsst) {
                estCrsst = lgPlatPrec < lgPlatCour;
            }
        }
        return estCrsst;
    }

    public static boolean estCroissant(SeqInt s) {
        SeqIntIterator it = s.iterator();
        boolean estCrsst = false;
        if (it.hasNext()) {
            int e = it.next();
            int lgPlatPrec = 0;
            int lgPlatCour = 1;
            boolean stop = false;
            estCrsst = true;
            while (it.hasNext() && !stop) {
                int prec = e;
                e = it.next();
                if (e != prec) {
                    lgPlatPrec = lgPlatCour;
                    lgPlatCour = 1;
                    if (!estCrsst) {
                        stop = true;
                    }
                }
                else {
                    ++lgPlatCour;
                }
                estCrsst = lgPlatPrec < lgPlatCour;
            }
        }
        return estCrsst;
    }

    public static void main(String[] args) {
        SeqInt s = new SeqInt();
        System.out.println(s);
        System.out.println(estCroissant(s));

        s = new SeqInt(5);
        System.out.println(s);
        System.out.println(estCroissant(s));

        s = new SeqInt(5, 5);
        System.out.println(s);
        System.out.println(estCroissant(s));

        s = new SeqInt(5, 1);
        System.out.println(s);
        System.out.println(estCroissant(s));

        s = new SeqInt(5, 1, 1, 1, 2, 3, 3);
        System.out.println(s);
        System.out.println(estCroissant(s));

        s = new SeqInt(5, 1, 1, 1, 2);
        System.out.println(s);
        System.out.println(estCroissant(s));

        s = new SeqInt(5, 1, 1, 1);
        System.out.println(s);
        System.out.println(estCroissant(s));

        s = new SeqInt(5, 5, 1, 1, 1);
        System.out.println(s);
        System.out.println(estCroissant(s));

        s = new SeqInt(5, 1, 1, 3, 3, 3, 4, 4, 4, 4, 4);
        System.out.println(s);
        System.out.println(estCroissant(s));

        s = new SeqInt(5, 1, 1, 3, 3, 4, 4, 4, 4, 4, 4);
        System.out.println(s);
        System.out.println(estCroissant(s));
    }
}
