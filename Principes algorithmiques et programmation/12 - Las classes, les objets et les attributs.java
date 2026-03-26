import java.util.Scanner;

/*
Exercice 01 :
Écrivez un programme qui demande à l’utilisateur de faire la saisie au clavier de deux Personnes,
les réaffiche à l’écran, et détermine laquelle est la plus âgée et laquelle précède l’autre dans le
bottin.
Il est important de bien modulariser votre solution : utilisez des fonctions pour chaque opération
identifiable. Écrivez donc, au minimum, les fonctions suivantes :
*/

public class Main {

/*
Partie 01 :
public static void saisie(Date d) qui complète la Date donnée en demandant à
l’utilisateur le jour, le mois et l’année. On supposera, sans le vérifier, que la date rentrée
est valide.
*/
    public static void saisie(Date d) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Veuillez entrer le jour : ");
        d.jour = scan.nextInt();
        System.out.println();
        System.out.print("Veuillez entrer le mois : ");
        d.mois = scan.nextInt();
        System.out.println();
        System.out.print("Veuillez entrer l'année : ");
        d.annee = scan.nextInt();
        System.out.println();
    }

/*
Partie 2 :
public static void saisie(Personne p) qui complète la Personne donnée en
demandant à l’utilisateur son nom, son prénom et sa date de naissance. On supposera que
le nom et le prénom d’une personne ne contiennent qu’un seul mot.
*/
    public static void saisie(Personne p) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Veuillez entrer le nom : ");
        p.nom = scan.nextLine();
        System.out.println();
        System.out.print("Veuillez entrer le prénom : ");
        p.prenom = scan.nextLine();
        System.out.println();
        p.ddn = new Date();
        saisie(p.ddn);
    }

/*
Partie 03 :
public static void affiche(Date d) qui affiche la Date donnée.
*/
    public static void affiche(Date d) {
        System.out.print(d.jour + "/" + d.mois + "/" + d.annee);
        System.out.println();
    }

/*
Partie 04 :
public static void affiche(Personne p) qui affiche le nom, le prénom et la date de
naissance de la Personne donnée.
*/
    public static void affiche(Personne p) {
        System.out.println("Nom : " + p.nom);
        System.out.println("Prénom : " + p.prenom);
        System.out.print("Date de naissance : ");
        affiche(p.ddn);
        System.out.println();
    }

/*
Partie 05 :
public static int compare(Date d1, Date d2) qui compare deux Dates. Celle-ci
renverra un entier positif (quelconque) si d1 est plus « grand » que d2, négatif si d1 est
plus « petit » que d2 et 0 si d1 et d2 sont égales. Que signifie qu’une Date est plus grande
qu’une autre ?

Autre version du corrigé :
    public static int compare2(Date d1, Date d2) {
        return (d1.annee * 10000 + d1.mois * 100 + d1.jour) - (d2.annee * 10000 + d2.mois * 100 + d2.jour);
    }


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

/*
Partie 06 :
public static int compareAge(Personne p1, Personne p2) qui compare deux
Personnes selon leur âge (en jours). Elle renverra un positif si p1 est plus agé que p2, un
négatif si p2 est plus agé que p1 et 0 si les deux Personnes sont nées le même jour.
*/
    public static int compareAge(Personne p1, Personne p2) {
        return -compare(p1.ddn, p2.ddn);
    }

/*
Partie 07 :
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

    public static void main(String[] args) {
        Personne p1 = new Personne();
        saisie(p1);
        Personne p2 = new Personne();
        saisie(p2);
        affiche(p1);
        affiche(p2);
        if (compareAge(p1, p2) > 0) {
            System.out.println(p1.nom + " " + p1.prenom + " est plus vieux que " + p2.nom + " " + p2.prenom);
        }
        else if (compareAge(p1, p2) < 0) {
            System.out.println(p2.nom + " " + p2.prenom + " est plus vieux que " + p1.nom + " " + p1.prenom);
        }
        else {
            System.out.println("Ils ont le même age !");
        }
        if (compareNomPrenom(p1, p2) > 0) {
            System.out.println(p2.nom + " " + p2.prenom + " est avant " + p1.nom + " " + p1.prenom);
        }
        else if (compareNomPrenom(p1, p2) < 0) {
            System.out.println(p1.nom + " " + p1.prenom + " est avant " + p2.nom + " " + p2.prenom);
        }
        else {
            System.out.println("Les noms et prénoms des personnes sont les mêmes !");
        }
    }
}


