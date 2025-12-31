SELECT Exp.Nom
FROM Personne Exp, Personne Dest, Message m, Destinataires d
WHERE d.ID_Message = m.ID_Message
  AND d.Destinataire = Dest.SSN
  AND m.Expediteur = Exp.SSN
  AND Dest.Age < 18;
