
CREATE TABLE Venue (
venue_id INT AUTO_INCREMENT PRIMARY KEY,
venue_name VARCHAR(100) NOT NULL,
address VARCHAR(255) NOT NULL
);

CREATE TABLE Event (
event_id INT AUTO_INCREMENT PRIMARY KEY,
event_name VARCHAR(100) NOT NULL,
event_date DATE NOT NULL,
event_time TIME NOT NULL,
venue_id INT NOT NULL,
total_seats INT NOT NULL,
available_seats INT NOT NULL,
ticket_price DECIMAL(10,2) NOT NULL,
event_type ENUM('Movie', 'Sports', 'Concert') NOT NULL,
FOREIGN KEY (venue_id) REFERENCES Venue(venue_id),
FOREIGN KEY (booking_id) REFERENCES Booking(booking_id)
);

CREATE TABLE Customer (
customer_id INT AUTO_INCREMENT PRIMARY KEY,
customer_name VARCHAR(100) NOT NULL,
email VARCHAR(100) NOT NULL UNIQUE,
phone_number VARCHAR(20) NOT NULL
);

CREATE TABLE Booking (
booking_id INT AUTO_INCREMENT PRIMARY KEY,
customer_id INT NOT NULL,
event_id INT NOT NULL,
num_tickets INT NOT NULL,
total_cost DECIMAL(10,2) NOT NULL,
booking_date DATE NOT NULL,
FOREIGN KEY (customer_id) REFERENCES Customer(customer_id),
FOREIGN KEY (event_id) REFERENCES Event(event_id)
);

ALTER TABLE Customer
ADD CONSTRAINT fk_booking_id
FOREIGN KEY (booking_id)
REFERENCES Booking(booking_id);

ALTER TABLE Customer
ADD COLUMN booking_id INT;

ALTER TABLE event
ADD COLUMN booking_id INT;

ALTER TABLE event
ADD CONSTRAINT fk2_booking_id
FOREIGN KEY (booking_id)
REFERENCES Booking(booking_id);