import seqint.SeqInt;
import seqint.SeqIntIterator;

/*

res = 0

prec        1 1 8 8 0 6 5 5 / prec = e
e         1 1 8 8 0 6 5 5 5 / if (it.hasNext())
res     0 1 1 2 2 3 4 5 5 5 / if (e != prec) ++res

 */

public class Main {

    public static int nombrePlateaux(SeqInt s) {

        SeqIntIterator it = s.iterator();

        int res = 0;
        if (it.hasNext()) {
            int e = it.next();
            res = 1;
            while (it.hasNext()) {
                int prec = e;
                e = it.next();
                if (e != prec) {
                    ++res;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {

        System.out.println("Zone de test : ");
        SeqInt s1 = new SeqInt();
        System.out.println("0 = " + nombrePlateaux(s1));
        SeqInt s2 = new SeqInt(1);
        System.out.println("1 = " + nombrePlateaux(s2));
        SeqInt s3 = new SeqInt(1, 1, 8, 8, 0, 6, 5, 5, 5);
        System.out.println("5 = " + nombrePlateaux(s3));
    }
}
