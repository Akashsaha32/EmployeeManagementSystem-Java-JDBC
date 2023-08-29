package com.aku;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	public static Connection con;
	
	public static Connection createDBConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/employeesDB?useSSl=false";
			String username = "root";
			String password = "";
			con = DriverManager.getConnection(url, username, password);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}
