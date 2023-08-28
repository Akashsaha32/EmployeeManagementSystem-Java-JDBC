package com.aku;

import java.util.Scanner;

public class RunnerClass {
	public void runFromMain() {
		System.out.println("Welcome to our Employee Management Application");
		
		EmployeeInterface empi = new EmployeeInterfaceImp();
		
		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.println("\n\n1. Add Employee\n2. Show All Employee"
					+ "\n3. Show Employee Based on ID"
					+ "\n4. Update Employee\n5. Delete Employee\n6. Exit Application");
			System.out.print("Enter Choice: ");
			int opt = sc.nextInt();
			
			switch(opt) {
				case 1:
					System.out.print("Enter id: ");
					int id = sc.nextInt();
					System.out.print("Enter Name: ");
					sc.nextLine();
					String name = sc.nextLine();
					System.out.print("Enter salary: ");
					double salary = sc.nextDouble();
					System.out.print("Enter Age: ");
					int age = sc.nextInt();
					Employee emp = new Employee(id, name, salary, age);
					empi.createEmployee(emp);
					break;
				case 2:
					empi.showAllEmployee();
					break;
				case 3:
					System.out.print("Enter ID to show Employee Details: ");
					int empid = sc.nextInt();
					empi.showEmployeeById(empid);
					break;
				case 4:
					System.out.print("For update employee enter ID: ");
					int empid1 = sc.nextInt();
					System.out.print("Enter updated Name: ");
					sc.nextLine();
					String name1 = sc.nextLine();
					System.out.print("Enter updated salary: ");
					double salary1 = sc.nextDouble();
					System.out.print("Enter updated Age: ");
					int age1 = sc.nextInt();
					Employee emp1 = new Employee(empid1, name1, salary1, age1);
					empi.updateEmployee(emp1, empid1);
					break;
				case 5:
					System.out.print("To Delete Employee Enter ID: ");
					int empid3 = sc.nextInt();
					empi.deleteEmployee(empid3);
					break;
				case 6:
					sc.close();
					System.exit(0);
					break;
				default:
					System.out.println("\nEnter Valid Choice...........\n\n");
					break;
			}
			
		}while(true);
	}
}
