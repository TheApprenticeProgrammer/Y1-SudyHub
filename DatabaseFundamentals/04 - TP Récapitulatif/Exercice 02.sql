SELECT DISTINCT p.Nom
FROM Personne p
WHERE p.Age < 30
  AND p.Sexe = 'F';
