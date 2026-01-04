SET GLOBAL SQL_MODE = CONCAT(@@SQL_MODE, ',ONLY_FULL_GROUP_BY');
          
SELECT p.Nom
FROM Personne p
WHERE p.ID IN (SELECT m.ID_P
               FROM Mange m JOIN Hamburger h ON m.ID_H = h.ID
               WHERE h.Genre = 'Poulet')
  AND p.ID NOT IN (SELECT m.ID_P
                   FROM Mange m JOIN Hamburger h ON m.ID_H = h.ID
                   WHERE h.Genre = 'Boeuf'
                     AND h.Calories < 1000);
