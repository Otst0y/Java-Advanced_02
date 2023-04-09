package lesson2;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeMapper {
	
	public static Employee map(ResultSet result) throws SQLException {
		int id = result.getInt("id");
		String name = result.getString("name");
		String lastName = result.getString("lastName");
		
		return new Employee(id, name, lastName);
	}
}
