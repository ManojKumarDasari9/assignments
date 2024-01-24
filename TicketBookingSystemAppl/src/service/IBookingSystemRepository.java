package service;
import entity.model.Booking;
import entity.model.Customer;

import java.sql.SQLException;

public interface IBookingSystemRepository {
	/*Event create_event(Event event) throws SQLException;
	Event getEventDetails(int eventName) throws SQLException;*/
//    int getAvailableNoOfTickets() throws SQLException;
    double calculate_booking_cost(int num_tickets) throws SQLException;
    Booking book_tickets(Booking booking) throws SQLException;
    boolean cancel_booking(int booking_id) throws SQLException;
    Booking get_booking_details(int booking_id) throws SQLException;

    Customer getCustomerDetails(String phoneNumber);

    Customer createCustomer(Customer customer1);
}
