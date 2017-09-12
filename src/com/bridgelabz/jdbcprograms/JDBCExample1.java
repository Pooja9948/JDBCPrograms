package com.bridgelabz.jdbcprograms;

import java.sql.*;

public class JDBCExample1 {

	public static void main(String[] args) {
		Connection con=null;
		Statement stmt=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver is loading and registered...");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			System.out.println("Establish connection with DB server");
			stmt=con.createStatement();
			System.out.println("Platform created");
		}catch(ClassNotFoundException | SQLException e){
			e.printStackTrace();
		}finally{
			if(stmt!=null){
				try{
					stmt.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
			if(con!=null){
				try{
					con.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
		}
	}

}
