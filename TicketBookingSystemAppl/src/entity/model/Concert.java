package entity.model;

import java.sql.Date;
import java.sql.Time;

public class Concert extends Event{
	private Customer customer;
	private String artist;
	private String type;
	
	


//	public Concert(String event_name, Date event_date, Time event_time, int venue_id, int total_seats,int available_seats, double ticket_price, String event_type) {
//		super(event_name, event_date, event_time, venue_id, total_seats, available_seats, ticket_price, event_type);
//	}

	public Concert(String event_name, Date event_date, Time event_time, int venue_id, int total_seats, int available_seats, double ticket_price, EventType event_type, int booking_id) {
		super(event_name, event_date, event_time, venue_id, total_seats, available_seats, ticket_price, String.valueOf(event_type),booking_id);
	}

	public Concert(String event_name, Date event_date, Time event_time, int venue_id, int total_seats,int available_seats, double ticket_price, EventType event_type) {
		super(event_name, event_date, event_time, venue_id, total_seats, available_seats, ticket_price, event_type);
	}



	
	public Customer getCustomer() {
		return customer;
	}



	public void setCustomer(Customer customer) {
		this.customer = customer;
	}



	public String getArtist() {
		return artist;
	}



	public void setArtist(String artist) {
		this.artist = artist;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public void setConcert(String artist,String type) {
		this.artist=artist;
		this.type=type;
		
	}
	
	
	public void display_concert_details() {
//		System.out.println("Customer Details");
//		customer.display_customer_details();
		//super.display_event_details();
		System.out.println("Event Details");
		//System.out.println("Event details");
		System.out.println("Event name:"+super.event_name);
		System.out.println("Event date:"+super.event_date);
		System.out.println("Event time:"+super.event_time);
		System.out.println("Seats Available:"+super.available_seats);
//		System.out.println("Artist:"+this.artist);
//		System.out.println("type:"+this.type);
	}



	@Override
	public void display_event_details() {
		// TODO Auto-generated method stub
		this.display_concert_details();
		
	}

}
