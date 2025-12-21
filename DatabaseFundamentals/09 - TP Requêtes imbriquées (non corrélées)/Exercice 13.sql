SET GLOBAL SQL_MODE = CONCAT(@@SQL_MODE, ',ONLY_FULL_GROUP_BY');

-- Avec IN

SELECT li.ID_S
FROM SPJ li JOIN P p ON li.ID_P = p.ID_P
WHERE li.ID_S IN (SELECT li.ID_S
                  FROM SPJ li JOIN J j ON li.ID_J = j.ID_J
                  GROUP BY li.ID_S
                  HAVING COUNT(DISTINCT j.CITY) > 2)
GROUP BY li.ID_S
HAVING COUNT(DISTINCT p.CITY) > 1;


-- Sans sous-requêtes

SELECT li.ID_S
FROM SPJ li JOIN J j ON li.ID_J = j.ID_J
            JOIN P p ON li.ID_P = p.ID_P
GROUP BY li.ID_S
HAVING COUNT(DISTINCT j.CITY) > 2
   AND COUNT(DISTINCT p.CITY) > 1;
