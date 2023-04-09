package lesson2;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Application {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		EmployeeDao employeeDao = new EmployeeDao(ConnectionUtils.openConnection());
		MagazineDao magazineDao = new MagazineDao(ConnectionUtils.openConnection());
		
		List<Magazine> listOfMagazines = new ArrayList<>();
		listOfMagazines.add(new Magazine("Avengers", 3.50));
		listOfMagazines.add(new Magazine("X-MEN", 2.75));
		listOfMagazines.add(new Magazine("Spider-Man", 7.99));
		listOfMagazines.add(new Magazine("Batman", 5.35));
		listOfMagazines.add(new Magazine("Flash", 4.25));
		
		//INSERT
		listOfMagazines.forEach(magazine -> {
			try {
				magazineDao.insert(magazine);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		});
		
		//READ_ALL
		magazineDao.readAll().forEach(System.out::println);
		
		//READ_BY_ID
		Magazine magazineDB = magazineDao.read(3);
		System.out.println(magazineDB);
		
		//UPDATE_BY_ID
		magazineDB.setPrice(10.50);
		System.out.println(magazineDB);
		
		//READ_BY_ID
		System.out.println(magazineDB);
		
		//DELETE_BY_ID
		magazineDao.delete(4);
		magazineDao.readAll().forEach(System.out::println);
		
		
		//READ_ALL
		employeeDao.readAll().forEach(System.out::println);
		
		List<Employee> listOfEmployees = new ArrayList<>();
		listOfEmployees.add(new Employee("Andrew", "Lincoln"));
		listOfEmployees.add(new Employee("Kate", "Bishop"));
		listOfEmployees.add(new Employee("Bruce", "Banner"));
		listOfEmployees.add(new Employee("Peter", "Parker"));
		listOfEmployees.add(new Employee("Reed", "Richards"));
		
		//INSERT
		listOfEmployees.forEach(employee -> {
			try {
				employeeDao.insert(employee);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		});
		
		//READ_ALL
		employeeDao.readAll().forEach(System.out::println);
		
		//READ_BY_ID
		Employee employeeFromDB = employeeDao.read(2);
		System.out.println(employeeFromDB);
		
		//UPDATE_BY_ID
		employeeFromDB.setName("Elizabeth");
		employeeDao.update(employeeFromDB);
		
		//READ_BY_ID
		System.out.println(employeeFromDB);
		
		//DELETE_BY_ID
		employeeDao.delete(2);
		employeeDao.readAll().forEach(System.out::println);	
	}
}
