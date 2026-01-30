import seqint.SeqInt;
import seqint.SeqIntIterator;

/*
Écrivez une fonction booléenne qui détermine si une séquence est vide.

Version du professeur :

    public static boolean estVide(SeqInt s) {
        SeqIntIterator it = s.iterator();
        return !it.hasNext();
    }
*/

public class Main {

    public static boolean estVide(SeqInt s) {
        SeqIntIterator it = s.iterator();
        boolean estVide = true;
        if (it.hasNext()) {
           estVide = false;
        }
        return estVide;
    }

    public static void main(String[] args) {
        SeqInt s1 = new SeqInt();
        if (estVide(s1)) {
            System.out.println("Cette séquence est vide.");
        }
        else {
            System.out.println("Cette séquence n'est pas vide.");
        }
        SeqInt s2 = new SeqInt(1, 2, 3, 4, 5);
        if (estVide(s2)) {
            System.out.println("Cette séquence est vide.");
        }
        else {
            System.out.println("Cette séquence n'est pas vide.");
        }
    }
}
