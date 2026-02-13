import seqint.SeqInt;
import seqint.SeqIntIterator;

/*
Écrivez une fonction qui renvoie la position de la 1ère apparition d'un entier n dans une séquence.

Version du corrigé :

    // Commence en 1.
    // Renvoie 0 si val n'apparait pas dans s
    public static int posPrem(int val, SeqInt s) {
        SeqIntIterator it = s.iterator();
        int posCourante = 0;
        boolean trouve = false;             // val pas trouvé pour le moment
        while (it.hasNext() && !trouve) {   // Si on a trouvé, on s'arrête immmédiatement
            trouve = it.next() == val;      // Si élément courant == val, trouvé devient vrai
            ++posCourante;                  // On retient la position courante de l'élément
        }
        if (trouve) {                       // Si trouvé
            return posCourante;             // On retourne la position de l'élément courant
        } else {
            return 0;                       // Sinon on retourne zéro
        }
    }
*/

public class Main {

    public static int posPremApparition(SeqInt s, int val) {
        SeqIntIterator it = s.iterator();
        int res = 0;
        int posCour = 0;
        boolean find = false;
        while (it.hasNext() && !find) {
            ++posCour;
            if (it.next() == val) {
                res = posCour;
                find = true;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SeqInt s1 = new SeqInt();
        SeqInt s2 = new SeqInt(1);
        SeqInt s3 = new SeqInt(1, 1, 2, 4, 4, 5, 5, 8, 8);
        System.out.println("0 = " + posPremApparition(s1, 42));
        System.out.println("1 = " + posPremApparition(s2, 1));
        System.out.println("4 = " + posPremApparition(s3, 4) );
    }
}
