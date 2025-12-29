SET GLOBAL SQL_MODE = CONCAT(@@SQL_MODE, ',ONLY_FULL_GROUP_BY');

SELECT *
FROM Message m
WHERE m.Date_Expedition >= ALL (SELECT m.Date_Expedition
                                FROM Message m);
