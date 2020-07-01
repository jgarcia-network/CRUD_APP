package CRUD_APP;

public class Customer {

	private int customerId;
	private String firstName;
	private String lastName;;
	private String street;
	private String city;
	private String state;
	private String zip;
	
	public Customer(int customerId, String firstName, String lastName, String street, String city, String state, String zip) {
		this.setCustomerId(customerId);
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setStreet(street);
		this.setCity(city);
		this.setState(state);
		this.setZip(zip);
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getLastName() {
		return lastName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}
	
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}
}
