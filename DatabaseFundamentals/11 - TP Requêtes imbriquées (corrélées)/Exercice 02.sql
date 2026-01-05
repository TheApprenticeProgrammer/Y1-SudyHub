SET GLOBAL SQL_MODE = CONCAT(@@SQL_MODE, ',ONLY_FULL_GROUP_BY');

SELECT j.JNAME
FROM J j
WHERE EXISTS (SELECT *
              FROM SPJ li
              WHERE li.ID_J = j.ID_J
              GROUP BY li.ID_J
              HAVING SUM(li.QTY) > 1000);
              
