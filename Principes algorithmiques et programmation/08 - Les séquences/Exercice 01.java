import seqint.SeqInt;
import seqint.SeqIntIterator;

/*
Écrivez une fonction booléenne qui détermine si une séquence est vide.

Version du corrigé :

    public static boolean estVide(SeqInt s) {
        SeqIntIterator it = s.iterator();
        return !it.hasNext(); // it.hasNext() renvoie false si il n'y a plus de valeur après la position de l'itérateur
    }
*/

public class Main {

    public static boolean estVide(SeqInt s) {
        SeqIntIterator it = s.iterator();
        boolean vide = true;
        if (it.hasNext()) {
            vide = false;
        }
        return vide;
    }

    public static void main(String[] args) {
        SeqInt s1 = new SeqInt();
        SeqInt s2 = new SeqInt(1, 2, 3, 4, 5);
        System.out.println("s1 est vide : " + estVide(s1));
        System.out.println("s2 est vide : " + estVide(s2));
    }
}
