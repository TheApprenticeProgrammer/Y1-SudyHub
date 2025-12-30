SELECT DISTINCT j.CITY
FROM SPJ li JOIN S s ON li.ID_S = s.ID_S
            JOIN J j ON li.ID_J = j.ID_J
WHERE s.SNAME = 'Adams';
