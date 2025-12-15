-- Première manière : deux IN

SET GLOBAL SQL_MODE = CONCAT(@@SQL_MODE, ',ONLY_FULL_GROUP_BY');

SELECT s.ID_S, s.SNAME
FROM S s
WHERE li.ID_S IN (SELECT li.ID_S
                  FROM SPJ li
                  WHERE li.ID_J IN (SELECT j.ID_J
                                    FROM J j
                                    WHERE j.JNAME = 'Console'));


-- Deuxième manière : un IN et une jointure

SET GLOBAL SQL_MODE = CONCAT(@@SQL_MODE, ',ONLY_FULL_GROUP_BY');

SELECT s.ID_S, s.SNAME
FROM S s
WHERE s.ID_S IN (SELECT li.ID_S
                 FROM SPJ li JOIN J j ON li.ID_J = j.ID_J
                 WHERE j.JNAME = 'Console');
