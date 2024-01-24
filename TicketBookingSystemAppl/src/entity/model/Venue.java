package entity.model;

public class Venue {
	private Customer customer;
	private String venue_name;
	private String address;
	
	public Venue() {
		
	}
	
	public Venue(String venue_name,String address,String customer_name,String email,String phone_number) {
		this.venue_name=venue_name;
		this.address=address;
		this.customer=new Customer(customer_name,email,phone_number);
	}
	
	
	
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getVenue_name() {
		return venue_name;
	}

	public void setVenue_name(String venue_name) {
		this.venue_name = venue_name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setVenue(String venue_name,String address) {
		this.venue_name=venue_name;
		this.address=address;
	}
	
	public void display_venue_details() {
		System.out.println("Customer Details");
		customer.display_customer_details();
		System.out.println("Venue:"+this.venue_name);
		System.out.println("Address:"+this.address);
	}

}
