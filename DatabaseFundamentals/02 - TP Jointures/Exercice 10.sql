SELECT DISTINCT p.ID_P
FROM SPJ li JOIN S s ON li.ID_S = s.ID_S
            JOIN P p ON li.ID_P = p.ID_P
WHERE s.CITY = 'London'
  AND p.CITY = 'London';
