package entity.model;

import java.sql.Date;
import java.util.List;

public class Booking {
	private static int bookingCount=1;
	private int event_id;
	private Event event;
	private int bookingId;
	private int customer_id;
	private Customer customer;
	private List<Customer> customers;
	private int num_tickets;
	private double total_cost;
	private Date booking_date;
	
	public Booking() {
		this.bookingId=bookingCount++;
	}
	
	public Booking(Event event, List<Customer> customers, int num_tickets, double total_cost,
			Date booking_date) {
		super();
		this.event = event;
		this.customers = customers;
		this.num_tickets = num_tickets;
		this.total_cost = total_cost;
		this.booking_date = booking_date;
	}

	public Booking(Event event, Customer customer, int num_tickets, double total_cost,
				   Date booking_date) {
		super();
		this.event = event;
		this.customer = customer;
		this.num_tickets = num_tickets;
		this.total_cost = total_cost;
		this.booking_date = booking_date;
	}

	public int getEvent_id() {
		return event_id;
	}

	public void setEvent_id(int event_id) {
		this.event_id = event_id;
	}

	public Booking(int bookingId, int customerId, int eventId, int numTickets, double totalCost, String bookingDate) {
		this.bookingId=bookingId;
		this.event_id = eventId;
		this.customer_id = customerId;
		this.num_tickets = numTickets;
		this.total_cost = totalCost;
		this.booking_date = Date.valueOf(bookingDate);
	}


	public static int getBookingCount() {
		return bookingCount;
	}

	public static void setBookingCount(int bookingCount) {
		Booking.bookingCount = bookingCount;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public int getNum_tickets() {
		return num_tickets;
	}

	public void setNum_tickets(int num_tickets) {
		this.num_tickets = num_tickets;
	}

	public double getTotal_cost() {
		return total_cost;
	}

	public void setTotal_cost(double total_cost) {
		this.total_cost = total_cost;
	}

	public Date getBooking_date() {
		return booking_date;
	}

	public void setBooking_date(Date booking_date) {
		this.booking_date = booking_date;
	}

	public double calculate_booking_cost(int num_tickets) {
		
		total_cost=event.getTicket_price()*num_tickets;
		return total_cost;
	}
	
	public int getAvailableNoOfTickets() {
		return event.getAvailable_seats();
	}
	
	public void getEventDetails() {
		event.display_event_details();
	}
	
	public void book_ticket(int num_tickets) {
		event.book_tickets(num_tickets);
	}
	
	public void cancel_booking(int num_tickets) {
		event.cancel_booking(num_tickets);
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public void display_booking_details() {
	        System.out.println("Booking ID: " + bookingId);
	        System.out.println("Customers:");
	        for (Customer customer : customers) {
	            System.out.println("  - " + customer.getCustomer_name());
	        }
	        System.out.println("Event Details:");
	        event.display_event_details();
	        System.out.println("Number of Tickets: " + num_tickets);
	        System.out.println("Total Cost: " + total_cost);
	        System.out.println("Booking Date: " + booking_date);
	    }



//	public static void main(String[] args) {
//
//		Booking booking= new Booking();
//		booking.getAvailableNoOfTickets();
//		booking.getEventDetails();
//		booking.book_ticket(0);
//		booking.cancel_booking(0);
//		booking.calculate_booking_cost(0);
//
//
//
//
//	}


//	public int getEventId() {
//		return event.getEvent_id();
//	}


}
