SET GLOBAL SQL_MODE = CONCAT(@@SQL_MODE, ',ONLY_FULL_GROUP_BY');
          
SELECT h.Nom
FROM Hamburger h
WHERE h.ID IN (SELECT m.ID_H
               FROM Mange m JOIN Personne p ON m.ID_P = p.ID
               WHERE p.Sexe = 'M'
                 AND p.Poids > 100)
  AND h.ID NOT IN (SELECT m.ID_H
               	   FROM Mange m JOIN Personne p ON m.ID_P = p.ID
                   WHERE p.Sexe = 'F'
                     AND p.Age > 30);
