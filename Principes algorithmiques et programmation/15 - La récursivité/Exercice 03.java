/*
Le nème nombre de Fibonacci est défini de la manière suivante : Si n > 2 : Fn = Fn-1 + Fn-2 avec
F1 = 1 et F2 = 1. Ecrivez une fonction récursive qui renvoie la valeur du nème nombre de Fibonacci.
Développez l'exécution de fib(5);. Combien d'additions doit effectuer votre algorithme pour
arriver au résultat ?

Si n > 2 => F(n) = f(n - 1) + f(n - 2)

Cas de base :  if (n == 1) return 0;
               if (n == 2) return 1;

f(5) = 1, 1, 2, 3, 5

return res = f(5 - 1)   +   f(5 - 2)
                => f(4 - 1)     => f(3 - 2)
                    => f(3 - 1)     => f(1) ==> cas de base
                        => f(2) ==> cas de base
*/

public class Main {

    public static int fib(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {
        System.out.println(fib(5));
    }
}
