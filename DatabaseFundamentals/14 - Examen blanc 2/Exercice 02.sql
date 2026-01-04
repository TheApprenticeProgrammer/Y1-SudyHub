SET GLOBAL SQL_MODE = CONCAT(@@SQL_MODE, ',ONLY_FULL_GROUP_BY');

SELECT t1.team_name, t2.team_name, t1.pool
FROM participations p1 
		JOIN participations p2 ON p1.match_id = p2.match_id
		JOIN teams t1 ON p1.team_id = t1.team_id
        JOIN teams t2 ON p2.team_id = t2.team_id
WHERE p1.team_id < p2.team_id
  AND p2.points = 1;   
