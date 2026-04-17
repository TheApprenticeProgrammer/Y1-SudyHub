import eu.epfc.prm.Array;
import java.util.Scanner;

public class Main {

    /*
Question 1 :

Partie 1 :
public static void saisie(Date d) qui complète la Date donnée en demandant à
l’utilisateur le jour, le mois et l’année. On supposera, sans le vérifier, que la date rentrée
est valide.
*/
    public static void saisie(Date d) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Création d'une nouvelle date :");
        System.out.println("Entrer le jour : ");
        d.jour = scan.nextInt();
        System.out.println("Entrer le mois : ");
        d.mois = scan.nextInt();
        System.out.println("Entrer l'année : ");
        d.annee = scan.nextInt();
    }

/*
Partie 2 :
public static void saisie(Personne p) qui complète la Personne donnée en
demandant à l’utilisateur son nom, son prénom et sa date de naissance. On supposera que
le nom et le prénom d’une personne ne contienne qu’un seul mot.
*/
    public static void saisie(Personne p) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Création d'une nouvelle personne : ");
        System.out.println("Entrer le nom : ");
        p.nom = scan.nextLine();
        System.out.println("Entrer le prénom : ");
        p.prenom = scan.nextLine();
        p.ddn = new Date();
        saisie(p.ddn);
    }

/*
Partie 3 :
public static void affiche(Date d) qui affiche la Date donnée
*/
    public static void affiche(Date d) {
        System.out.println(d.jour + "/" + d.mois + "/" + d.annee);
    }

/*
Partie 4 :
public static void affiche(Personne p) qui affiche le nom, le prénom et la date de
naissance de la Personne donnée.
*/
    public static void affiche(Personne p) {
        System.out.println("Nom : " + p.nom);
        System.out.println("Prénom : " + p.prenom);
        affiche(p.ddn);
    }

/*
Partie 5 :
public static int compare(Date d1, Date d2) qui compare deux Dates. Celle-ci
renverra un entier positif (quelconque) si d1 est plus « grand » que d2, négatif si d1 est
plus « petit » que d2 et 0 si d1 et d2 sont égales. Que signifie qu’une Date est plus grande
qu’une autre ?
*/
    public static int compare(Date d1, Date d2) {
        int cmp = Integer.compare(d1.annee, d2.annee);
        if (cmp == 0) {
            cmp = Integer.compare(d1.mois, d2.mois);
            if (cmp == 0) {
                cmp = Integer.compare(d1.jour, d2.jour);
            }
        }
        return cmp;
    }

    public static int compareV2(Date d1, Date d2) {
        return (10000 * d1.annee + 100 * d1.mois + d1.jour) - (10000 * d2.annee + 100 * d2.mois + d2.jour);
    }

/*
Partie 6 :
public static int compareAge(Personne p1, Personne p2) qui compare deux
Personnes selon leur âge (en jours). Elle renverra un positif si p1 est plus agé que p2, un
négatif si p2 est plus agé que p1 et 0 si les deux Personnes sont nées le même jour.
*/
    public static int compareAge(Personne p1, Personne p2) {
        return -(compare(p1.ddn, p2.ddn));
    }

/*
Partie 7 :
public static int compareNomPrenom(Personne p1, Personne p2) qui compare
deux Personnes selon l’ordre alphabétique de leur nom et de leur prénom.
*/
    public static int compareNomPrenom(Personne p1, Personne p2) {
        int cmp = p1.nom.compareTo(p2.nom);
        if (cmp == 0) {
            cmp = p1.prenom.compareTo(p2.prenom);
        }
        return cmp;
    }

/*
Question 2 :
Complétez votre programme afin qu’il demande à l’utilisateur d’entrer une série de n Personnes
(la valeur de n'est indiquée au préalable par l’utilisateur), les range dans un tableau et les affiche.
*/
    public static void saisie(Array<Personne> tab) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Combien de nouvelles personnes voulez-vous créer ? :");
        int nbrPersonne = scan.nextInt();
        if (nbrPersonne < 1) {
            throw new RuntimeException("Nombre invalide");
        }
        for (int i = 0; i < nbrPersonne; ++i) {
            Personne p = new Personne();
            saisie(p);
            tab.add(p);
        }
    }

    public static void affiche(Array<Personne> tab) {
        for (int i = 0; i < tab.size(); ++i) {
            affiche(tab.get(i));
        }
    }

    public static void question2() {
        Array<Personne> tab = new Array<>();
        saisie(tab);
        affiche(tab);
    }

/*
Question 03 :
Complétez votre programme pour afficher la personne la plus jeune du tableau. Utilisez pour cela
votre fonction compareAge.
*/
    public static void personneLaPlusJeuneDuTableau(Array<Personne> tab) {
        int indexPersonneLaPlusJeune = 0;
        for (int i = 1; i < tab.size(); ++i) {
            if (compareAge(tab.get(indexPersonneLaPlusJeune), tab.get(i)) > 0) {
                indexPersonneLaPlusJeune = i;
            }
        }
        System.out.println("La personne la plus jeune du tableau est :");
        affiche(tab.get(indexPersonneLaPlusJeune));
    }

    public static void question3() {
        Array<Personne> tab = new Array<>();
        saisie(tab);
        personneLaPlusJeuneDuTableau(tab);
    }

    public static void main() {
        question2();
        question3();
    }
}
