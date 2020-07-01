package CRUD_APP;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDao {

	private Connection connection;
	private final String GET_ORDER_QUERY = "SELECT * FROM orders";
	private final String CREATE_ORDER_QUERY = "INSERT INTO orders(customer_id, car_vin, date_ordered, date_delivered, total) VALUES(?, ?, ?, ?, ?)";
	private final String EDIT_ORDER_QUERY = "UPDATE order SET car_vin = ?, date_ordered = ?, date_delivered = ?, total = ? WHERE customer_id = ?";
	private final String DELETE_ORDER_QUERY = "DELETE FROM orders WHERE id = ?";
	
	
	public OrderDao() {
		connection = DBConnection.getConnection();
	}
	
	public List<Order> getOrders() throws SQLException{
		ResultSet rs = connection.prepareStatement(GET_ORDER_QUERY).executeQuery();
		List<Order> orders = new ArrayList<Order>();
		
		while (rs.next()) {
			orders.add(populateOrder(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
		}
		return orders;
	}
	
	private Order populateOrder(int orderId, String customerId, String carVin, String dateOrdered, String dateDelivered, String total) {
		return new Order(orderId, customerId, carVin, dateOrdered, dateDelivered, total);
	}
	
	public void createOrder(String customerId, String carVin, String dateOrdered, String dateDelivered, String total) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(CREATE_ORDER_QUERY);
		ps.setString(1, customerId);
		ps.setString(2, carVin);
		ps.setString(3, dateOrdered);
		ps.setString(4, dateDelivered);
		ps.setString(5, total);		
		ps.executeUpdate();
		ps.close();
	}
	
	public void editOrder(String name, String position, int orderId) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(EDIT_ORDER_QUERY);
		ps.setString(1, name);
		ps.setString(2, position);
		ps.setInt(3, orderId);
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
