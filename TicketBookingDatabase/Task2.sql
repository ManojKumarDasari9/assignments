-- Task 2
SELECT*
FROM Event;

SELECT *
FROM Event
WHERE available_seats > 0;


SELECT *
FROM Event
WHERE ticket_price BETWEEN 1000 AND 2500;

SELECT *
FROM Event
WHERE event_date BETWEEN '2024-01-15' AND '2024-04-15';

SELECT *
FROM Event
WHERE available_seats > 0
AND event_type = 'Concert';

SELECT * 
FROM Customer 
LIMIT 5 OFFSET 5;

SELECT *
FROM Booking
WHERE num_tickets > 4;

SELECT*
FROM Customer
WHERE phone_number LIKE '%000';

SELECT*
FROM Event
WHERE total_seats>15000;

SELECT*
FROM Event
WHERE event_name NOT LIKE 'x%' AND event_name NOT LIKE 'y%' AND event_name NOT LIKE 'z%';





