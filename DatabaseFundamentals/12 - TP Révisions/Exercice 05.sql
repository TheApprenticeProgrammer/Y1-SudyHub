-- Sans requête imbriquée

SET GLOBAL SQL_MODE = CONCAT(@@SQL_MODE, ',ONLY_FULL_GROUP_BY');

SELECT DISTINCT p.Nom, p.Sexe
FROM Mange m JOIN Personne p ON m.ID_P = p.ID
GROUP BY p.ID, m.ID_H, p.Nom, p.Sexe
HAVING COUNT(*) >= 3;


-- Avec requête imbriquée

SET GLOBAL SQL_MODE = CONCAT(@@SQL_MODE, ',ONLY_FULL_GROUP_BY');

SELECT DISTINCT p.Nom, p.Sexe
FROM Personne p
WHERE p.ID IN (SELECT m.ID_P
    		       FROM Mange m
			         GROUP BY m.ID_P, m.ID_H
               HAVING COUNT(*) >= 3);
