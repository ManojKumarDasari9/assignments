package entity.model;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import exception.EventNotFoundException;

abstract class BookingSystem{
	public List<Event>events;
	public abstract Event create_event(String event_name,Date date,Time time,int total_seats,double ticket_price,String event_type,String venue_name);
	public abstract double calculate_booking_cost(int num_tickets);
	public abstract double book_tickets(Event event,int num_tickets,ArrayList<Customer>customerList) throws EventNotFoundException;
	public abstract void cancel_booking(int bookingId);
	public abstract void display_specific_event_details(Event event);
	public abstract void display_event_details();
	 
    public int getAvailableNoOfTickets() {
        
        int totalAvailableTickets = 0;
        for (Event event : events) {
            totalAvailableTickets += event.getAvailable_seats();
        }
        return totalAvailableTickets;
    }

   
    public void getEventDetails() {
        
        for (Event event : events) {
            event.display_event_details();
        }
    }
	
	
}