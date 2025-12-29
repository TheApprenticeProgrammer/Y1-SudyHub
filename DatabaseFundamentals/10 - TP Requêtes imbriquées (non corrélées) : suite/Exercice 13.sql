SET GLOBAL SQL_MODE = CONCAT(@@SQL_MODE, ',ONLY_FULL_GROUP_BY');

SELECT DISTINCT m.Contenu
FROM Message m
WHERE m.Date_Expedition > (SELECT MIN(m.Date_Expedition)
                           FROM Message m);
