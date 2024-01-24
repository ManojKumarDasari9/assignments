-- Task 4
SELECT
V.venue_name,
(SELECT AVG(ticket_price) FROM Event E WHERE E.venue_id = V.venue_id) AS avg_ticket_price
FROM
Venue V;

-- 2
SELECT
E.event_name
FROM
Event E
WHERE
(SELECT SUM(num_tickets) FROM Booking B WHERE B.event_id = E.event_id) > E.total_seats * 0.5;

-- 3
SELECT
E.event_name,
(SELECT SUM(num_tickets) FROM Booking B WHERE B.event_id= E.event_id) AS tickets_sold
FROM Event E;

-- 4
SELECT
C.customer_id,
C.customer_name
FROM
Customer C
WHERE NOT EXISTS(SELECT * FROM Booking B Where B.booking_id = C.customer_id);

-- 5
SELECT
E.event_id,
E.event_name
FROM
Event E
WHERE E.event_id NOT IN (SELECT DISTINCT E.event_id FROM Booking B );

-- 6
SELECT
event_type,
SUM(total_tickets_sold) AS total_tickets_sold
FROM (SELECT E.event_type, B.num_tickets AS total_tickets_sold
FROM
Event E
JOIN Booking B ON E.event_id = B.event_id) as subquery
GROUP BY
event_type;

-- 7
SELECT
event_id,
event_name,
ticket_price
FROM
Event
WHERE
ticket_price > (SELECT AVG(ticket_price) FROM Event);

-- 8
SELECT
C.customer_id,
C.customer_name,
(SELECT SUM(total_cost) FROM Booking B WHERE B.customer_id = C.customer_id) AS total_revenue
FROM
Customer C;

-- 9
SELECT
customer_id,
customer_name
FROM
Customer
WHERE
EXISTS (SELECT 1 FROM Booking B JOIN Event E ON B.event_id = E.event_id WHERE E.venue_id = 'your_venue_id' AND B.customer_id = Customer.customer_id);

-- 10
SELECT
event_type,
SUM(total_tickets_sold) AS total_tickets_sold
FROM (
SELECT
	E.event_type,
	B.num_tickets AS total_tickets_sold
FROM
	Event E
JOIN
	Booking B ON E.event_id = B.event_id
) AS Subquery
GROUP BY
event_type;

-- 11
SELECT
customer_id,
customer_name
FROM
Customer C
WHERE
EXISTS (
SELECT 1
FROM Booking B
JOIN Event E ON B.event_id = E.event_id
WHERE B.customer_id = C.customer_id
AND DATE_FORMAT(E.event_date, '%Y-%m') = 'your_desired_month');

-- 12
SELECT
V.venue_name,
(SELECT AVG(ticket_price) FROM Event E WHERE E.venue_id = V.venue_id) AS avg_ticket_price
FROM
Venue V;
