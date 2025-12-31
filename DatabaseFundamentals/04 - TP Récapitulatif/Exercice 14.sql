SELECT DISTINCT ea2.SSN2
FROM EstAmi ea1 JOIN EstAmi ea2 ON ea1.SSN2 = ea2.SSN1
                JOIN Personne Xavier ON ea1.SSN1 = Xavier.SSN
WHERE Xavier.Nom = 'Xavier';
