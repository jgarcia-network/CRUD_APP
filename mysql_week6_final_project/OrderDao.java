package CRUD_APP;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDao {

	private Connection connection;
	//private final String GET_ORDER_QUERY = "SELECT * FROM orders";
	private final String CREATE_ORDER_QUERY = "INSERT INTO orders(customer_id, car_vin, date_ordered, total) VALUES(?, ?, ?, ?)";
	private final String EDIT_ORDER_QUERY = "UPDATE orders SET customer_id = ?, car_vin = ?, date_ordered = ?, total = ? WHERE id = ?";
	private final String DELETE_ORDER_QUERY = "DELETE FROM orders WHERE id = ?";
	private final String GET_ORDER_INFO = "SELECT o.id, c.first_name, c.last_name, w.make, w.model, w.year, o.date_ordered, o.total FROM customers c INNER JOIN orders o ON c.id = o.customer_id INNER JOIN cars w ON w.vin = o.car_vin";
	
	
	public OrderDao() {
		connection = DBConnection.getConnection();
	}
	
	public List<Order> getOrders() throws SQLException{
		ResultSet rs = connection.prepareStatement(GET_ORDER_INFO).executeQuery();
		List<Order> orders = new ArrayList<Order>();
		
		while (rs.next()) {
			orders.add(populateOrder(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8)));
		}
		return orders;
	}
	
	private Order populateOrder(int orderId, String firstName, String lastName, String make, String model, String year, String dateOrdered, String total) {
		return new Order(orderId, firstName, lastName, make, model, year, dateOrdered, total);
	}
	
	public void createOrder(String customerId, String carVin, String dateOrdered, String total) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(CREATE_ORDER_QUERY);
		ps.setString(1, customerId);
		ps.setString(2, carVin);
		ps.setString(3, dateOrdered);
		ps.setString(4, total);		
		ps.executeUpdate();
		ps.close();
	}
	
	public void editOrder(String customerId, String carVin, String dateOrdered, String total, int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(EDIT_ORDER_QUERY);
		ps.setString(1, customerId);
		ps.setString(2, carVin);
		ps.setString(3, dateOrdered);
		ps.setString(4, total);
		ps.setInt(5, id);
		ps.executeUpdate();
		ps.close();
	}
	
	public void deleteOrder(int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(DELETE_ORDER_QUERY);
		ps.setInt(1, id);
		ps.executeUpdate();
		ps.close();
	}
	
}
