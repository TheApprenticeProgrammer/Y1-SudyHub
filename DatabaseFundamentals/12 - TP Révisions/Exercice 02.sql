SET GLOBAL SQL_MODE = CONCAT(@@SQL_MODE, ',ONLY_FULL_GROUP_BY');

SELECT DISTINCT p.Nom, p.Age
FROM Mange m JOIN Personne p ON m.ID_P = p.ID
			 JOIN Hamburger h ON m.ID_H = h.ID
WHERE p.Poids > 60
  AND p.Sexe = 'M'
  AND h.Genre = 'Poulet'
  AND m.Note < 7;
