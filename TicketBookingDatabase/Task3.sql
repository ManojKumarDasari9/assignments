-- Task-3 
-- 1 
SELECT
SUM(total_seats * ticket_price)
FROM Event 
GROUP BY event_name;
-- 2
SELECT
event_id,
SUM(num_tickets) 
FROM
Booking
GROUP BY
event_id;
-- 3   
SELECT 
SUM(total_cost) 
AS total_revenue 
FROM Booking;
-- 4
SELECT
event_name,
SUM(total_seats-available_seats)
FROM
Event
GROUP BY
event_name;
-- 4
-- SELECT
-- event_name,
-- SUM(available_seats<0)
-- FROM Event
-- GROUP BY
-- event_name; 

-- 5
SELECT
event_name
FROM Event
WHERE available_seats IS NULL;
-- 6
SELECT
C.customer_id,
C.customer_name,
SUM(B.num_tickets) AS num_tickets_booked
FROM
Customer C
JOIN
Booking B ON C.customer_id = B.customer_id
GROUP BY
C.customer_id, C.customer_name
ORDER BY
total_tickets_booked DESC
LIMIT 1;

-- 7
SELECT
C.customer_id,
C.customer_name,
SUM(B.num_tickets) AS num_tickets_eachmonth
FROM
Customer C
Join
Booking B ON C.customer_id=B.customer_id
GROUP BY
customer_id,
Customer_name
ORDER BY
num_tickets_eachmonth DESC;

-- 8
SELECT
C.customer_id,C.customer_name,
AVG(C.ticket_price) AS ticket_price_each_venue
FROM
Customer C
JOIN
Venue V ON C.venue_id_id=V.venue_id
GROUP BY
C.customer_name,C.venue_name
ORDER BY
ticket_price_each_venue DESC; 

-- 9
SELECT
E.event_type,
SUM(B.num_tickets) AS total_tickets_sold
FROM
Event E
JOIN
Booking B ON E.event_id = B.event_id
GROUP BY
E.event_type;

-- 10
SELECT
YEAR(E.event_date) as year,
SUM(B.total_cost) as total_generated
FROM 
EVENT E
JOIN 
BOOKING B ON E.event_id=B.booking_id
GROUP BY
YEAR(E.event_date);
-- 11
SELECT
C.customer_id,
C.customer_name
FROM
Customer C
JOIN
Booking B ON C.customer_id = B.customer_id
GROUP BY
C.customer_id, C.customer_name
HAVING
COUNT(DISTINCT B.event_id) > 1;

-- 12
SELECT
C.customer_id,
C.customer_name,
SUM(B.total_cost) AS total_revenue
FROM
Customer C
JOIN
Booking B ON C.customer_id = B.customer_id
GROUP BY
C.customer_id, C.customer_name;

-- 13
SELECT
E.event_type,
V.venue_name,
AVG(E.ticket_price) AS avg_ticket_price
FROM
Event E
JOIN
Venue V ON E.venue_id = V.venue_id
GROUP BY
E.event_type, V.venue_name;

-- 14
SELECT
C.customer_id,
C.customer_name,
SUM(B.num_tickets) AS total_tickets_purchased
FROM
Customer C
JOIN
Booking B ON C.customer_id = B.customer_id
WHERE
B.booking_date >= CURDATE() - INTERVAL 30 DAY
GROUP BY
C.customer_id, C.customer_name;




