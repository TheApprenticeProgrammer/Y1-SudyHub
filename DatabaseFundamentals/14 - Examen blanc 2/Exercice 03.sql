SET GLOBAL SQL_MODE = CONCAT(@@SQL_MODE, ',ONLY_FULL_GROUP_BY');

SELECT t.pool
FROM participations p JOIN teams t ON p.team_id = t.team_id
					  JOIN matches m ON p.match_id = m.match_id
WHERE p.points = 3
  AND m.type = 'p'
GROUP BY t.pool
HAVING COUNT(*) = 4;
