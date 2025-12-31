SELECT DISTINCT p.Nom
FROM Destinataires d JOIN Personne p ON d.Destinataire = p.SSN
WHERE d.ID_Message = 'M4';
