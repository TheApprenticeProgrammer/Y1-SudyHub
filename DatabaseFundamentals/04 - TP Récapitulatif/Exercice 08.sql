SELECT p.Nom
FROM EstAmi ea JOIN Personne p ON ea.SSN2 = p.SSN
WHERE ea.SSN1 = 'P1';
