package entity.model;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import exception.EventNotFoundException;
import exception.InvalidBookingIDException;
import service.*;

public class TicketBookingSystem extends BookingSystem{
	
	private ArrayList<Event> events;
	private ArrayList<Booking> bookings;
	private ArrayList<String>existingEvents;
	public TicketBookingSystem() {
		this.events=new ArrayList<>();
	}
	
	
	public ArrayList<Event> getEvents() {
		return events;
	}


	public void setEvents(ArrayList<Event> events) {
		this.events = events;
	}


	public ArrayList<Booking> getBookings() {
		return bookings;
	}


	public void setBookings(ArrayList<Booking> bookings) {
		this.bookings = bookings;
	}


	public Event create_event(String event_name,Date date,Time time,int venue_id,int total_seats,int available_seats,double ticket_price,String event_type) throws SQLException {

//		Scanner scan=new Scanner(System.in);
//		Event event = null;
//		Movie movie=null;
//		Concert concert=null;
//		Sports sports=null;
//		Customer customer=null;
////		String customer_name=scan.nextLine();
////		String email=scan.nextLine();
////		String phone_number=scan.nextLine();
//
//
//		switch(event_type.toLowerCase()) {
//		case "movie":
//
//
//		event=new Movie(event_name,date,time,venue_id,total_seats,available_seats,ticket_price,event_type,bookingId);
//
//			break;
//
//		case "concert":
//			event=new Concert(event_name,date,time,venue_id,total_seats,available_seats,ticket_price,event_type,bookingId);
//
//			break;
//
//		case "sport":
//				event=new Sports(event_name,date,time,venue_id,total_seats,available_seats,ticket_price,event_type,bookingId);
//
//			break;
//
//		default:
//			System.out.println("Enter valid event type");
//
//		}
//		if(event!=null) {
//			events.add(event);
//			BookingSystemRepositoryImpl bookingSystemRepository= new BookingSystemRepositoryImpl();
//		}
		return null;
		
	}
	
	public void display_event_details(Event event) {
		if(event!=null) {
			event.display_event_details();
		}
	}
	
	
	public double book_tickets(Event event, int num_tickets) throws EventNotFoundException {
	    if (event != null) {
	        int available_seats = event.getAvailable_seats();
	        for (String s : existingEvents) {
	            if (event.getEvent_name().equalsIgnoreCase(s)) {
	                if (num_tickets > 0 && num_tickets <= available_seats) {
	                    event.setAvailable_seats(available_seats - num_tickets);

	                    double total_cost = event.getTicket_price() * num_tickets;
	                    System.out.println("Tickets Booked Successfully for " + event.getEvent_name());
	                    System.out.println("Total cost: " + total_cost);
	                    return total_cost;
	                } else {
	                    System.out.println("Invalid number of tickets");
	                }
	            }
	        }
	        throw new EventNotFoundException("Event Not Found");
	    } else {
	        throw new EventNotFoundException("Invalid event");
	    }

	}

	
	
