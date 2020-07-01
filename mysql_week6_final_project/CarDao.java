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
	
	
	public CarDao() {
		connection = DBConnection.getConnection();
	}
	
	public List<Car> getCars() throws SQLException{
		ResultSet rs = connection.prepareStatement(GET_CAR_QUERY).executeQuery();
		List<Car> cars = new ArrayList<Car>();
		
		
		while (rs.next()) {
			cars.add(populateCar(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
		}
		return cars;
	}
	
	private Car populateCar(String vin, String year, String make, String model, String price) {
		return new Car(vin, year, make, model, price);
	}
	
}
