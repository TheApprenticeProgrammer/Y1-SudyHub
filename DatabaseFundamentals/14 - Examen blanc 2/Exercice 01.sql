-- Version personnelle :

SET GLOBAL SQL_MODE = CONCAT(@@SQL_MODE, ',ONLY_FULL_GROUP_BY');

SELECT m.date
FROM matches m JOIN participations p ON m.match_id = p.match_id
WHERE m.type = 'P'
  AND team_id IN (SELECT t.team_id
                  FROM teams t
                  WHERE t.team_name = 'Morocco' OR t.team_name = 'France');


-- Version professeur :

SET GLOBAL SQL_MODE = CONCAT(@@SQL_MODE, ',ONLY_FULL_GROUP_BY');

SELECT m.date
FROM matches m
         JOIN participations p ON m.match_id = p.match_id
         JOIN teams t ON t.team_id = p.team_id
WHERE m.type = 'P'
  AND (t.team_name = 'France' OR t.team_name = 'Morocco');
