SET GLOBAL SQL_MODE = CONCAT(@@SQL_MODE, ',ONLY_FULL_GROUP_BY');

-- Avec ALL (version professeur)

SELECT DISTINCT p.PNAME
FROM P p
WHERE p.COLOR <> ALL (SELECT p.COLOR
                      FROM P p
                      GROUP BY p.COLOR
                      HAVING COUNT(*) > 1);

  
-- Avec ALL (version personnelle)

SELECT DISTINCT p.PNAME
FROM P p
WHERE p.COLOR = ALL (SELECT p.COLOR
                     FROM P p
                     GROUP BY p.COLOR
                     HAVING COUNT(*) < 2);


-- Avec ANY

SELECT p.PNAME
FROM P p
WHERE p.COLOR = ANY (SELECT p.COLOR
                     FROM P p
                     GROUP BY p.COLOR
                     HAVING COUNT(*) = 1);
