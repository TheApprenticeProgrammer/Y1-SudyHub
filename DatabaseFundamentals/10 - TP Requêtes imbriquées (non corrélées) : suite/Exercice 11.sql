

SELECT *
FROM Message m
WHERE m.Date_Expedition >= ALL (SELECT m.Date_Expedition
                                FROM Message m);
