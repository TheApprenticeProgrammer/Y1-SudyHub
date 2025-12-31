SELECT DISTINCT m.Contenu
FROM Message m JOIN Personne p ON m.Expediteur = p.SSN
WHERE p.Sexe = 'M'
  AND p.Nom LIKE '_A%';
