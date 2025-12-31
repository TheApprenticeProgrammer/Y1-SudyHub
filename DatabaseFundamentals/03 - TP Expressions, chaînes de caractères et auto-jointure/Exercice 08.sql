SELECT s.ID_S, s.CITY, p.ID_P, p.CITY, j.ID_J, j.CITY
FROM S s, P p, J j
WHERE s.CITY != p.CITY
  AND p.CITY != j.CITY
  AND j.CITY != s.CITY;
