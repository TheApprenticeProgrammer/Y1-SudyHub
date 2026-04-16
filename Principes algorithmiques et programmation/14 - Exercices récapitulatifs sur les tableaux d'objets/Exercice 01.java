import eu.epfc.prm.Array;

public class Main {

    public static void affiche(Array<String> texte) {
        for (String s : texte) {
            System.out.println(s);
        }
        System.out.println("===========================================");
    }

    public static boolean hasPoint(String s) {
        return s.charAt(s.length() - 1) == '.';
    }

    public static int nombrePoints(Array<String> texte) {
        int res = 0;
        for (int i = 0; i < texte.size(); ++i) {
            if (hasPoint(texte.get(i))) {
                ++res;
            }
        }
        return res;
    }

    public static void separerParagraphes(Array<String> texte) {
        int nbrPoints = nombrePoints(texte);
        int oldSize = texte.size() - 1;
        texte.extend(nbrPoints, "");
        int newSize = texte.size() - 1;
        while (nbrPoints > 0) {
            if (hasPoint(texte.get(oldSize))) {
                texte.set(newSize, "");
                --newSize;
                texte.set(newSize, texte.get(oldSize));
                --nbrPoints;
            }
            else {
                texte.set(newSize, texte.get(oldSize));
            }
            --newSize;
            --oldSize;
        }
    }

    public static void main(String[] args) {
        Array<String> texte = new Array<>(
                "Question 4) Imaginons qu'un texte soit memorise",
                "dans un tableau de strings. Chaque string du",
                "tableau correspond a une ligne du texte.",
                "Les traitements de texte disposent en general d'une fonctionnalite",
                "qui, pour ameliorer la lisibilite, insere de l'espace vertical",
                "entre deux paragraphes. Pour nos besoins, la fin d'un paragraphe",
                "sera definie comme une ligne se terminant par un point ('.').",
                "Ecrivez une fonction separerParagraphes(Array<String> texte)",
                "qui recoit un Array de String et qui insere un string vide",
                "apres chaque string se terminant par un point.");
        affiche(texte);
        separerParagraphes(texte);
        affiche(texte);
    }
}
