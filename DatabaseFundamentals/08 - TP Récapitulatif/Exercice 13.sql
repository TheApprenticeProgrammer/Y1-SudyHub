SET GLOBAL SQL_MODE = CONCAT(@@SQL_MODE, ',ONLY_FULL_GROUP_BY'); 

SELECT p.Sexe, COUNT(*)
FROM Destinataires d JOIN Personne p ON d.Destinataire = p.SSN
GROUP BY p.Sexe;
