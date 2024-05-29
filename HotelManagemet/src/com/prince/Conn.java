package com.prince;

import java.sql.*;

public class Conn {
	Connection con;
	static Statement stmt;
Conn(){
	try {
//	1	load the driver

		Class.forName("com.mysql.cj.jdbc.Driver");
//	2	create connection
		 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/HotelManagement","root","The cow1@");
//  3	create statment
		 stmt= con.createStatement();
//	4	
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
public static void main(String args[]) {
	
}
}
