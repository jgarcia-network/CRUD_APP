package CRUD_APP;

public class Order {

	private int orderId;
	private String firstName;
	private String lastName;
	private String make;
	private String model;
	private String year;
	private String dateOrdered;
	private String total;
	
	public Order(int orderId, String firstName, String lastName, String make, String model, String year, String dateOrdered, String total) {
		this.setOrderId(orderId);
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setMake(make);
		this.setModel(model);
		this.setYear(year);
		this.setDateOrdered(dateOrdered);
		this.setTotal(total);		
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getFirstName() {
		return firstName.toUpperCase();
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName.toUpperCase();
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getMake() {
		return make.toUpperCase();
	}
	
	private String setMake(String make) {
		// TODO Auto-generated method stub
		return this.make = make;
	}
	
	public String getModel() {
		return model.toUpperCase();
	}
	
	private void setModel(String model) {
		// TODO Auto-generated method stub
		this.model = model;
	}
	
	public String getYear() {
		return (year.substring(0,4));
	}

	private void setYear(String year) {
		// TODO Auto-generated method stub
		this.year = year;
	}
	
	public String getDateOrdered() {
		return dateOrdered;
	}

	public void setDateOrdered(String dateOrdered) {
		this.dateOrdered = dateOrdered;
	}	
	
	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}
	
}
