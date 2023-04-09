package lesson2;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MagazineMapper {
	
	public static Magazine map(ResultSet result) throws SQLException {
		int id = result.getInt("id");
		String name = result.getString("name");
		double price = result.getDouble("price");
		
		return new Magazine(id, name, price);
	}
}
