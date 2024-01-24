//package entity.model;
//import java.sql.Date;
//import java.sql.Time;
//
//public class Event1 {
//	protected Customer customer;
//	protected String event_name;
//	protected Date event_date;
//	protected Time event_time;
//	protected String venue_name;
//	protected int total_seats;
//	protected int available_seats;
//	protected double ticket_price;
//	protected EventType event_type;
//	
//	public Event1() {
//		
//		
//	}
//	
//	
//	
//	public Event1(String event_name,Date event_date,Time event_time,String venue_name,int total_seats,int available_seats,double ticket_price,String event_type,String customer_name,String email,String phone_number){
//		this.event_name=event_name;
//		this.event_date=event_date;
//		this.event_time=event_time;
//		this.venue_name=venue_name;
//		this.total_seats=total_seats;
//		this.available_seats=available_seats;
//		this.ticket_price=ticket_price;
//		this.event_type=EventType.valueOf(event_type);
//		this.customer=new Customer(customer_name,email,phone_number);
//	}
//	
//	public void setEvent(String event_name,Date event_date,Time event_time,String venue_name,int total_seats,int available_seats,double ticket_price,EventType event_type) {
//		this.event_name=event_name;
//		this.event_date=event_date;
//		this.event_time=event_time;
//		this.venue_name=venue_name;
//		this.total_seats=total_seats;
//		this.available_seats=available_seats;
//		this.ticket_price=ticket_price;
//		this.event_type=event_type;
//	}
//	
//	
//	
//	
//	
//	public Customer getCustomer() {
//		return customer;
//	}
//
//
//
//	public void setCustomer(Customer customer) {
//		this.customer = customer;
//	}
//
//
//
//	public String getEvent_name() {
//		return event_name;
//	}
//
//
//
//	public void setEvent_name(String event_name) {
//		this.event_name = event_name;
//	}
//
//
//
//	public Date getEvent_date() {
//		return event_date;
//	}
//
//
//
//	public void setEvent_date(Date event_date) {
//		this.event_date = event_date;
//	}
//
//
//
//	public Time getEvent_time() {
//		return event_time;
//	}
//
//
//
//	public void setEvent_time(Time event_time) {
//		this.event_time = event_time;
//	}
//
//
//
//	public String getVenue_name() {
//		return venue_name;
//	}
//
//
//
//	public void setVenue_name(String venue_name) {
//		this.venue_name = venue_name;
//	}
//
//
//
//	public int getTotal_seats() {
//		return total_seats;
//	}
//
//
//
//	public void setTotal_seats(int total_seats) {
//		this.total_seats = total_seats;
//	}
//
//
//
//	public int getAvailable_seats() {
//		return available_seats;
//	}
//
//
//
//	public void setAvailable_seats(int available_seats) {
//		this.available_seats = available_seats;
//	}
//
//
//
//	public double getTicket_price() {
//		return ticket_price;
//	}
//
//
//
//	public void setTicket_price(double ticket_price) {
//		this.ticket_price = ticket_price;
//	}
//
//
//
//	public EventType getEvent_type() {
//		return event_type;
//	}
//
//
//
//	public void setEvent_type(EventType event_type) {
//		this.event_type = event_type;
//	}
//
//
//
//	public double calculate_total_revenue() {
//		return ((this.total_seats-this.available_seats)*ticket_price);
//	}
//	
//	public int getBookedNoOfTickets() {
//		return this.total_seats-this.available_seats;
//	}
//	
//	public void book_tickets(int num_tickets) {
//		if(num_tickets<=this.available_seats) {
//			this.available_seats-=num_tickets;
//			System.out.println(num_tickets+" tickets booked for "+event_name);
//		}
//		else {
//			System.out.println(num_tickets+" tickets are not available");
//		}
//	}
//	
//	public void cancel_booking(int num_tickets) {
//		this.available_seats+=num_tickets;
//		System.out.println(this.available_seats+" tickets are available seats");
//	}
//	
//	public void display_event_details() {
//		System.out.println("Customer Details");
//		customer.display_customer_details();
//		System.out.println("Event details");
//		System.out.println("Event name:"+this.event_name);
//		System.out.println("Event date:"+this.event_date);
//		System.out.println("Event time:"+this.event_time);
//		System.out.println("Seats Available:"+this.available_seats);
//	}
//	
//
//}
//
//
//
//
