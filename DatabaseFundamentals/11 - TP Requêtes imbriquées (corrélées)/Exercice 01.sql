SET GLOBAL SQL_MODE = CONCAT(@@SQL_MODE, ',ONLY_FULL_GROUP_BY');

SELECT s.SNAME
FROM S s
WHERE EXISTS (SELECT *
              FROM SPJ li
              WHERE li.ID_S = s.ID_S
                AND li.QTY > 500)
  AND s.CITY = 'London';
