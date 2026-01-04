-- Sans ANY

SET GLOBAL SQL_MODE = CONCAT(@@SQL_MODE, ',ONLY_FULL_GROUP_BY');

SELECT h.Nom
FROM Hamburger h
WHERE h.Calories != (SELECT MAX(h.Calories)
                     FROM Hamburger h);


-- Avec ANY

SET GLOBAL SQL_MODE = CONCAT(@@SQL_MODE, ',ONLY_FULL_GROUP_BY');

SELECT h.Nom
FROM Hamburger h
WHERE h.Calories < ANY (SELECT h.Calories
                        FROM Hamburger h);

