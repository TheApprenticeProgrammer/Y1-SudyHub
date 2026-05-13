import eu.epfc.prm.Array;
/*
Algorithme de tri par sélection

5       9       1       3       4
<-----------non trié------------>

1er étape : chercher le minimum parmi les éléments non triés
5       9       1       3       4
                \ => minimum

2ieme étape : placer le minimum à sa position définitive
1       9       5       3       4
<-trié-><-------non trié-------->

3ieme étape : rechercher le minimum parmis les éléments non triés
1       9       5       3       4
                        \ => minimum

4ieme étape : placer le nouveau minimum à sa position définitive
1       3       5       9       4
<-----trié-----><---non trié---->
    ...
Nieme étape : placer le dernier minimum à sa position définitive
1       3       4       5       9
<-------------trié-------------->
*/

public class Main {

    public static int posMinList(Array<Integer> unorderedList, int write) {
        int res = 0;
        if (unorderedList.isEmpty()) {
            throw new RuntimeException("Empty list !");
        }
        else {
            int min = unorderedList.get(write);
            for (int i = write + 1; i < unorderedList.size(); ++i) {
                if (min > unorderedList.get(i)) {
                    res = i;
                    min = unorderedList.get(i);
                }
            }
        }
        return res;
    }

    public static void switchMin(Array<Integer> unorderedList, int posMin, int write) {
        int save = unorderedList.get(write);
        unorderedList.set(write, unorderedList.get(posMin));
        unorderedList.set(posMin, save);
    }

    public static void main(String[] args) {
        int write = 0;
        System.out.println("Liste non-ordonnée :");
        Array<Integer> unorderedList = new Array<>(5, 9, 1, 3, 4);
        System.out.println(unorderedList);
        // Step one :
        int posMin = posMinList(unorderedList, write);
        // Step two :
        switchMin(unorderedList, posMin, write);
        ++write;
        // Step three :
        posMin = posMinList(unorderedList, write);
        // Step four :
        switchMin(unorderedList, posMin, write);
        ++write;
        // Step five :
        posMin = posMinList(unorderedList, write);
        // Step six :
        switchMin(unorderedList, posMin, write);
        ++write;
        // Step seven :
        posMin = posMinList(unorderedList, write);
        // Step eight :
        switchMin(unorderedList, posMin, write);
        System.out.println("Liste ordonnée");
        System.out.println(unorderedList);
    }
}
