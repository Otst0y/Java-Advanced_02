package lesson2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MagazineDao {
	private static String READ_ALL = "select * from magazine";
	private static String CREATE = "insert into magazine(`name`, `price`) values (?, ?)";
	private static String READ_BY_ID = "select * from magazine where id = ?";
	private static String UPDATE_BY_ID = "update magazine set name = ?, price = ? where id = ?";
	private static String DELETE_BY_ID = "delete from magazine where id = ?";

	private Connection connection; 
	private PreparedStatement preparedStatement;
	
	public MagazineDao(Connection connection) {
		this.connection = connection;
	}
	
	public void insert(Magazine magazine) throws SQLException {
		preparedStatement = connection.prepareStatement(CREATE);
		preparedStatement.setString(1, magazine.getName());
		preparedStatement.setDouble(2, magazine.getPrice());
		preparedStatement.executeUpdate();
	}
	
	public Magazine read(int id) throws SQLException {
		preparedStatement = connection.prepareStatement(READ_BY_ID);
		preparedStatement.setInt(1, id);
		
		ResultSet result = preparedStatement.executeQuery();
		result.next();
		return MagazineMapper.map(result);
	}

	public void update(Magazine magazine) throws SQLException {
		preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
		preparedStatement.setString(1, magazine.getName());
		preparedStatement.setDouble(2, magazine.getPrice());
		preparedStatement.setInt(3, magazine.getId());
		preparedStatement.executeUpdate();
	}

	public void delete(int id) throws SQLException {
		preparedStatement = connection.prepareStatement(DELETE_BY_ID);
		preparedStatement.setInt(1, id);
		preparedStatement.executeUpdate();
	}
	
	public List<Magazine> readAll() throws SQLException {
		List<Magazine> listOfMagazines = new ArrayList<>();
		preparedStatement = connection.prepareStatement(READ_ALL);
		ResultSet result = preparedStatement.executeQuery();
		while (result.next()) {
			listOfMagazines.add(MagazineMapper.map(result));
		}
		return listOfMagazines;
	}
}
