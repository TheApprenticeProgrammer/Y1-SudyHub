-- solution avec EXISTS :

SET GLOBAL SQL_MODE = CONCAT(@@SQL_MODE, ',ONLY_FULL_GROUP_BY');

SELECT s.ID_S
FROM S s
WHERE NOT EXISTS (SELECT *
          	      FROM SPJ li JOIN P p ON li.ID_P = p.ID_P
              	  WHERE li.ID_S = s.ID_S
                    AND p.COLOR = 'Blue');


-- solution avec IN :

SET GLOBAL SQL_MODE = CONCAT(@@SQL_MODE, ',ONLY_FULL_GROUP_BY');

SELECT s.ID_S
FROM S s
WHERE s.ID_S NOT IN (SELECT li.ID_S
          	  		 FROM SPJ li JOIN P p ON li.ID_P = p.ID_P
             		 WHERE p.COLOR = 'Blue');
