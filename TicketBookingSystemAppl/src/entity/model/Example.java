//package entity.model;
//
//import java.sql.Date;
//import java.sql.Time;
//
//// Abstract Event class
//	abstract class Event {
//	    protected String eventName;
//	    protected int totalSeats;
//	    protected int bookedSeats;
//
//	    public Event(String eventName, int totalSeats) {
//	        this.eventName = eventName;
//	        this.totalSeats = totalSeats;
//	        this.bookedSeats = 0;
//	    }
//
//	    public Event(String event_name, Date event_date, Time event_time, String venue_name, int total_seats,
//				int available_seats, double ticket_price, String event_type) {
//			// TODO Auto-generated constructor stub
//		}
//
//		public abstract void displayEventDetails();
//
//	    public boolean bookTickets(int numTickets) {
//	        if (availableSeats() >= numTickets) {
//	            bookedSeats += numTickets;
//	            return true;
//	        } else {
//	            System.out.println("Not enough seats available for booking.");
//	            return false;
//	        }
//	    }
//
//	    public int availableSeats() {
//	        return totalSeats - bookedSeats;
//	    }
//	}
//
//	// Concrete Movie class
//	class Movie extends Event {
//	    private String movieGenre;
//
//	    public Movie(String eventName, int totalSeats, String movieGenre) {
//	        super(eventName, totalSeats);
//	        this.movieGenre = movieGenre;
//	    }
//
//	    @Override
//	    public void displayEventDetails() {
//	        System.out.println("Movie: " + eventName + ", Genre: " + movieGenre);
//	    }
//	}
//
//	// Concrete Concert class
//	class Concert extends Event {
//	    private String artistName;
//
//	    public Concert(String eventName, int totalSeats, String artistName) {
//	        super(eventName, totalSeats);
//	        this.artistName = artistName;
//	    }
//
//	    @Override
//	    public void displayEventDetails() {
//	        System.out.println("Concert: " + eventName + ", Artist: " + artistName);
//	    }
//	}
//
//	// Concrete Sport class
//	class Sport extends Event {
//	    private String sportType;
//
//	    public Sport(String eventName, int totalSeats, String sportType) {
//	        super(eventName, totalSeats);
//	        this.sportType = sportType;
//	    }
//
//	    @Override
//	    public void displayEventDetails() {
//	        System.out.println("Sport Event: " + eventName + ", Type: " + sportType);
//	    }
//	}
//
//	// Abstract BookingSystem class
//	abstract class BookingSystem {
//	    public abstract void createEvent(String eventType, String eventName, int totalSeats, String additionalInfo);
//	    public abstract boolean bookTickets(String eventName, int numTickets);
//	    public abstract void cancelTickets(String eventName, int numTickets);
//	    public abstract int getAvailableSeats(String eventName);
//	}
//
//	// Concrete TicketBookingSystem class
//	class TicketBookingSystem extends BookingSystem {
//	    private Event[] events;
//	    private int eventCount;
//
//	    public TicketBookingSystem(int maxEvents) {
//	        events = new Event[maxEvents];
//	        eventCount = 0;
//	    }
//
//	    @Override
//	    public void createEvent(String eventType, String eventName, int totalSeats, String additionalInfo) {
//	        Event event;
//	        switch (eventType.toLowerCase()) {
//	            case "movie":
//	                event = new Movie(eventName, totalSeats, additionalInfo);
//	                break;
//	            case "concert":
//	                event = new Concert(eventName, totalSeats, additionalInfo);
//	                break;
//	            case "sport":
//	                event = new Sport(eventName, totalSeats, additionalInfo);
//	                break;
//	            default:
//	                System.out.println("Invalid event type.");
//	                return;
//	        }
//	        events[eventCount++] = event;
//	        System.out.println(eventType + " event created: " + eventName);
//	    }
//
//	    @Override
//	    public boolean bookTickets(String eventName, int numTickets) {
//	        for (Event event : events) {
//	            if (event != null && event.eventName.equals(eventName)) {
//	                return event.bookTickets(numTickets);
//	            }
//	        }
//	        System.out.println("Event not found.");
//	        return false;
//	    }
//
//	    @Override
//	    public void cancelTickets(String eventName, int numTickets) {
//	        for (Event event : events) {
//	            if (event != null && event.eventName.equals(eventName)) {
//	                event.bookedSeats -= numTickets;
//	                System.out.println(numTickets + " tickets canceled for " + eventName);
//	                return;
//	            }
//	        }
//	        System.out.println("Event not found.");
//	    }
//
//	    @Override
//	    public int getAvailableSeats(String eventName) {
//	        for (Event event : events) {
//	            if (event != null && event.eventName.equals(eventName)) {
//	                return event.availableSeats();
//	            }
//	        }
//	        System.out.println("Event not found.");
//	        return -1;
//	    }
//	}
//
//	// Main class with simple user interface
//	public class Main {
//	    public static void main(String[] args) {
//	        TicketBookingSystem bookingSystem = new TicketBookingSystem(10); // Maximum 10 events
//
//	        // Sample usage
//	        bookingSystem.createEvent("movie", "Avengers: Endgame", 100, "Action");
//	        bookingSystem.createEvent("concert", "Live Concert", 200, "Artist ABC");
//	        bookingSystem.createEvent("sport", "Football Match", 50, "Soccer");
//
//	        // User interface (command-line)
//	        boolean running = true;
//	        while (running) {
//	            System.out.println("\nEnter a command: (create_event, book_tickets, cancel_tickets, get_available_seats, exit)");
//	            // Assuming input format: command eventName additionalInfo/numTickets
//	            // For example: book_tickets Avengers: Endgame 5
//	            String[] input = new java.util.Scanner(System.in).nextLine().split(" ");
//	            String command = input[0];
//
//	            switch (command.toLowerCase()) {
//	                case "create_event":
//	                    if (input.length >= 4) {
//	                        bookingSystem.createEvent(input[1], input[2], Integer.parseInt(input[3]), input.length > 4 ? input[4] : "");
//	                    } else {
//	                        System.out.println("Invalid command format.");
//	                    }
//	                    break;
//	                case "book_tickets":
//	                    if (input.length == 3) {
//	                        bookingSystem.bookTickets(input[1], Integer.parseInt(input[2]));
//	                    } else {
//	                        System.out.println("Invalid command format.");
//	                    }
//	                    break;
//	                case "cancel_tickets":
//	                    if (input.length == 3) {
//	                        bookingSystem.cancelTickets(input[1], Integer.parseInt(input[2]));
//	                    } else {
//	                        System.out.println("Invalid command format.");
//	                    }
//	                    break;
//	                case "get_available_seats":
//	                    if (input.length == 2) {
//	                        int availableSeats = bookingSystem.getAvailableSeats(input[1]);
//	                        if (availableSeats >= 0) {
//	                            System.out.println("Available seats for " + input[1] + ": " + availableSeats);
//	                        }
//	                    } else {
//	                        System.out.println("Invalid command format.");
//	                    }
//	                    break;
//	                case "exit":
//	                    running = false;
//	                    break;
//	                default:
//	                    System.out.println("Invalid command.");
//	            }
//	        }
//	    }
//	}
//
