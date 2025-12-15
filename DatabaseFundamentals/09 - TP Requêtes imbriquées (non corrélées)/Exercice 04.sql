-- Première manière : deux IN

SET GLOBAL SQL_MODE = CONCAT(@@SQL_MODE, ',ONLY_FULL_GROUP_BY');

SELECT s.SNAME
FROM S s
WHERE s.ID_S IN (SELECT li.ID_S
                 FROM SPJ li
                 WHERE li.ID_P IN (SELECT p.ID_P
                                   FROM P p
                                   WHERE p.COLOR = 'Red'));


-- Seconde manière : un IN et une jointure

SET GLOBAL SQL_MODE = CONCAT(@@SQL_MODE, ',ONLY_FULL_GROUP_BY');

SELECT DISTINCT s.SNAME
FROM S s
WHERE s.ID_S IN (SELECT li.ID_S
                 FROM SPJ li JOIN P p ON li.ID_P = p.ID_P
                 WHERE p.COLOR = 'Red');
