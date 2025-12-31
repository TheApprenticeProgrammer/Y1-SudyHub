SELECT DISTINCT m.Date_Expedition
FROM Destinataires d JOIN Message m ON d.ID_Message = m.ID_Message
                     JOIN Personne p ON d.Destinataire = p.SSN
WHERE p.Sexe = 'F'
  AND p.Nom LIKE 'M%';
