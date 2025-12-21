SET GLOBAL SQL_MODE = CONCAT(@@SQL_MODE, ',ONLY_FULL_GROUP_BY');

-- Avec IN (version professeur)

SELECT li.ID_S
FROM SPJ li
WHERE li.ID_S IN (SELECT li.ID_S
                  FROM SPJ li
                  GROUP BY li.ID_S
                  HAVING COUNT(DISTINCT li.ID_P) >= 3)
GROUP BY li.ID_S
HAVING COUNT(*) >= 4;


-- Avec IN (version personnelle)

SELECT s.ID_S
FROM S s
WHERE s.ID_S IN (SELECT li.ID_s
                 FROM SPJ li
                 GROUP BY li.ID_S
                 HAVING COUNT(*) >= 4
                    AND COUNT(DISTINCT li.ID_P) > 2);


-- Sans sous requête

SELECT li.ID_S
FROM SPJ li
GROUP BY li.ID_S
HAVING COUNT(*) >= 4
   AND COUNT(DISTINCT li.ID_P) >= 3;
