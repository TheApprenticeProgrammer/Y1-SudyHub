-- Ma version :

SET GLOBAL SQL_MODE = CONCAT(@@SQL_MODE, ',ONLY_FULL_GROUP_BY'); 

SELECT p.Nom
FROM Message m JOIN Destinataires d ON m.ID_Message = d.ID_Message
               JOIN Personne p ON m.Expediteur = p.SSN
WHERE p.Sexe = 'F'
GROUP BY p.Nom
HAVING COUNT(*) = 1;


-- Version professeur

SET GLOBAL SQL_MODE = CONCAT(@@SQL_MODE, ',ONLY_FULL_GROUP_BY'); 

SELECT p.Nom
FROM Message m JOIN Personne p ON m.Expediteur = p.SSN
WHERE p.Sexe = 'F'
GROUP BY p.Nom, p.SSN
HAVING COUNT(*) = 1;
