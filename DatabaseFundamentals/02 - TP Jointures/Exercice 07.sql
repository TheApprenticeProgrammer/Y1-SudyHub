SELECT DISTINCT s.SNAME AS NOM, p.PNAME AS PIECE, j.JNAME AS PROJET, li.QTY AS QUANTITE
FROM SPJ li JOIN S s ON li.ID_S = s.ID_S
            JOIN P p ON li.ID_p = p.ID_P
            JOIN J j ON li.ID_J = j.ID_J
WHERE s.CITY = 'Paris';
