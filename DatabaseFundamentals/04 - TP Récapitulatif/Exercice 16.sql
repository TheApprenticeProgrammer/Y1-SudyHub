-- Sans tenir compte des amitiés

SELECT DISTINCT f.Nom, m.Nom
FROM Personne f, Personne m
WHERE f.Sexe = 'F'
  and m.Sexe = 'M'
ORDER BY (f.Age + m.Age);

-- En tenant compte des amitiés

SELECT f.Nom, m.Nom
FROM EstAmi ea JOIN Personne f ON ea.SSN1 = f.SSN
               JOIN Personne m ON ea.SSN2 = m.SSN
WHERE f.Sexe = 'F'
  AND m.Sexe = 'M'
ORDER BY (f.Age + m.Age);
