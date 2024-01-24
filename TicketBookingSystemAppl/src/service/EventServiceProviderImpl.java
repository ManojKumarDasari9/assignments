package service;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import entity.EventFactory;
import entity.model.Event;
import entity.model.EventFilter;
import entity.model.EventType;
import exception.EventNotFoundException;

public class EventServiceProviderImpl implements IEventServiceProvider {

	/*public IEventRepository getRespository() {
		return repository;
	}*/

	private IEventRepository repository;

	private List<Event>events;
	
	
	public EventServiceProviderImpl() {
		super();
		this.events = new ArrayList<>();
		repository=new EventRepositoryImpl();
	}

//	@Override
//	public Event create_event(String event_name, Date date, Time time, int venue_id, int total_seats,int available_seats, double ticket_price,
//							  String event_type) throws SQLException {
//
//		Event event = EventFactory.getEvent(event_name, date, time,venue_id, total_seats, available_seats,ticket_price, EventType.valueOf(event_type));
//		//repository.create_event(e);
//		//TicketBookingSystem ticketBookingSystem=null;
//		Event event1= null;
//		try {
//			event1 = repository.create_event(event);
//		} catch (EventNotFoundException e) {
//			throw new RuntimeException(e);
//		}
//		return event1;
//	}

//	@Override
//	public Event create_event(String event_name, Date date, Time time, int total_seats, double ticket_price, String event_type, String venue) throws SQLException {
//		return null;
//	}

	@Override
	public Event create_event(String event_name, Date date, Time time, int venue_id, int total_seats, double ticket_price, double ticketPrice, String event_type, int bookingId) throws SQLException {
		return null;
	}

	@Override
	public Event create_event(String event_name, Date date, Time time, int venue_id, int total_seats, int available_seats, double ticket_price, String event_type, int bookingId) throws SQLException {
		Event event = EventFactory.getEvent(event_name, date, time,venue_id, total_seats, available_seats,ticket_price, EventType.valueOf(event_type),bookingId);
		//repository.create_event(e);
		//TicketBookingSystem ticketBookingSystem=null;
		Event event1= null;
		try {
			event1 = repository.create_event(event);
		} catch (EventNotFoundException e) {
			throw new RuntimeException(e);
		}
		return event1;

	}

	@Override
	public Event getEventDetails(int eventId) throws SQLException, EventNotFoundException {
		// TODO Auto-generated method stub
		//return events.toArray(new Event[0]);
		Event events = repository.getEventDetails(eventId);
		if (events == null){
			throw new EventNotFoundException("Event Not Found");
		}

        return events ;
    }

	@Override
	public int getavailableNoOfTickets() {
		// TODO Auto-generated method stub
	for(Event event: events) {
		int available_tickets=event.getAvailable_seats();
		}
		return 0;
	}


	@Override
	public List<Event> getEventList(EventFilter eventFilter) throws EventNotFoundException {
		List<Event> events = null;
		try {
			events = repository.getEventList(eventFilter);
		} catch (SQLException e) {
			throw new EventNotFoundException("Event Not Found");
			//throw new RuntimeException(e);
		}

		return events ;
	}

	public boolean updateTicketsBooked (Event event, int bookedTickets){
		//
		repository.updateAvailableSeats(event.getEvent_id(), event.getAvailable_seats()-bookedTickets);
		return true;
	}

	public boolean updateCancelledTicket (Event event, int bookedTickets){
		//
		repository.updateAvailableSeats(event.getEvent_id(), event.getAvailable_seats()+bookedTickets);
		return true;
	}
}
