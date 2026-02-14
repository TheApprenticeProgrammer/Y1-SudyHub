import seqint.SeqInt;
import seqint.SeqIntIterator;

/*
Écrivez une fonction qui calcule les deux plus grands entiers différents entres eux d’une séquence.
*/

public class Main {

    public static SeqInt deuxMax(SeqInt s) {
        SeqIntIterator it = s.iterator();
        SeqInt result = new SeqInt();
        if (it.hasNext()) {
            int x = it.next();          // Premier élément
            if (it.hasNext()) {
                int y;
                boolean deuxDiff = false;
                do {                    // Boucle pour trouver un 2ème élément...
                    y = it.next();
                    deuxDiff = x != y;  // ... différent du 1er
                } while (it.hasNext() && !deuxDiff);
                if (deuxDiff) {
                    int max1, max2;     // Si on est ici, c'est qu'il y a deux éléments différents
                    // max1 contiendra le plus grand et max2 le deuxième max
                    if (x > y) {        // Le test sert à initialiser max1 et max2
                        max1 = x;
                        max2 = y;
                    } else {
                        max1 = y;
                        max2 = x;
                    }
                    while (it.hasNext()) {                 //  Boucle sur les éléments suivants
                        x = it.next();
                        if (x > max1) {                    // On a trouvé un nouveau max
                            max2 = max1;                   // max2 prend la valeurd de max1
                            max1 = x;                      // max1 prend la valeur du nouveau max
                        } else if (x < max1 && x > max2) { // Sinon si on trouve un élément entre max1 et max2
                            max2 = x;                      // On met à jour max2
                        }
                    }
                    result = new SeqInt(max1, max2);       // On retourne une séquence contenant max1 et max2
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        SeqInt s1 = new SeqInt(5, 2, -5, 1, 1, 2, 2, 7, -2, 7, 7, 1, 2);
        System.out.println(s1);
        System.out.print("max1 et max2 : ");
        System.out.println(deuxMax(s1) + "\n");
        SeqInt s2 = new SeqInt(7,7,7,7);
        System.out.println(s2);
        System.out.print("max1 et max2 : ");
        System.out.println(deuxMax(s2) + "\n");
    }
}
