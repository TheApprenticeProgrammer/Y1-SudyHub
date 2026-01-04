-- Version personnelle :

SET GLOBAL SQL_MODE = CONCAT(@@SQL_MODE, ',ONLY_FULL_GROUP_BY');

SELECT h.Nom
FROM Hamburger h
WHERE h.Genre = 'Boeuf' 
  AND h.ID IN (SELECT m.ID_H
			   FROM Mange m JOIN Personne p ON m.ID_P = p.ID
			   WHERE p.Poids > 80
			   GROUP BY m.ID_H
			   HAVING COUNT(DISTINCT m.ID_P) = (SELECT COUNT(*)
                                 				FROM Personne p
                                 				WHERE p.Poids > 80));


-- Version professeur :

SET GLOBAL SQL_MODE = CONCAT(@@SQL_MODE, ',ONLY_FULL_GROUP_BY');

SELECT h.Nom
FROM Mange m JOIN Hamburger h ON m.ID_H = h.ID
			 JOIN Personne p ON m.ID_P = p.ID
WHERE h.Genre = 'Boeuf'
  AND p.Poids > 80
GROUP BY h.ID, h.Nom
HAVING COUNT(DISTINCT m.ID_P) = (SELECT COUNT(*)
                                 FROM Personne p
                                 WHERE p.Poids > 80);
