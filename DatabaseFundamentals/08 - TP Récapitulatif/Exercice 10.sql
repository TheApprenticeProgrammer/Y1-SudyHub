SET GLOBAL SQL_MODE = CONCAT(@@SQL_MODE, ',ONLY_FULL_GROUP_BY'); 

SELECT d.ID_Message, COUNT(*)
FROM Destinataires d
GROUP BY d.ID_Message;


-- Variante 01 :

SET GLOBAL SQL_MODE = CONCAT(@@SQL_MODE, ',ONLY_FULL_GROUP_BY'); 

SELECT d.ID_Message, m.Contenu, COUNT(*)
FROM Message m JOIN Destinataires d ON m.ID_Message = d.ID_Message
GROUP BY m.Contenu, d.ID_Message;


-- Variante 02 :

SET GLOBAL SQL_MODE = CONCAT(@@SQL_MODE, ',ONLY_FULL_GROUP_BY'); 

SELECT d.ID_Message, m.Contenu, p.Nom, COUNT(*)
FROM Destinaires d JOIN Message m ON d.iD_Message = m.ID_Message
                   JOIN Personne p ON d.Destinataire = p.SSN
GROUP BY d.ID_Message, m.Contenu, p.Nom;
