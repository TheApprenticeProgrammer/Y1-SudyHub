SET GLOBAL SQL_MODE = CONCAT(@@SQL_MODE, ',ONLY_FULL_GROUP_BY'); 

SELECT p.Nom, m.Contenu
FROM Message m JOIN Destinataires d ON m.ID_Message = d.ID_Message
               JOIN Personne p ON m.Expediteur = p.SSN
GROUP BY p.Nom, m.Contenu, m.ID_Message
HAVING COUNT (*) = 1;
