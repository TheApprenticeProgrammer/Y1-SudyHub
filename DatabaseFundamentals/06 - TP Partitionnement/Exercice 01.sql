-- Cette requête n'est pas correcte car p.ID_P ne fait pas partie de la clause GROUP BY.

SELECT p.ID_P, SUM(p.WHEIGHT)
FROM P p
GROUP BY p.COLOR;


-- Cette requête n'est pas correcte car mélanger des fonctions d'agrégations avec des colonnes normales est interdit s'il n'y a pas de clause GROUP BY.

SELECT li.ID_S, SUM(li.QTY)
FROM SPJ li;


-- Cette requête n'est pas correte car p.WEIGHT ne fait pas parti du GROUP BY p.ID_P.

SELECT p.ID_P, p.WEIGHT
FROM P p
GROUP BY p.ID_P.
