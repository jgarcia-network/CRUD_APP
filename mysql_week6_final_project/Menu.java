package CRUD_APP;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Menu {
	
	private CarDao carDao = new CarDao();
	private CustomerDao customerDao = new CustomerDao();
	private OrderDao orderDao = new OrderDao();
	private int carIndex = 1;
	
	private Scanner scanner = new Scanner(System.in);
	private List<String> options = Arrays.asList("Display Order", "Create Order", "Edit Order", "Delete Order", "Exit");
	
	
	public void start() {
		String selection = "";
		
		do {
			printMenu();
			selection = scanner.nextLine();
			
			try {
			if (selection.equals("1")) {
				displayOrders();
			} else if (selection.equals("2")) {
				createOrder();
			} else if (selection.equals("3")) {
				//editOrder();
			} else if (selection.equals("4")) {
				//deleteOrder();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
			System.out.println("Press enter to continue....");
			scanner.nextLine();
			
		} while (!selection.equals("5"));
	}
	
	private void printMenu() {
		System.out.println("## Vehicle Purchase Order ##\n\nSelect an option...\n");
		for (int i = 0; i < options.size(); i++) {
			System.out.println(i + 1 + ". " + options.get(i));
		}
	}
	
	private void displayCars() throws SQLException {
		List<Car> cars = carDao.getCars();
		for (Car car : cars) {
		System.out.println(carIndex + ". VIN: " + car.getVin() + ", YEAR: " + car.getYear() + ", MAKE: " + car.getMake() + ", MODEL: " + car.getModel() + ", PRICE: $" + car.getPrice());
		//String s = "VIN: " + car.getVin() + ", YEAR: " + car.getYear() + ", MAKE: " + car.getMake() + ", MODEL: " + car.getModel() + ", PRICE: $" + car.getPrice() + "\n";
		carIndex++;
		}
		carIndex = 1;
	}
	
	private void displayOrders() throws SQLException {
		List<Order> orders = orderDao.getOrders();
		for (Order order : orders) {
		System.out.println("ORDER ID: " + order.getOrderId() + ", CUSTOMER ID: " + order.getCustomerId() + ", CAR VIN: " + order.getCarVin() + ", DATE ORDERED: " + order.getDateOrdered() + ", DATE DELIVERED: " + order.getDateDelivered() + "\n");
		}
	}
	
	private void createOrder() throws SQLException {
		System.out.println("Enter customer first name:");
		String firstName = scanner.nextLine();
		System.out.println("Enter customer last name:");
		String lastName = scanner.nextLine();
		List<Car> cars = carDao.getCars();
		System.out.println("Choose car:");
		displayCars();
		String carString = scanner.nextLine();
		int car = Integer.parseInt(carString);
		
		for(int i = car; i < cars.size(); car++) {
			orderDao.createOrder(customerDao., cars.get(car).getYear(), cars.get(car).getMake(), cars.get(car).getModel(), cars.get(car).getPrice());
		}
		//orderDao.createOrder(customerId, carVin, dateOrdered, dateDelivered, total);
		System.out.println("Order created");
		displayOrders();
	}
	
	private void editOrder() throws SQLException {
		displayOrders();
		System.out.println("Enter Order ID:");
		String stringID = scanner.nextLine();
		int id = Integer.parseInt(stringID);
		System.out.println("Enter new customer first name:");
		String name = scanner.nextLine();
		System.out.println("Enter new customer last name:");
		String position = scanner.nextLine();
		//OrderDao.editOrder(name, position, id);
		System.out.println("Order succefully edited");
		displayOrders();		
	}
	
	private void deleteOrder() throws SQLException {
		displayOrders();
		System.out.println("Enter order id to delete");
		String orderID = scanner.nextLine();
		int id = Integer.parseInt(orderID);
		orderDao.deleteOrder(id);
		System.out.println("Order " +  id + " deleted");
		displayOrders();
	}


}
