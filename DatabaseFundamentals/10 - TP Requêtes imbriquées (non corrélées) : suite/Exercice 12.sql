SET GLOBAL SQL_MODE = CONCAT(@@SQL_MODE, ',ONLY_FULL_GROUP_BY');

-- Avec ALL

SELECT *
FROM Personne p
WHERE p.Age <= ALL (SELECT p.Age
                    FROM Personne p);


-- Avec une liaison naturelle

SELECT *
FROM Personne p
WHERE p.Age = (SELECT MIN(p.Age)
               FROM Personne p); 
