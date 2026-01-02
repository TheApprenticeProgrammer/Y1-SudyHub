SET GLOBAL SQL_MODE = CONCAT(@@SQL_MODE, ',ONLY_FULL_GROUP_BY'); 

SELECT j.JNAME, SUM(li.QTY)
FROM SPJ li JOIN J j ON li.ID_J = j.ID_J
GROUP BY li.ID_J, j.JNAME;

-- Attention : il est important de grouper par j.ID_J car il pourrait y avoir plusieurs projets
--             qui ont le même nom. Pas d'hypothèses sur les données.
