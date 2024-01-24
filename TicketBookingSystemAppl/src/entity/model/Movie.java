package entity.model;

import java.sql.Date;
import java.sql.Time;

public class Movie extends Event {
	private Customer customer;

	private MovieDetails movieDetails;

//	public Movie(String event_name, Date event_date, Time event_time, int venue_id, int total_seats,int available_seats, double ticket_price, String event_type) {
//		super(event_name, event_date, event_time, venue_id, total_seats, available_seats, ticket_price, event_type);
//	}

	public Movie(String eventName, Date date, Time time, int venueId, int totalSeats, double ticketPrice, String eventType) {
		super();
	}

	public Movie(String event_name, Date event_date, Time event_time, int venue_id, int total_seats,int available_seats, double ticket_price, EventType event_type) {
		super(event_name, event_date, event_time, venue_id, total_seats, available_seats, ticket_price, event_type);
	}

	public Movie(String event_name, Date event_date, Time event_time, int venue_id, int total_seats, int available_seats, double ticket_price, EventType event_type, int booking_id) {
		super(event_name, event_date, event_time, venue_id, total_seats, available_seats, ticket_price, String.valueOf(event_type),booking_id);
	}

	public MovieDetails getMovieDetails() {
		return movieDetails;
	}

	public void setMovieDetails(MovieDetails movieDetails) {
		this.movieDetails = movieDetails;
	}

	public Movie(String event_name, Date event_date, Time event_time, String venue_name, int total_seats,  double ticket_price, String event_type){//,String genre,String actor_name,String actress_name){//,String customer_name,String email,String phone_number) {
		super(event_name,event_date,event_time,venue_name,total_seats,ticket_price,event_type);
		/*this.genre=genre;
		this.actor_name=actor_name;
		this.actress_name=actress_name;*/
		//this.customer=new Customer(customer_name,email,phone_number);

	}
	
	
	
	public Customer getCustomer() {
		return customer;
	}



	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


//
//	public String getGenre() {
//		return genre;
//	}
//
//
//
//	public void setGenre(String genre) {
//		this.genre = genre;
//	}
//
//
//
//	public String getActor_name() {
//		return actor_name;
//	}
//
//
//
////	public void setActor_name(String actor_name) {
////		this.actor_name = actor_name;
////	}
//
//
//
//	public String getActress_name() {
//		return actress_name;
//	}
//
//
//
//	public void setActress_name(String actress_name) {
//		this.actress_name = actress_name;
//	}
//
//
//
//	public void setMovie(String genre,String actor_name,String actress_name) {
//		this.genre=genre;
//		this.actor_name=actor_name;
//		this.actress_name=actress_name;
//	}
	
	@Override
	public void display_event_details() {
//		System.out.println("Customer Details");
//		customer.display_customer_details();
		//super.display_event_details();
		System.out.println("Event Details");
		System.out.println("Event details");
		System.out.println("Event name:"+super.event_name);
		System.out.println("Event date:"+super.event_date);
		System.out.println("Event time:"+super.event_time);
		System.out.println("Seats Available:"+super.available_seats);
		/*System.out.println("genre:"+this.genre);
		System.out.println("Actor Name:"+this.actor_name);
		System.out.println("Actress Name:"+this.actress_name);*/
	}



}
