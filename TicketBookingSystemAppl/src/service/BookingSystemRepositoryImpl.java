package service;

import java.sql.*;
import java.sql.Connection;
import java.time.LocalDate;

import entity.model.*;

public class BookingSystemRepositoryImpl implements IBookingSystemRepository {
	
	private Connection connection;
	
	public BookingSystemRepositoryImpl() {
		this.connection=DBUtil.getDBConn();
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




	@Override
	public double calculate_booking_cost(int num_tickets) throws SQLException {
		// TODO Auto-generated method stub

		return 0;
	}

	@Override
	public Booking book_tickets(Booking booking) throws SQLException {
		// TODO Auto-generated method stub

		String query = "INSERT INTO booking (customer_id,event_id,num_tickets,total_cost,booking_date) VALUES(?, ?, ?, ?, ?)";

		try (PreparedStatement preparedStatement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {
			//preparedStatement.setInt(1, booking.getBookingId());
			preparedStatement.setInt(1, booking.getCustomer().getCustomer_id());
			preparedStatement.setInt(2, booking.getEvent().getEvent_id());
			preparedStatement.setInt(3, booking.getNum_tickets());
			preparedStatement.setDouble(4, booking.getTotal_cost());
			preparedStatement.setDate(5, Date.valueOf(LocalDate.now()));

			preparedStatement.executeUpdate();



			ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
			if (generatedKeys.next()) {
				int bookingId = generatedKeys.getInt(1);
				booking.setBookingId(generatedKeys.getInt(1));

				String query1 = "update customer set booking_id = ? where customer_id = ?";
				PreparedStatement preparedStatement1= connection.prepareStatement(query1);
				preparedStatement1.setInt(1,bookingId);
				preparedStatement1.setInt(2,booking.getCustomer().getCustomer_id());
				preparedStatement1.executeUpdate();

				String query2="update event set booking_id = ? where event_id = ?";
				PreparedStatement preparedStatement2 = connection.prepareStatement(query2);
				preparedStatement2.setInt(1,bookingId);
				preparedStatement2.setInt(2,booking.getEvent_id());
				preparedStatement2.executeUpdate();

				return booking;
			} else {
				throw new SQLException("Booking failed, no ID obtained.");
			}
		}

	}

	@Override
	public boolean cancel_booking(int booking_id) throws SQLException {
		// TODO Auto-generated method stub
		String query = "DELETE FROM booking WHERE booking_id = ?";

		try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setInt(1, booking_id);

			int rowsAffected = preparedStatement.executeUpdate();

			return rowsAffected > 0;

		} catch (SQLException e) {
			throw new RuntimeException(e);


		}


	}

	@Override
	public Booking get_booking_details(int booking_id) throws SQLException {
		// TODO Auto-generated method stub
		String query = "SELECT * FROM Booking WHERE booking_id = ?";
		try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setInt(1, booking_id);

			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				if (resultSet.next()) {
					int customerId = resultSet.getInt("customer_id");
					int eventId = resultSet.getInt("event_id");
					int numTickets = resultSet.getInt("num_tickets");
					double totalCost = resultSet.getDouble("total_cost");
					String bookingDate = resultSet.getString("booking_date");

					return new Booking(booking_id, customerId, eventId, numTickets, totalCost, bookingDate);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}


		return null;
	}

	@Override
	public Customer getCustomerDetails(String phoneNumber) {
		//sql query to fecth custome
		String query = "SELECT * FROM Customer WHERE phone_number = ?";
		try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setString(1, phoneNumber);

			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				if (resultSet.next()) {
					int customerId = resultSet.getInt("customer_id");
					String customerName = resultSet.getString("customer_name");
					String email = resultSet.getString("email");

					// You may retrieve other customer details from the result set as needed

					// Create and return a Customer object with the retrieved details
					return new Customer(customerId,customerName, email, phoneNumber);
				}
			}
		} catch (SQLException e) {
			// Handle exceptions appropriately (log, throw, etc.)
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public Customer createCustomer(Customer customer1) {

		String query = "INSERT INTO customer (customer_name,email,phone_number) VALUES(?, ?, ?)";

		try (PreparedStatement preparedStatement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {
			//preparedStatement.setInt(1, customer1.getCustomer_id());
			preparedStatement.setString(1, customer1.getCustomer_name());
			preparedStatement.setString(2, customer1.getEmail());
			preparedStatement.setString(3, customer1.getPhone_number());


			preparedStatement.executeUpdate();

			ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
			if (generatedKeys.next()) {
				customer1.setCustomer_id(generatedKeys.getInt(1));
				return customer1;
			} else {
				throw new SQLException("Booking failed, no ID obtained.");
			}
		} catch (SQLException e) {
            throw new RuntimeException(e);
        }
       // return customer1;
	}

}
