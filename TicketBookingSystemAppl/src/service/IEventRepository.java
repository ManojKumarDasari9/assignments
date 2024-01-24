package service;

import entity.model.Event;
import entity.model.EventFilter;
import exception.EventNotFoundException;

import java.sql.SQLException;
import java.util.List;

public interface IEventRepository {

    Event create_event(Event event) throws SQLException, EventNotFoundException;
    Event getEventDetails(int eventName) throws SQLException;

//    int getAvailableNoOfTickets() throws SQLException;

    int getAvailableNoOfTickets(int event_id) throws SQLException;

    List<Event> getEventList(EventFilter eventFilter) throws SQLException;

    void updateAvailableSeats(int eventId, int i);
}
