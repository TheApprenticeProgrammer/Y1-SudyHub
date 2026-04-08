public class Main {

    public static int compare(String ch1, String ch2) {
        int lg = Math.min(ch1.length(), ch2.length());
        int cnt = 0;
        // On avance tant que les caractères sont identiques
        while (cnt < lg && ch1.charAt(cnt) == ch2.charAt(cnt)) {
            cnt++;
        }
        if (cnt < lg) {
            // Une première différence a été trouvée
            return ch1.charAt(cnt) - ch2.charAt(cnt);
        } else {
            // Aucun caractère différent sur la longueur minimale
            return ch1.length() - ch2.length();
        }
    }

    public static int compareV2(String ch1, String ch2) {
        int lg = Math.min(ch1.length(), ch2.length());
        for (int i = 0; i < lg; i++) {
            if (ch1.charAt(i) != ch2.charAt(i)) {
                return ch1.charAt(i) - ch2.charAt(i);
            }
        }
        return ch1.length() - ch2.length();
    }

    public static void main(String[] args) {
        String s1 = "Hello World";
        String s2 = "Hello Worlde";
        String s3 = "Hello World";
        String s4 = "Hello Worlde";

        System.out.println(compare(s1, s2));
        System.out.println(compare(s2, s1));
        System.out.println(compare(s1, s3));
        System.out.println(compare(s2, s4));

        System.out.println(compareV2(s1, s2));
        System.out.println(compareV2(s2, s1));
        System.out.println(compareV2(s1, s3));
        System.out.println(compareV2(s2, s4));
    }
}
