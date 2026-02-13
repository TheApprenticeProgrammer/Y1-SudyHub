import seqint.SeqInt;
import seqint.SeqIntIterator;

/*
Écrivez une fonction qui détermine si une séquence est croissante. Qu'entendez-vous par
croissante ? Clarifiez.

Version du corrigé :

  public static boolean croissante(SeqInt s) {
        SeqIntIterator it = s.iterator();
        boolean result = true;              // Initialisé à true car si la séquence est vide, on retourne true
        if (it.hasNext()) {
            int e = it.next();              // Si un seul élément, doit retourner true
			while (it.hasNext() && result) {
				int prec = e;                  
				e = it.next();
				result = prec < e;
			}
        }
        return result;
    }
*/

public class Main {

    public static boolean estCroissante(SeqInt s) {
        SeqIntIterator it = s.iterator();
        boolean croissant = true;  // Car une séquence vide est croissante
        if (it.hasNext()) {
            int prec  = it.next();
            while (it.hasNext() && croissant) {
                int e = it.next();
                croissant = prec < e;
                prec = e;
            }
        }
        return croissant;
    }

    public static void main(String[] args) {
        SeqInt s1 = new SeqInt();
        SeqInt s2 = new SeqInt(1, 2, 5, 8, 10, 15, 20);
        SeqInt s3 = new SeqInt(8, 1, 2, 3, 4, 5);
        SeqInt s4 = new SeqInt(1, 2, 5, 8, 10, 20, 15);
        System.out.println("La séquence s1 est croissant : " + estCroissante(s1));
        System.out.println("La séquence s1 est croissant : " + estCroissante(s2));
        System.out.println("La séquence s1 est croissant : " + estCroissante(s3));
        System.out.println("La séquence s1 est croissant : " + estCroissante(s4));
    }
}
