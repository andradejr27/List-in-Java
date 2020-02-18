package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.entities.Employee;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("How many employees will be registered? ");
		int n1 = sc.nextInt();
		
		List<Employee> empList = new ArrayList <>();
		
		for (int i = 1; i <= n1; i++) {
			System.out.println("Employee #" + i + ":");
			System.out.print("Id: ");
			int id = sc.nextInt();
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.println("Salary: ");
			double salary = sc.nextDouble();
			System.out.println();
			empList.add(new Employee(id, name, salary));
		}
		
		System.out.print("Enter the employee id that will have salary increase: ");
		int id = sc.nextInt();
		
		Employee emp = empList.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		if(emp == null) {
			System.out.println("Id does not exist");
		}
		else {
			System.out.print("Enter the percentage: ");
			double percentage = sc.nextDouble();
			emp.increaseSalary(percentage);
		}
		
		System.out.println("List of employees: ");
		for (Employee apelido : empList) {
			System.out.println(apelido);
		}
		
		sc.close();
	}

}
