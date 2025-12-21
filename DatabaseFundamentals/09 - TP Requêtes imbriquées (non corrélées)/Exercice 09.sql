SET GLOBAL SQL_MODE = CONCAT(@@SQL_MODE, ',ONLY_FULL_GROUP_BY');

-- Avec IN

SELECT s.ID_S
FROM S s
WHERE s.ID_S NOT IN (SELECT DISTINCT li.ID_S
                     FROM SPJ li JOIN P p ON li.ID_P = p.ID_P
                     WHERE p.COLOR = 'Blue'); 
