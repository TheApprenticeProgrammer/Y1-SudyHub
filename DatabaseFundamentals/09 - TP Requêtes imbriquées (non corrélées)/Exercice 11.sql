SET GLOBAL SQL_MODE = CONCAT(@@SQL_MODE, ',ONLY_FULL_GROUP_BY');

-- Avec NOT IN

SELECT s.ID_S
FROM S s
WHERE s.ID_S NOT IN (SELECT li.ID_S
                     FROM SPJ li
                     GROUP BY li.ID_S, li.ID_P
                     HAVING SUM(li.QTY) >= 650);
