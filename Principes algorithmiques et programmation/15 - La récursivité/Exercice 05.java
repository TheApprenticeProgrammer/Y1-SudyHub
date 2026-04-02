/*
Servez-vous du fait que, par exemple, x exposant 24 = (x * x) exposant 12 pour diminuer dramatiquement le nombre de
multiplications et d'appels récursifs dans la solution de l'exercice précédent. Combien de
multiplication doit effectuer votre algorithme pour calculer 2 exposant 24 ? Combien en
faut-il pour 2 exposant 1000 ?
Comparez avec celui de la question précédente.

Cas de base : if (n == 0) return 1;
              if (n % 2 == 0) return exp(a * a, n / 2)
*/

public class Main {

    public static int exp(int a, int n) {
        if (n == 0) {
            return 1;
        }
        if (n % 2 == 0) {
            return exp(a * a, n / 2);
        }
        return a * exp(a, n - 1);
    }

    public static void main(String[] args) {
        System.out.println(exp(2, 24));
    }
}
