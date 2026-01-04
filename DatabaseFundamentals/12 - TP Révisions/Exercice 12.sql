SET GLOBAL SQL_MODE = CONCAT(@@SQL_MODE, ',ONLY_FULL_GROUP_BY');

SELECT DISTINCT p.ID
FROM Mange m JOIN Hamburger h ON m.ID_H = h.ID
			 JOIN Personne p ON m.ID_P = p.ID
WHERE h.Genre = 'Poulet'
  AND p.Sexe ='M'
  AND p.Poids = (SELECT MAX(p.Poids)
                 FROM Mange m JOIN Personne p ON m.ID_P = p.ID
                 WHERE h.Genre = 'Poulet'
                 AND p.Sexe ='M');
