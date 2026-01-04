SET GLOBAL SQL_MODE = CONCAT(@@SQL_MODE, ',ONLY_FULL_GROUP_BY');
               
SELECT m.Date_Consommation
FROM Mange m
GROUP BY m.ID_H, m.Date_Consommation
HAVING COUNT(*) >= 2;
