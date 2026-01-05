SET GLOBAL SQL_MODE = CONCAT(@@SQL_MODE, ',ONLY_FULL_GROUP_BY');

SELECT p.player_name
FROM players p
WHERE p.player_id NOT IN (SELECT g.player_id
						  FROM goals g JOIN matches m ON g.match_id = m.match_id
						  WHERE m.type = 'P');
