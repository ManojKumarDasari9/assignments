
INSERT INTO Venue (venue_name, address) VALUES
('Venue 1', 'Chennai'),
('Venue 2', 'Bangalore'),
('Venue 3', 'Mumbai'),
('Venue 4', 'Hyderabad'),
('Venue 5', 'Chennai'),
('Venue 6', 'Bangalore'),
('Venue 7', 'Mumbai'),
('Venue 8', 'Chennai'),
('Venue 9', 'Mumbai'),
('Venue 10', 'Bangalore');

INSERT INTO Event (event_name, event_date, event_time, venue_id, total_seats, available_seats, ticket_price, event_type) VALUES
('Event 1', '2024-01-06', '12:00:00', 1, 100, 50, 1500.00, 'Concert'),
('Event 2', '2024-01-07', '15:30:00', 2, 150, 100, 2000.00, 'Movie'),
('mcupd', '2024-01-08', '18:45:00', 3, 120, 80, 1800.00, 'Sports'),
('Event 4', '2024-01-09', '14:15:00', 4, 200, 150, 2200.00, 'Concert'),
('Event 5', '2024-01-10', '20:00:00', 5, 80, 40, 1200.00, 'Movie'),
('Event 6', '2024-01-11', '16:30:00', 6, 160, 120, 2500.00, 'Sports'),
('Event 7', '2024-01-12', '19:00:00', 7, 180, 100, 2000.00, 'Concert'),
('Event 8', '2024-01-13', '13:45:00', 8, 120, 90, 1800.00, 'Movie'),
('Event 9', '2024-01-14', '17:30:00', 9, 220, 180, 2800.00, 'Sports'),
('Event 10', '2024-01-15', '21:15:00', 10, 150, 120, 2200.00, 'Concert');

DELETE FROM Event WHERE Event_name = 'Event 1';
SET SQL_SAFE_UPDATES = 0;


INSERT INTO Customer (customer_name, email, phone_number) VALUES
('Customer 1', 'customer1@example.com', '123000'),
('Customer 2', 'customer2@example.com', '456000'),
('Customer 3', 'customer3@example.com', '789000'),
('Customer 4', 'customer4@example.com', '101000'),
('Customer 5', 'customer5@example.com', '112000'),
('Customer 6', 'customer6@example.com', '131000'),
('Customer 7', 'customer7@example.com', '145000'),
('Customer 8', 'customer8@example.com', '167000'),
('Customer 9', 'customer9@example.com', '189000'),
('Customer 10', 'customer10@example.com', '200000');

INSERT INTO Booking (customer_id, event_id, num_tickets, total_cost, booking_date) VALUES
(1, 1, 3, 4500.00, '2024-01-05'),
(2, 2, 2, 4000.00, '2024-01-05'),
(3, 3, 5, 9000.00, '2024-01-06'),
(4, 4, 4, 8800.00, '2024-01-07'),
(5, 5, 2, 2400.00, '2024-01-08'),
(6, 6, 3, 7500.00, '2024-01-09'),
(7, 7, 4, 8000.00, '2024-01-10'),
(8, 8, 3, 5400.00, '2024-01-11'),
(9, 9, 6, 16800.00, '2024-01-12'),
(10, 10, 5, 11000.00, '2024-01-13');
