package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();	
		
		System.out.println("=== TEST 1: department findById ===");
		Department department = departmentDao.findById(1);
		System.out.println(department);

		
		System.out.println("\n=== TEST 2: department findAll ===");
		List<Department> list= departmentDao.findAll();
		for (Department obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== TEST 3: seller insert ===");
		System.out.print("Enter id new department: ");
		int id = sc.nextInt();
		System.out.print("Enter name new department: ");
		String name = sc.next();
		Department newDepartment = new Department(id, name);
		departmentDao.insert(newDepartment);
		System.out.println("Inserted! new id = " + newDepartment.getId());
		
		System.out.println("\n=== TEST 4: seller update ===");
		department = departmentDao.findById(5);
		System.out.print("Enter new name: ");
		name = sc.next();
		department.setName(name);
		departmentDao.update(department);
		System.out.println("Update completed!");
		
		System.out.println("\n=== TEST 5: seller delete ===");
		System.out.println("Enter id for delete test: ");
		id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete completed");

		sc.close();
	}
}
