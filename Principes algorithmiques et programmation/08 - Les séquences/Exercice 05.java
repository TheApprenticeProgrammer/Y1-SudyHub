import seqint.SeqInt;
import seqint.SeqIntIterator;

/*
Écrivez une fonction qui calcule la moyenne des entiers d’une séquence. Y a-t-il un cas spécial ?
Complétez l’énoncé pour indiquer comment vous traitez ce cas. Écrivez le programme principal
pour tester votre fonction. Essayez différentes séquences.
*/

public class Main {

    public static double moyenneSeq(SeqInt s) {
        SeqIntIterator it = s.iterator();
        if (!it.hasNext()) {
            throw new RuntimeException("Erreur : moyenne d'une séquence vide !");
        }
        int somme = 0;
        int nbVal = 0;
        while (it.hasNext()) {
            somme += it.next();
            ++nbVal;
        }
        return (double) somme / nbVal;
    }

    public static void main(String[] args) {
        SeqInt s1 = new SeqInt();
        SeqInt s2 = new SeqInt(1);
        SeqInt s3 = new SeqInt(1, 2, 3, 4, 5, 7);
        System.out.println("3 = " + moyenneSeq(s3));
        System.out.println("1 = " + moyenneSeq(s2));
        System.out.println("0 = " + moyenneSeq(s1));
    }
}
