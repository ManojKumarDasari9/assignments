package entity;

import entity.model.*;

import java.sql.Date;
import java.sql.Time;

public class EventFactory {

    public static Event getEvent(String event_name, Date date, Time time, int venue_id, int total_seats, int available_seats, double ticket_price, EventType event_type){
        switch (event_type) {
            case Movie:
                return new Movie(event_name, date, time, venue_id, total_seats,available_seats, ticket_price, event_type);
            case Concert:
                return new Concert(event_name, date, time, venue_id, total_seats,available_seats, ticket_price, event_type);
            case Sports:
                return new Sports(event_name, date, time, venue_id, total_seats,available_seats, ticket_price, event_type);
            default:
                return null;
        }

    }

    public static Event getEvent(String event_name, Date date, Time time, int venue_id, int total_seats, int available_seats, double ticket_price, EventType event_type, int booking_id) {
        switch (event_type) {
            case Movie:
                return new Movie(event_name, date, time, venue_id, total_seats,available_seats, ticket_price, event_type,booking_id);
            case Concert:
                return new Concert(event_name, date, time, venue_id, total_seats,available_seats, ticket_price, event_type,booking_id);
            case Sports:
                return new Sports(event_name, date, time, venue_id, total_seats,available_seats, ticket_price, event_type,booking_id);
            default:
                return null;
        }
    }
}
