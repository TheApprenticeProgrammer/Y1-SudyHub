/*
Pour chacun des cas suivants, décrivez l’effet d’un appel de mystere(5);
*/

public class Main {
/*
    public static void mystere(int n) {
        if(n >= 1) {
            mystere(n - 1);
            System.out.println(n);
        }
    }

if (5 >= 1) => mystere(5 - 1) \
                               \ => if (4 >= 1) => mystere(4 - 1) \
                               /                                   \ => if (3 >= 1) => mystere(3 - 1) \
                              /                                    /                                   \ => if (2 >= 1) => mystere(2 - 1) \
                             /                                    /                                    /                                   \ => if (1 >= 1) => mystere(1 - 1) \
                            /                                    /                                    /                                    /                                   \ => if (0 >= 1) => STOP
                           /                                    /                                    /                                    /                             sout(1)/
                          /                                    /                                    /                             sout(2)/
                         /                                    /                             sout(3)/
                        /                             sout(4)/
                sout(5)/
*/
/*
    public static void mystere(int n) {
        if (n >= 1) {
            System.out.println(n);
            mystere(n - 1);
        }
    }

if (5 >= 1) => sout(5) => mystere(5 - 1) \
                                          \ if (4 >= 1) => sout(4) => mystere(4 - 1) \
                                                                                      \ if (3 >= 1) => sout(3) => mystere(3 - 1) \
                                                                                                                                  \ if (2 >= 1) => sout(2) => mystere(2 - 1) \
                                                                                                                                                                              \ if (1 >= 1) => sout(1) => mystere(1 - 1) \
                                                                                                                                                                                                                          \ if (0 >= 1) => STOP
*/
/*
    public static void mystere(int n) {
        if (n >= 1) {
            System.out.println(n);
            mystere(n + 1);
        }
    }

if (5 >= 1) => sout(5) => mystere(5 + 1) \
                                          \ if (6 >= 1) => sout(6) => mystere(6 + 1) \
                                                                                      \ if (7 >= 1) => sout(7) => mystere(7 + 1) \
                                                                                                                                  \ ... => StackOverFlow
*/
/*
    public static void mystere(int n) {
        if (n >= 1) {
            mystere(n + 1);
            System.out.println(n);
        }
    }

if (5 >= 1) => mystere(5 + 1) \
                               \ if (6 >= 1) => mystere(6 + 1) \
                                                                \ if (7 >= 1) => mystere(7 + 1) \
                                                                                                 \ ... => StackOverFlow
*/
    public static void main(String[] args) {
        mystere(5);
    }
}

