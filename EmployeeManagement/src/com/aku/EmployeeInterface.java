package com.aku;


public interface EmployeeInterface {
	public void createEmployee(Employee emp);
	public void showAllEmployee();
	public void showEmployeeById(int id);
	public void updateEmployee(Employee emp, int id);
	public void deleteEmployee(int id);
}
