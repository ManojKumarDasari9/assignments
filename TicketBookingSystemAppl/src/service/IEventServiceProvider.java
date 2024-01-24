package service;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.util.List;

import entity.model.*;
import exception.EventNotFoundException;

public interface IEventServiceProvider {
//	Event create_event(String event_name, Date date, Time time, int venue_id, int total_seats, int available_seats, double ticket_price,
//					   String event_type) throws SQLException;

	//	Event create_event(String event_name,Date date,Time time,int total_seats,double ticket_price,String event_type,String venue) throws SQLException;
Event create_event(String event_name, Date date, Time time, int venue_id, int total_seats, double ticket_price, double ticketPrice, String event_type, int bookingId) throws SQLException;

	Event create_event(String event_name, Date date, Time time, int venue_id, int total_seats, int available_seats, double ticket_price, String event_type, int bookingId) throws SQLException;

	Event getEventDetails(int eventId) throws SQLException, EventNotFoundException;
	
	int getavailableNoOfTickets();


	List<Event> getEventList(EventFilter eventFilter) throws EventNotFoundException;
}
