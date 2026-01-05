# 📘 Petit recueil de formules Excel

---

## 🔹 Valeurs extrêmes

### Formule pour rechercher la valeur minimale d'un tableau :
```excel
=MIN(Nom_Tableau[Nom_Colonne])
```

### Formule pour rechercher la valeur maximale d'un tableau :
```excel
=MAX(Nom_Tableau[Nom_Colonne])
```

---

## 🔹 Effectifs

### Formule pour calculer le nombre total de valeur d'une colonne :
```excel
=NB(Nom_Tableau[Nom_Colonne]) => Si la colonne est numérique.

=NBVAL(Nom_Tableau[Nom_Colonne]) => Si la colonne contient du texte (ex : modalités qualitatives).
```

---

### Formule pour calculer les différentes valeurs des modalités :
```excel
=TRIER(UNIQUE(Nom_Tableau[Nom_Colonne]))
```

---

### Formule pour calculer l'effectif associé à chaque modalité :
```excel
=FREQUENCE(Nom_Tableau[Nom_Colonne];Range_Colonne)
```

> ℹ️ FREQUENCE est principalement utilisée pour des données quantitatives.

```excel
=NB.SI(Nom_Tableau[Nom_Colonne];Cellule_Modalité)
```

> ℹ️ NB.SI() ou NB.SI.ENS() est principalement utilisé pour des données qualitatives.

---

## 🔹 Fréquences

### Formule pour calculer la fréquence des modalités :
```excel
=(id_Cellule_EffectifModalité) / (id_Cellule_EffectifTotal)
```

> ℹ️ Il est à noter que la cellule de l'effectif total peut être entourée  
> comme ceci `$A$1` ce qui a pour effet de bloquer la cellule.
>
> ℹ️ De plus la réponse à ce calcul ne sera pas en pourcentage. Pour l'avoir  
> en pourcentage il faudra cliquer sur :  
> **Accueil → Format de nombre → sélectionner pourcentage**

---

## 🔹 Cumul

### Formule pour calculer l'effectif cumulé jusqu'a une certaine modalité :
```excel
=SOMME(id_Cellule_EffectifModalité : id_Cellule_SommeFormule)
```

> ℹ️ Il est à noter que la cellule contenant l'effectif de la première modalité  
> peut être entourée comme ceci `$A$1` ce qui a pour effet de bloquer la cellule.

---

### Formule pour calculer la fréquence cumulée jusqu'a une certaine modalité :
```excel
=SOMME(id_Cellule_FréquenceModalité : id_Cellule_SommeFormule)
```

> ℹ️ Il est à noter que la cellule contenant la fréquence de la première modalité  
> peut être entourée comme ceci `$A$1` ce qui a pour effet de bloquer la cellule.
