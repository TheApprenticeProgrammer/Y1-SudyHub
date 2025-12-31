SELECT s.ID_S, p.ID_P, j.ID_J
FROM S s, P p, J j
WHERE s.CITY != p.CITY
   OR p.CITY != j.CITY;

-- De Morgan

SELECT s.ID_S, p.ID_P, j.ID_J
FROM S s, P p, J j
WHERE NOT (s.CITY = p.CITY
           AND p.CITY = j.CITY);
