import seqint.SeqInt;
import seqint.SeqIntIterator;

/*
Écrivez une fonction qui trouve le plus grand des négatifs d'une séquence. Pensez aux cas
spéciaux. Documentez votre choix dans ces cas.

Version du corrigé :
  
  public static int maxNeg(SeqInt s) {
        SeqIntIterator it = s.iterator();
        int result = 0;                            // Initialisation : si aucun négatif, on retourne zéro
        boolean trouveNegatif = false;
        while (it.hasNext() && !trouveNegatif) {   // Boucle pour trouver un premier négatif (s'il y en a)
            int x = it.next();
            trouveNegatif = x < 0;
            if (trouveNegatif) {                   // Si on a trouvé un négatif
                result = x;                        // C'est le maximum actuel
            }
        }
        while (it.hasNext()) {                     // Boucle sur les éléments restants 
            int x = it.next();
            if (x < 0 && x > result) {             // Si le nouvel élément est négatif et plus grand que result
                result = x;                        // On met à jour result   
            }
        }
        return result;
    }
*/

public class Main {

    public static int biggestNegative(SeqInt s) {
        SeqIntIterator it = s.iterator();
        int res = 0;
        boolean findNegative = false;
        while (it.hasNext() && !findNegative) {
            int e = it.next();
            if (e < 0) {
                res = e;
                findNegative = true;
            }
        }
        while (it.hasNext()) {
            int e = it.next();
            if (e > res && e < 0) {
                res = e;
            }
        }
        return res;
    }

    public static void main(String[] agrs) {
        SeqInt s1 = new SeqInt();
        SeqInt s2 = new SeqInt(1);
        SeqInt s3 = new SeqInt(1, 2, -8, 5, -4, 0, -2, 1);
        SeqInt s4 = new SeqInt(-1, -2, -3, 4);
        System.out.println("0 = " + biggestNegative(s1));
        System.out.println("0 = " + biggestNegative(s2));
        System.out.println("-2 = " + biggestNegative(s3));
        System.out.println("-1 = " + biggestNegative(s4));
    }
}
