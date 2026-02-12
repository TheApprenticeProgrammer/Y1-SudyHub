import seqint.SeqInt;
import seqint.SeqIntIterator;

/*
Écrivez une fonction qui renvoie la position de la dernière apparition d'un entier n dans une
séquence. Quelle valeur renvoyez-vous si n n'apparaît pas dans la séquence ?
*/

public class Main {

    public static int posDernApparition(SeqInt s, int val) {
        SeqIntIterator it = s.iterator();
        int res = 0;
        int posCour = 0;
        while (it.hasNext()) {
            int e = it.next();
            ++posCour;
            if (e == val) {
                res = posCour;
            }
        }
        return res;
    }

    public static void main(String[] ars) {
        SeqInt s1 = new SeqInt();
        SeqInt s2 = new SeqInt(1);
        SeqInt s3 = new SeqInt(8, 1, 1, 2, 2, 4, 5, 8);
        System.out.println("0 = " + posDernApparition(s1, 42));
        System.out.println("1 = " + posDernApparition(s2, 1));
        System.out.println("8 = " + posDernApparition(s3, 8));
        System.out.println("0 = " + posDernApparition(s3, 25));
    }
}
