SET GLOBAL SQL_MODE = CONCAT(@@SQL_MODE, ',ONLY_FULL_GROUP_BY');

SELECT p.NOM
FROM Personne p JOIN EstAmi ea ON p.SSN = ea.SSN1
GROUP BY p.SSN, p.Nom
HAVING COUNT(*) >= ALL (SELECT COUNT(*)
                        FROM EstAmi ea
                        GROUP BY ea.SSN1);
