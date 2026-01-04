SET GLOBAL SQL_MODE = CONCAT(@@SQL_MODE, ',ONLY_FULL_GROUP_BY');
          
SELECT p.Nom
FROM Mange m JOIN Personne p ON m.ID_P = p.ID
			 JOIN Hamburger h ON m.ID_H = h.ID
WHERE h.Genre = 'Poulet'
  AND p.Sexe = 'F'
GROUP BY p.Nom
HAVING COUNT(DISTINCT m.ID_H) = (SELECT COUNT(*)
                            	 FROM Hamburger h
                            	 WHERE h.Genre = 'Poulet');
