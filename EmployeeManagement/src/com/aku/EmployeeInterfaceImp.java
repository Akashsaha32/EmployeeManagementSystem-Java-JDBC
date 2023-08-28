package com.aku;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class EmployeeInterfaceImp implements EmployeeInterface{
	Connection con;

	@Override
	public void createEmployee(Employee emp) {
		//System.out.println(emp.getId()+", "+emp.getName()+", "+emp.getSalary()+", "+emp.getAge());
		con = DBConnection.createDBConnection();
		String query = "INSERT INTO employee values(?, ?, ?, ?)";
		try {
			PreparedStatement pstate = con.prepareStatement(query);
			pstate.setInt(1, emp.getId());
			pstate.setString(2, emp.getName());
			pstate.setDouble(3, emp.getSalary());
			pstate.setInt(4, emp.getAge());
			int rslt = pstate.executeUpdate();
			if(rslt != 0) {
				System.out.println("\n\nData Inserted Succesful.\n\n");
			}
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void showAllEmployee() {
		con = DBConnection.createDBConnection();
		String query = "SELECT * FROM employee";
		System.out.println("#######################################################");
		System.out.println("Employee Details...");
		System.out.println("ID\tName\t\tSalary\tAge");
		
		try {
			Statement stmt = con.createStatement();
			ResultSet rset = stmt.executeQuery(query);
			while(rset.next()) {
				System.out.format("%d\t%s\t%.2f\t%d",rset.getInt(1), rset.getString(2), rset.getDouble(3), rset.getInt(4));
				System.out.println();
			}
			stmt.close();
			con.close();
			System.out.println("#######################################################");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void showEmployeeById(int id) {
		con = DBConnection.createDBConnection();
		String query = "SELECT * FROM employee where id="+id;
		System.out.println("#######################################################");
		System.out.println("Employee Details of ID: "+id);
		
		try {
			Statement stmt = con.createStatement();
			ResultSet rset = stmt.executeQuery(query);
			if(rset == null) {
				System.out.println("There is no employee of this ID: "+id);
			}else {
				System.out.println("ID\tName\t\tSalary\tAge");
				while(rset.next()) {
					System.out.format("%d\t%s\t%.2f\t%d",rset.getInt(1), rset.getString(2), rset.getDouble(3), rset.getInt(4));
					System.out.println();
				}
			}
			stmt.close();
			con.close();
			System.out.println("#######################################################");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateEmployee(Employee emp, int id) {
		con = DBConnection.createDBConnection();
		String queue = "SELECT * FROM employee where id="+id;
		try {
			Statement stmt = con.createStatement();
			ResultSet rset = stmt.executeQuery(queue);
			if(rset.next() == false) {
				System.out.println("\n\tThere is no Record Available of ID: "+id);
				stmt.close();
			}else {
				String query1 = "UPDATE employee set name=?, salary=?, age=? where id=?";
				PreparedStatement pstate = con.prepareStatement(query1);
				pstate.setString(1, emp.getName());
				pstate.setDouble(2, emp.getSalary());
				pstate.setInt(3, emp.getAge());
				pstate.setInt(4, id);
				int state = pstate.executeUpdate();
				if(state != 0) {
					System.out.println("\n\tEmployee updated succesfully...");
				}
				stmt.close();
				con.close();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteEmployee(int id) {
		con = DBConnection.createDBConnection();
		String query1 = "DELETE FROM employee WHERE id=?";
		String query2 = "SELECT * FROM employee where id="+id;
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query2);
			if(rs.next() == false) {
				System.out.println("\n\tRecord Not Found");
				stmt.close();
			}else {
				PreparedStatement ps = con.prepareStatement(query1);
				ps.setInt(1, id);
				int s = ps.executeUpdate();
				if(s != 0) {
					System.out.println("\n\tRecord Deleted Succesfully...");
				}
				stmt.close();
				con.close();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
