package CRUD_APP;

public class Car {
	
	private String vin;
	private String year;
	private String make;
	private String model;
	private String price;
	
	public Car(String vin, String year, String make, String model, String price) {
		this.setVin(vin);
		this.setYear(year);
		this.setMake(make);
		this.setModel(model);
		this.setPrice(price);
	}

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}
	
	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}
	
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}
	
	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
}