	public void cancel_tickets(Event event,int num_tickets) {
		if(event!=null) {
			int available_seats=event.getAvailable_seats();
			event.setAvailable_seats(available_seats+num_tickets);
			
		}
	}
	public static void main(String[] args) throws EventNotFoundException, SQLException {
		//TicketBookingSystem ticketBookingSystem = new TicketBookingSystem();

		BookingSystemServiceProviderImpl bookingSystemServiceProvider = new BookingSystemServiceProviderImpl();
		BookingSystemRepositoryImpl bookingSystemRepository= new BookingSystemRepositoryImpl();
		TicketBookingSystem ticketBookingSystem = new TicketBookingSystem();
		Event event=null;
        Scanner scanner = new Scanner(System.in);
		boolean exit = false;
        while (!exit) {
            System.out.println("Enter command: (1.create an event,  2.Book tickets, 3. Available tickets, 4.All events, 5. Cancel tickets, 6. exit)");
            int command = scanner.nextInt();
			Event createdEvent = null;
            switch (command) {
                case 1:
                    System.out.println("Enter event details:");
                    System.out.println("Event Name:");
                    String eventName = scanner.next();
                    System.out.println("Date (YYYY-MM-DD):");
                    Date date = parseDate(scanner.next()); 
                    System.out.println("Time (HH:MM:SS):");
                    Time time = parseTime(scanner.next());
					//
					System.out.println("Venue id");
					int venueId=scanner.nextInt();
                    System.out.println("Total Seats:");
                    int totalSeats = scanner.nextInt();
					//
					System.out.println("Available Seats:");
					int availableSeats = scanner.nextInt();
                    System.out.println("Ticket Price:");
                    double ticketPrice = scanner.nextDouble();
                    System.out.println("Event Type (movie, concert, sport):");
                    String eventType = scanner.next();
					//
					System.out.println("Venue name");
					String venueName=scanner.next();
					System.out.println("Booking Id");
					int bookingId=scanner.nextInt();
					try{
						createdEvent = bookingSystemServiceProvider.create_event(eventName, date, time,venueId, totalSeats, availableSeats,ticketPrice, eventType,bookingId);

					} catch (SQLException e) {
						throw new RuntimeException(e);

					}
					System.out.println("Event created successfully:");
                    createdEvent.display_event_details();
                    break;

//
                case 2:

                    System.out.println("Enter event type for booking:");
                    EventType eventType2 = EventType.valueOf(scanner.next());

					EventFilter eventFilter = new EventFilter();

					eventFilter.setEvent_type(eventType2);


					List<Event> events = bookingSystemServiceProvider.getEventList(eventFilter);

					System.out.println("------------------events are:" );

					System.out.println(events.stream().map(e-> (e.getEvent_id() + " --- " +e.event_name)).collect(Collectors.toList()));

					System.out.println("Enter event Id");

					int eventId = scanner.nextInt();

					System.out.println("Enter booking date");
					Date date1 = parseDate(scanner.next());
					Event bookEvent = bookingSystemServiceProvider.getEventDetails(eventId);

					System.out.println(bookEvent);

					if (bookEvent.getAvailable_seats() == 0){
						System.out.println("Tickets sold out");
						continue;
					}


					System.out.println("Enter No of tickets");

					int ticketsToBook = scanner.nextInt();

					if (ticketsToBook> bookEvent.getAvailable_seats()){
						System.out.println(ticketsToBook+" Tickets not available");

						System.out.println("Enter not more than available tickets");
						ticketsToBook = scanner.nextInt();

						if (ticketsToBook> bookEvent.getAvailable_seats()){
							System.out.println(ticketsToBook+" Tickets not available, please start from begining");
							continue;
						}
					}

					System.out.println("Tickets cost : " + bookEvent.getTicket_price() * ticketsToBook);
					System.out.println("confirm:");

					String confirmed = scanner.next();

					if (!confirmed.equals("y")){
						continue;
					}

					System.out.println("Enter customer details for ticket: ");
					System.out.println("Enter customer id");
					int customerId=scanner.nextInt();
					System.out.println("Customer Name");
					String customerName= scanner.next();
					System.out.println("Email");
					String email= scanner.next();
					System.out.println("Phone Number");
					String phonenumber=scanner.next();

					Customer cus=new Customer();
					cus.setCustomer(customerName,email,phonenumber);
					Customer customer=cus.getCustomer();
//
					Booking booking = bookingSystemServiceProvider.book_tickets(bookEvent, ticketsToBook, customer);

					System.out.println("Tickets booked");

					//exit=true;
					break;


				case 3:
					System.out.println("Enter event id to check available tickets");
					int event_id=scanner.nextInt();
					EventRepositoryImpl eventRepository=new EventRepositoryImpl();
					int available_tickets=eventRepository.getAvailableNoOfTickets(event_id);
					System.out.println("Available Tickets for the event id "+event_id+" :"+available_tickets);
					break;

                case 4:
                    System.out.println("All Events:");
					System.out.println("Enter event type for booking:");
					EventType eventType3 = EventType.valueOf(scanner.next());

					EventFilter eventFilter2 = new EventFilter();
					eventFilter2.setEvent_type(eventType3);
					List<Event> events2 = bookingSystemServiceProvider.getEventList(eventFilter2);
					System.out.println("------------------events are:" );
					System.out.println(events2.stream().map(e-> (e.getEvent_id() + " --- " +e.event_name)).collect(Collectors.toList()));


					break;
				case 5:
					System.out.println("Enter Bookind id");
					int bookingId1 = scanner.nextInt();
					Booking bookingCanceled= bookingSystemServiceProvider.cancel_booking(bookingId1);
					System.out.println("No of tickets canceled : "+bookingCanceled.getNum_tickets()+" , refund : "+bookingCanceled.getTotal_cost());
                	//exit=true;
					break;

					case 6:
                    System.out.println("Exiting the ticket booking system.");
                    scanner.close();
					exit=true;
                    break;

                default:
                    System.out.println("Invalid command. Please enter a valid command.");
                    break;
            }
        }
	}
	
