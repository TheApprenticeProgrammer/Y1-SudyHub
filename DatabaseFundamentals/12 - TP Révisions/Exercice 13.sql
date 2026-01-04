-- Sans le IN :

SET GLOBAL SQL_MODE = CONCAT(@@SQL_MODE, ',ONLY_FULL_GROUP_BY');

SELECT m.ID_H
FROM Mange m JOIN Personne p ON m.ID_P = p.ID
GROUP BY m.ID_H
HAVING COUNT(DISTINCT p.Sexe) = 2;


-- Avec le IN :

SET GLOBAL SQL_MODE = CONCAT(@@SQL_MODE, ',ONLY_FULL_GROUP_BY');

SELECT h.ID
FROM Hamburger h
WHERE h.ID IN (SELECT m.ID_H
               FROM Mange m JOIN Personne p ON m.ID_P = p.ID
               WHERE p.Sexe = 'F')
  AND h.ID IN (SELECT m.ID_H
               FROM Mange m JOIN Personne p ON m.ID_P = p.ID
               WHERE p.Sexe = 'M');
