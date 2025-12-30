SELECT DISTINCT p.PNAME
FROM SPJ li JOIN S s ON li.ID_S = s.ID_S
            JOIN P p ON li.ID_P = p.ID_P
WHERE (s.CITY = 'Rome' OR s.CITY = 'London ')
  AND p.WEIGHT < 18;
