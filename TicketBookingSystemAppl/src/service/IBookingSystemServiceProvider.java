package service;

import java.sql.SQLException;

import entity.model.Booking;
import entity.model.Customer;
import entity.model.Event;
import exception.EventNotFoundException;

public interface IBookingSystemServiceProvider{
    double calculate_booking_cost(int num_tickets) throws SQLException, EventNotFoundException;
    
    Booking book_tickets(Event event, int num_tickets, Customer customers) throws SQLException, EventNotFoundException;
    
    Booking cancel_booking(int booking_id) throws SQLException, EventNotFoundException;
    
    Booking get_booking_details(int booking_id);
}
