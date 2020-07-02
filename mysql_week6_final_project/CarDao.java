package CRUD_APP;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarDao {

	private Connection connection;
	private final String GET_CAR_QUERY = "SELECT * FROM cars";
	//Should not be hardcoded. What is proper way to do this?
	//private final String SOLD_CARS = "SELECT * FROM cars WHERE sold = 1";
	//private final String UNSOLD_CARS = "SELECT * FROM cars WHERE sold = 0";
	private final String SET_SOLD_STATUS_CAR = "UPDATE cars SET sold = ? WHERE vin = ?";
	
	
	public CarDao() {
		connection = DBConnection.getConnection();
	}
	
	public List<Car> getCars() throws SQLException{
		ResultSet rs = connection.prepareStatement(GET_CAR_QUERY).executeQuery();
		List<Car> cars = new ArrayList<Car>();
		
		
		while (rs.next()) {
			cars.add(populateCar(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getBoolean(6)));
		}
		return cars;
	}
	
	public List<Car> soldCars() throws SQLException{
		ResultSet rs = connection.prepareStatement(GET_CAR_QUERY).executeQuery();
		List<Car> cars = new ArrayList<Car>();
		
		
		while (rs.next()) {
			cars.add(populateCar(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getBoolean(6)));
		}
		return cars;
	}
	
	public List<Car> unsoldCars() throws SQLException{
		ResultSet rs = connection.prepareStatement(GET_CAR_QUERY).executeQuery();
		List<Car> cars = new ArrayList<Car>();
		
		
		while (rs.next()) {
			cars.add(populateCar(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getBoolean(6)));
		}
		return cars;
	}
	
	private Car populateCar(String vin, String year, String make, String model, String price, Boolean sold) {
		return new Car(vin, year, make, model, price, sold);
	}
	
	public void soldStatus(Boolean status, String vin) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(SET_SOLD_STATUS_CAR);
		ps.setBoolean(1, status);
		ps.setString(2, vin);
		ps.executeUpdate();
		ps.close();
	}
	
}
