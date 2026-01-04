-- Avec requête imbriquée :

SET GLOBAL SQL_MODE = CONCAT(@@SQL_MODE, ',ONLY_FULL_GROUP_BY'); 

SELECT DISTINCT p.Nom, p.Poids
FROM Personne p
WHERE p.ID IN (SELECT p.ID
               FROM Mange m JOIN Personne p ON m.ID_P = p.ID
                            JOIN Hamburger h ON m.ID_H = h.ID
               WHERE h.Genre = 'Boeuf'
                 AND h.Calories > 1000
                 AND p.Age < 32);


-- Sans requête imbriquée :

SET GLOBAL SQL_MODE = CONCAT(@@SQL_MODE, ',ONLY_FULL_GROUP_BY'); 

SELECT DISTINCT p.Nom, p.Poids
FROM Mange m JOIN Personne p ON m.ID_P = p.ID
             JOIN Hamburger h ON m.ID_H = h.ID
WHERE h.Genre = 'Boeuf'
  AND h.Calories > 1000
  AND p.Age < 32;
