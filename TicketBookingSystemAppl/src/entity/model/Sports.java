package entity.model;

import java.sql.Time;
import java.sql.Date;

public class Sports extends Event{
	private Customer customer;
	private String sport_name;
	private String teams_name;
	
	
	



	public Sports(String event_name, Date event_date, Time event_time, String venue_name, int total_seats,double ticket_price, String event_type){//},String sport_name,String teams_name, String customer_name, String email,
			
		super(event_name, event_date, event_time, venue_name, total_seats,  ticket_price, event_type);
		// TODO Auto-generated constructor stub
		/*this.sport_name=sport_name;
		this.teams_name=teams_name;
		this.customer=new Customer(customer_name,email,phone_number);*/
	}
	public Sports(String event_name, Date event_date, Time event_time, int venue_id, int total_seats, int available_seats, double ticket_price, EventType event_type, int booking_id) {
		super(event_name, event_date, event_time, venue_id, total_seats, available_seats, ticket_price, String.valueOf(event_type),booking_id);
	}

//	public Sports(String event_name, Date event_date, Time event_time, int venue_id, int total_seats,int available_seats, double ticket_price, String event_type) {
//		super(event_name, event_date, event_time, venue_id, total_seats, available_seats, ticket_price, event_type);
//	}

	public Sports(String event_name, Date event_date, Time event_time, int venue_id, int total_seats,int available_seats, double ticket_price, EventType event_type) {
		super(event_name, event_date, event_time, venue_id, total_seats, available_seats, ticket_price, event_type);
	}



	/*public Sports(String sport_name,String teams_name,String customer_name,String email,String phone_number) {
        super(event_name, event_date, event_time, venue_name, total_seats, ticket_price, event_type);
        this.sport_name=sport_name;
		this.teams_name=teams_name;
		this.customer=new Customer(customer_name,email,phone_number);

	}*/
	
	
	
	public Customer getCustomer() {
		return customer;
	}



	public void setCustomer(Customer customer) {
		this.customer = customer;
	}



	public String getSport_name() {
		return sport_name;
	}



	public void setSport_name(String sport_name) {
		this.sport_name = sport_name;
	}



	public String getTeams_name() {
		return teams_name;
	}



	public void setTeams_name(String teams_name) {
		this.teams_name = teams_name;
	}



	public void setSports(String sport_name,String teams_name) {
		this.sport_name=sport_name;
		this.teams_name=teams_name;
	}

	public void display_sport_details() {
//		System.out.println("Customer Details");
//		customer.display_customer_details();
//		super.display_event_details();
		System.out.println("Event Details");
		//System.out.println("Event details");
		System.out.println("Event name:"+super.event_name);
		System.out.println("Event date:"+super.event_date);
		System.out.println("Event time:"+super.event_time);
		System.out.println("Seats Available:"+super.available_seats);
//		System.out.println("Sport Name:"+this.sport_name);
//		System.out.println("Teams Name:"+this.teams_name);
	}



	@Override
	public void display_event_details() {
		// TODO Auto-generated method stub
		this.display_sport_details();

	}
}
