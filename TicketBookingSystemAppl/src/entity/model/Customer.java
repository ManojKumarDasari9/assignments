package entity.model;

public class Customer {
	private int customer_id;
	private String customer_name;
	private String email;
	private String phone_number;
	
	public Customer() {
		
	}
	
	public Customer(String customer_name,String email,String phone_number) {
		this.customer_name=customer_name;
		this.email=email;
		this.phone_number=phone_number;
	}

    public Customer(int customerId, String customerName, String email, String phoneNumber) {
		this.customer_id=customerId;
		this.customer_name=customerName;
		this.email=email;
		this.phone_number=phoneNumber;
    }


    public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	Customer customer=null;
	public void setCustomer(String customer_name, String email, String phone_number) {
		this.customer_name=customer_name;
		this.email=email;
		this.phone_number=phone_number;
		customer=new Customer(customer_name,email,phone_number);
	}

	public Customer getCustomer(){
		return customer;
	}
	public void display_customer_details() {
		System.out.println("Customer Name:"+this.customer_name);
		System.out.println("Email:"+this.email);
		System.out.println("Phone Number:"+this.phone_number);
	}

}
