SELECT DISTINCT m.Contenu
FROM Personne p JOIN Message m ON p.SSN = m.Expediteur
WHERE p.Sexe = 'M';
