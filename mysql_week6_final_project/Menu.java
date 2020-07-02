package CRUD_APP;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class Menu {
	
	private CarDao carDao = new CarDao();
	private CustomerDao customerDao = new CustomerDao();
	private OrderDao orderDao = new OrderDao();
	private int carIndex = 1;
	
	private Scanner scanner = new Scanner(System.in);
	private List<String> options = Arrays.asList("Display Available Vehicles", "Display Orders", "Create Order", "Edit Order", "Delete Order", "Exit");
	
	
	public void start() {
		String selection = "";
		
		do {
			printMenu();
			selection = scanner.nextLine();
			
			try {
			if (selection.equals("1")) {
				displayCars();
			} else if (selection.equals("2")) {
				displayOrders();
			} else if (selection.equals("3")) {
				createOrder();
			} else if (selection.equals("4")) {
				editOrder();
			} else if (selection.equals("5")) {
				deleteOrder();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
			System.out.println("Press enter to continue....");
			scanner.nextLine();
			
		} while (!selection.equals("6"));
	}
	
	//Timestamp
    Calendar calendar = Calendar.getInstance();
    java.sql.Timestamp timestamp = new java.sql.Timestamp(calendar.getTime().getTime());
	
	
	private void printMenu() {
		System.out.println("## Vehicle Purchase Order ##\n\nSelect an option...\n");
		for (int i = 0; i < options.size(); i++) {
			System.out.println(i + 1 + ". " + options.get(i));
		}
	}
	
	private void displayCars() throws SQLException {
		List<Car> cars = carDao.unsoldCars();
		if (!cars.isEmpty()) {
		for (Car car : cars) {
		System.out.println(carIndex + ". VIN: " + car.getVin() + ", YEAR: " + car.getYear() + ", MAKE: " + car.getMake() + ", MODEL: " + car.getModel() + ", PRICE: $" + car.getPrice());
		carIndex++;
		} 
			}else {
			System.out.println("Inventory Empty.\n");
	}
		carIndex = 1;
}
	
	private void displayOrders() throws SQLException {
		List<Order> orders = orderDao.getOrders();
		if (!orders.isEmpty()) {
		for (Order order : orders) {
		System.out.println("ORDER ID: " + order.getOrderId() + ", CUSTOMER ID: " + order.getCustomerId() + ", CAR VIN: " + order.getCarVin() + ", DATE ORDERED: " + order.getDateOrdered() + "\n");
		}
			} else {
				System.out.println("There are no orders.\n");
			}
	}
	
	private void displayCustomers() throws SQLException {
		List<Customer> customers = customerDao.getCustomers();
		System.out.println("Customers:");
		for (Customer customer : customers) {
		System.out.println("ID: " + customer.getCustomerId() + ", FIRST NAME: " + customer.getFirstName() + ", LAST NAME: " + customer.getLastName() + ", STREET: " + customer.getStreet() + ", CITY: " + customer.getCity() + ", STATE: " + customer.getState() + ", ZIP: " + customer.getZip() + "\n");
		}
	}
	
	private void createOrder() throws SQLException {
		System.out.println("**CREATE NEW ORDER**\n");
		displayCustomers();
		System.out.println("Choose customer ID:");
		String customerSelection = scanner.nextLine();
		List<Car> cars = carDao.getCars();
		System.out.println("Choose vehicle:");
		displayCars();
		String carString = scanner.nextLine();
		int carChoice = Integer.parseInt(carString)-1;
		//System.out.println(carChoice);
		
		if (carChoice <= cars.size()-1) {
			orderDao.createOrder(customerSelection, cars.get(carChoice).getVin(), timestamp.toString(), cars.get(carChoice).getPrice());
			carDao.soldStatus(true, cars.get(carChoice).getVin());
		}else {
			System.out.println("Invalid Choice. Try again.\n");
			createOrder();
		}
		System.out.println("Order created.");
		displayOrders();
	}
	
	private void editOrder() throws SQLException {
		System.out.println("Enter Order ID to edit:\n");
		displayOrders();
		String stringId = scanner.nextLine();
		int id = Integer.parseInt(stringId);
		
		System.out.println("Choose new customer:\n");
		displayCustomers();
		String customerId = scanner.nextLine();
		
		List<Car> cars = carDao.getCars();
		System.out.println("Choose new vehicle:\n");
		displayCars();
		String carString = scanner.nextLine();
		int carChoice = Integer.parseInt(carString)-1;
		System.out.println(carChoice);
		
		if (carChoice <= cars.size()-1) {
			orderDao.editOrder(customerId, cars.get(carChoice).getVin(), timestamp.toString(), cars.get(carChoice).getPrice(), id);
			carDao.soldStatus(false, cars.get(carChoice).getVin());
		}else {
			System.out.println("Invalid Choice. Try again.\n");
			createOrder();
		}
		System.out.println("Order successfully edited\n");
			displayOrders();
	}
	
	private void deleteOrder() throws SQLException {
		System.out.println("Enter Order ID to delete\n");
		displayOrders();
		String orderId = scanner.nextLine();
		int id = Integer.parseInt(orderId);
		orderDao.deleteOrder(id);		
		System.out.println("Order " + id + " deleted\n");
		displayOrders();
	}


}