	 private static Date parseDate(String dateString) {
         SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
         try {
             return new java.sql.Date(dateFormat.parse(dateString).getTime());
         } catch (ParseException e) {
             e.printStackTrace();
             return null;
         }
     }
	 
	 private static Time parseTime(String timeString) {
		Time.valueOf(timeString);
		    SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
		    try {
		        timeFormat.parse(timeString);
		        return new Time(timeFormat.parse(timeString).getTime());
		    } catch (ParseException e) {
		        e.printStackTrace();
		        return null;
		    }
		}

	@Override
	public void display_specific_event_details(Event event) {
		// TODO Auto-generated method stub
		event.display_event_details();
	}

	@Override
	public void display_event_details() {
		// TODO Auto-generated method stub
		display_event_details();
		
	}

	@Override
	public Event create_event(String event_name, Date date, Time time, int total_seats, double ticket_price, String event_type, String venue_name) {
		return null;
	}

	@Override
	public double calculate_booking_cost(int num_tickets) {
		// TODO Auto-generated method stub
		Event event=null;
		double total_cost=event.getTicket_price()*num_tickets;
		return total_cost;
	}

	 @Override
	    public double book_tickets(Event event, int num_tickets, ArrayList<Customer> customerList) {
	        
	        if (event.getAvailable_seats() >= num_tickets) {
	            double totalCost = num_tickets * event.getTicket_price();

	            
	            event.setAvailable_seats(event.getAvailable_seats() - num_tickets);

	            Booking booking = new Booking();
	            booking.setBookingId(bookings.size() + 1);
	            booking.setEvent(event);
	            booking.setNum_tickets(num_tickets);
	            booking.setTotal_cost(totalCost);
	            booking.setBooking_date(new Date(LocalDate.now().toEpochDay()));
	            booking.setCustomers(customerList);

	            bookings.add(booking);

	            return totalCost;
	        } else {
	            System.out.println("Not enough available seats for booking.");
	            return 0;
	        }
	    }


	    @Override
	    public void cancel_booking(int bookingId) {
	        try {
	        Booking bookingToRemove = null;
	        for (Booking booking : bookings) {
	            if (booking.getBookingId() == bookingId) {
	                bookingToRemove = booking;
	                break;
	            }
	        }

	        
	        if (bookingToRemove != null) {
	            Event event = bookingToRemove.getEvent();
	            event.setAvailable_seats(event.getAvailable_seats() + bookingToRemove.getNum_tickets());

	            bookings.remove(bookingToRemove);
	            System.out.println("Booking canceled successfully.");
	        } else {
	           throw new InvalidBookingIDException("Booking not found with ID: " + bookingId);
	        }
	        }
	        catch(InvalidBookingIDException e) {
	        	System.out.println(e.getMessage());
	        }
	    }

		public Booking get_booking_details(int booking_id) {
			for(Booking b: bookings) {
				if(b.getBookingId()==booking_id) {
					return b;
				}
			}
			return null;
		}



	

}
