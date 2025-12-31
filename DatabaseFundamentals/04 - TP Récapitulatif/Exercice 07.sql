SELECT DISTINCT m.Contenu
FROM Destinataires d JOIN Message m ON d.ID_Message = m.ID_Message
                     JOIN Personne p ON d.Destinataire = p.SSN
WHERE p.Age < 30
  AND p.Sexe = 'F';
