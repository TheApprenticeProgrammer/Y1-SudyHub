SET GLOBAL SQL_MODE = CONCAT(@@SQL_MODE, ',ONLY_FULL_GROUP_BY');

SELECT g.player_id
FROM goals g
WHERE g.type = 'p'
GROUP BY g.player_id
HAVING SUM(g.num_goals) >= ALL (SELECT SUM(g.num_goals) 
                                FROM goals g
                                WHERE g.type = 'p'
                            	GROUP BY g.player_id);
