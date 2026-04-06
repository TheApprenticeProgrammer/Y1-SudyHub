/*
Écrivez une fonction boolean inclus(String ssch, String ch) qui renvoie true si et
seulement si tous les caractères de ssch se trouvent, dans le même ordre, dans ch, mais pas
nécessairement de façon contiguë. Par exemple :
inclus("mai", "machin") => true
inclus("mai", "misérable") => false
*/

public class Main {

    public static boolean inclus(String ssch, String ch) {
        boolean end = false;
        int ctSsch = 0;
        int ctCh = 0;
        while (ctCh < ch.length() && !end) {
            if (ssch.charAt(ctSsch) == ch.charAt(ctCh)) {
                ++ctSsch;
            }
            ++ctCh;
            end = ctSsch == ssch.length();
        }
        return end;
    }

    public static boolean inclusV2(String ssch, String ch) {
        int count = 0;
        for (int i = 0; i < ch.length() && count < ssch.length(); ++i) {
            if (ssch.charAt(count) == ch.charAt(i)) {
                ++count;
            }
        }
        return count == ssch.length();
    }

    public static void main(String[] args) {
        System.out.println(inclusV2("mai", "machin"));
        System.out.println(inclusV2("mai", "misérable"));
    }
}
