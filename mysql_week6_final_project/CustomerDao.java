package CRUD_APP;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao {

	private Connection connection;
	private final String GET_CUSTOMER_QUERY = "SELECT * FROM customers";
	private final String CREATE_CUSTOMER_QUERY = "INSERT INTO customers(first_name, last_name, street, city, state, zip) VALUES(?, ?, ?, ?, ?, ?)";
	private final String EDIT_CUSTOMER_QUERY = "UPDATE customer SET first_name = ?, last_name = ?, street = ?, city = ?, state = ?, zip = ? WHERE id = ?";
	private final String DELETE_CUSTOMER_QUERY = "DELETE FROM customer WHERE id = ?";
	
	
	public CustomerDao() {
		connection = DBConnection.getConnection();
	}
	
	public List<Customer> getCustomers() throws SQLException{
		ResultSet rs = connection.prepareStatement(GET_CUSTOMER_QUERY).executeQuery();
		List<Customer> customers = new ArrayList<Customer>();
		
		while (rs.next()) {
			customers.add(populateCustomer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)));
		}
		return customers;
	}
	
	private Customer populateCustomer(int customerId, String firstName, String lastName, String street, String city, String state, String zip) {
		return new Customer(customerId, firstName, lastName, street, city, state, zip);
	}
	
	public void createCustomer(String firstName, String lastName, String street, String city, String state, String zip) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(CREATE_CUSTOMER_QUERY);
		ps.setString(1, firstName);
		ps.setString(2, lastName);
		ps.setString(3, street);
		ps.setString(4, city);
		ps.setString(5, state);
		ps.setString(6, zip);
		ps.executeUpdate();
		ps.close();
	}
	
	public void editCustomer(String firstName, String lastName, String street, String city, String state, String zip, int customerId) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(EDIT_CUSTOMER_QUERY);
		ps.setString(1, firstName);
		ps.setString(2, lastName);
		ps.setString(3, street);
		ps.setString(4, city);
		ps.setString(5, state);
		ps.setString(6, zip);
		ps.setInt(7, customerId);
		ps.executeUpdate();
		ps.close();
	}
	
	public void deleteCustomer(int customerId) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(DELETE_CUSTOMER_QUERY);
		ps.setInt(1, customerId);
		ps.executeUpdate();
		ps.close();
	}
	
}
