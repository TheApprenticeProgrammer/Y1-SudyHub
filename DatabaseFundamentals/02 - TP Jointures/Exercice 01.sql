SELECT li.ID_S, li.ID_P, li.ID_J
FROM SPJ li JOIN P p ON li.ID_P = p.ID_P
WHERE p.COLOR = 'Red';
