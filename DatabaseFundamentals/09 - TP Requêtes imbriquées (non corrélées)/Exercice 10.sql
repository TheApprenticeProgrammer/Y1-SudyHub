SET GLOBAL SQL_MODE = CONCAT(@@SQL_MODE, ',ONLY_FULL_GROUP_BY');

-- Avec IN

SELECT COUNT(*) AS Nombre_De_Livraisons
FROM SPJ li
WHERE li.ID_S NOT IN (SELECT li.ID_S
                      FROM SPJ li JOIN J j ON li.ID_J = j.ID_J
                      WHERE j.CITY = 'Paris');
