package CRUD_APP;

public class Order {

	private int orderId;
	private String customerId;
	private String carVin;
	private String dateOrdered;
	private String dateDelivered;
	private String total;
	
	public Order(int orderId, String customerId, String carVin, String dateOrdered, String dateDelivered, String total) {
		this.setOrderId(orderId);
		this.setCustomerId(customerId);
		this.setCarVin(carVin);
		this.setDateOrdered(dateOrdered);
		this.setDateDelivered(dateDelivered);
		this.setTotal(total);
		
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	
	public String getCarVin() {
		return carVin;
	}

	public void setCarVin(String carVin) {
		this.carVin = carVin;
	}
	
	public String getDateOrdered() {
		return dateOrdered;
	}

	public void setDateOrdered(String dateOrdered) {
		this.dateOrdered = dateOrdered;
	}
	
	public String getDateDelivered() {
		return dateDelivered;
	}

	public void setDateDelivered(String dateDelivered) {
		this.dateDelivered = dateDelivered;
	}
	
	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}
	
}
