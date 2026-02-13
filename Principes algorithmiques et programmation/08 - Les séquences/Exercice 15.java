import seqint.SeqInt;
import seqint.SeqIntIterator;

/*
Écrivez une fonction qui détermine, à la fois, le maximum et minimum d'une séquence
*/

public class Main {

    public static SeqInt minAndMax(SeqInt s) {
        SeqIntIterator it = s.iterator();
        if (!it.hasNext()) {
            throw new RuntimeException("Erreur : séquence vide !");
        }
        int min = it.next();
        int max = min;
        while (it.hasNext()) {
            int e = it.next();
            if (e > max) {
                max = e;
            }
            else if (e < min) {
                min = e;
            }
        }
        return new SeqInt (min, max);
    }

    public static void main(String[] args) {
        SeqInt s1 = new SeqInt(5, 2, -5, 1, 1, 2, 2, 7, -2, 7, 7, 1, 2);
        System.out.println(s1);
        System.out.print("min et max : ");
        System.out.println(minAndMax(s1));
        SeqInt s2 = new SeqInt(1, 2, 7, 15, 122);
        System.out.println(s2);
        System.out.print("min et max : ");
        System.out.println(minAndMax(s2));
        SeqInt s3 = new SeqInt();
        System.out.println(s3);
        System.out.print("min et max : ");
        System.out.println(minAndMax(s3));
    }
}
