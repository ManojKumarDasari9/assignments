package service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entity.model.Booking;
import entity.model.Customer;
import entity.model.Event;
import entity.model.TicketBookingSystem;
import exception.EventNotFoundException;

public class BookingSystemServiceProviderImpl extends EventServiceProviderImpl implements IBookingSystemServiceProvider{

	private IBookingSystemRepository repository;
	private List<Booking> bookings = new ArrayList<>();
	public BookingSystemServiceProviderImpl(){
		super();
		repository=new BookingSystemRepositoryImpl();

	}
	private TicketBookingSystem ticketBookingSystem;

	
	@Override
	public double calculate_booking_cost(int num_tickets) throws SQLException, EventNotFoundException {
		// TODO Auto-generated method stub
	//	double total_cost=this.getRespository().calculate_booking_cost(num_tickets);
		//double total_cost=ticketBookingSystem.calculate_booking_cost(num_tickets)

		return 0.0;
	}


	@Override
	public Booking book_tickets(Event event, int num_tickets, Customer customer) throws SQLException, EventNotFoundException {

		Booking booking = new Booking();


			Customer customer1 = repository.getCustomerDetails(customer.getPhone_number());

			if (customer1 == null) {

				customer1 = repository.createCustomer(customer);

			}
			booking.setCustomer(customer1);
			booking.setEvent(event);
			booking.setBooking_date(booking.getBooking_date());
			booking.setNum_tickets(num_tickets);
			booking.setTotal_cost(num_tickets * event.getTicket_price());

			booking = repository.book_tickets(booking);
			boolean updated = updateTicketsBooked(event, num_tickets);
			if (!updated) {
				System.out.println("Problem while booking ticket");
				cancel_booking(booking.getBookingId());
			}

	return  booking;
	}



	@Override
	public Booking cancel_booking(int booking_id) throws SQLException, EventNotFoundException {
		// TODO Auto-generated method stub
		//ticketBookingSystem.cancel_booking(booking_id);
		Booking booking = repository.get_booking_details(booking_id);
		Event event = getEventDetails(booking.getEvent_id());
		boolean cancelled =repository.cancel_booking(booking_id);

		boolean updated = updateCancelledTicket(event, booking.getNum_tickets());

		return booking;
	}

	@Override
	public Booking get_booking_details(int booking_id) {
		// TODO Auto-generated method stub

		return null;
		
	}






}
