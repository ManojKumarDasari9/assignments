package service;

import entity.EventFactory;
import entity.model.Event;
import entity.model.EventFilter;
import entity.model.EventType;
import exception.EventNotFoundException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EventRepositoryImpl implements IEventRepository {

    private Connection connection;

    public EventRepositoryImpl() {
        this.connection=DBUtil.getDBConn();
    }

    @Override
    public Event create_event(Event event) throws EventNotFoundException {
        // TODO Auto-generated method stub

        String query = "INSERT INTO event (event_name, event_date, event_time, venue_id, total_seats, available_seats, ticket_price, event_type,booking_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try(PreparedStatement preparedStatement=connection.prepareStatement(query)){


            if (event.getEvent_name() != null) {
                preparedStatement.setString(1,event.getEvent_name());

            } else {

//				throw new IllegalArgumentException("Event name cannot be null");
            }
            //preparedStatement.setInt(1, event.getEvent_id());
            preparedStatement.setDate(2,event.getEvent_date());
            preparedStatement.setTime(3, event.getEvent_time());
            //
            preparedStatement.setInt(4, event.getVenue_id());
            preparedStatement.setInt(5, event.getTotal_seats());
            preparedStatement.setInt(6,event.getAvailable_seats());
            preparedStatement.setDouble(7, event.getTicket_price());
            preparedStatement.setString(8, String.valueOf(event.getEvent_type()));
//			preparedStatement.setString(9, event.getVenue_name());
			preparedStatement.setInt(9,event.getBookingId());



            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
//        catch (EventNotFoundException e){
//            e.printStackTrace();
//        }

        return event;
    }

    @Override
    public Event getEventDetails(int event_id) throws SQLException {
        // TODO Auto-generated method stub
        List<Event> events = new ArrayList<>();
        String query = "SELECT * FROM event where event_id =?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1,event_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                String eventType = resultSet.getString("event_type");


                Event event =EventFactory.getEvent(resultSet.getString("event_name"),
                        resultSet.getDate("event_date"),
                        resultSet.getTime("event_time"),
                        resultSet.getInt("venue_id"),
                        resultSet.getInt("total_seats"),
                        resultSet.getInt("available_seats"),
                        resultSet.getDouble("ticket_price"),
                        EventType.valueOf(resultSet.getString("event_type")));
                event.setEvent_id(resultSet.getInt("event_id"));
                return event;
            }
        }
        return null;
    }


    @Override
    public int getAvailableNoOfTickets(int event_id) throws SQLException {
        String query = "SELECT available_seats FROM event WHERE event_id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, event_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt("available_seats");
            }
        }
        return 0;
    }


    @Override
    public List<Event> getEventList(EventFilter eventFilter) throws SQLException {
        // TODO Auto-generated method stub
        List<Event> events= new ArrayList<>();
        String query= "SELECT * FROM event ";
        query = createSqlFilter(query, eventFilter);

        try(PreparedStatement preparedStatement =connection.prepareStatement(query)){
            ResultSet resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){

                Event event = EventFactory.getEvent( resultSet.getString("event_name"),
                        resultSet.getDate("event_date"),
                        resultSet.getTime("event_time"),
                        resultSet.getInt("venue_id"),
                        resultSet.getInt("total_seats"),
                        resultSet.getInt("available_seats"),
                        resultSet.getDouble("ticket_price"),
                        EventType.valueOf(resultSet.getString("event_type")));
                event.setEvent_id(resultSet.getInt("event_id"));
                events.add(event);
            }
        }

        return events;
    }

    @Override
    public void updateAvailableSeats(int eventId, int i) {

    }


    private String createSqlFilter(String query, EventFilter eventFilter) {
        StringBuffer sb = new StringBuffer();
        if (eventFilter.getEvent_type() != null){
            sb.append("where event_type = '"+ eventFilter.getEvent_type()+"'");
        }
        switch (eventFilter.getEvent_type()){
            case Movie :

        }
        return query + sb.toString();
    }
}
