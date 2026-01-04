SET GLOBAL SQL_MODE = CONCAT(@@SQL_MODE, ',ONLY_FULL_GROUP_BY');

SELECT m.ID_P
FROM Mange m
GROUP BY m.ID_P
HAVING COUNT(*) <= ALL (SELECT COUNT(*)
                    	FROM Mange m
                    	GROUP BY m.ID_P);
