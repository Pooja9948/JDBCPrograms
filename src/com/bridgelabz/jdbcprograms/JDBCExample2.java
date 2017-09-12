package com.bridgelabz.jdbcprograms;

import java.sql.*;

public class JDBCExample2 {

	public static void main(String[] args) {
		Connection con=null;//Interface
		Statement stmt=null;//Interface
		String inquery="insert into bridgelabz.student values(1,'pooja','cse')";
		try{
			Class.forName("com.mysql.jdbc.Driver");//forName returns the respective driver class with fully qualified classname
			System.out.println("Driver is loading and registered...");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			//getConnection is a factory or helper method which is used to create  & return implementation of connection inteface based on URL
			//return type of getConnection is Connection interface
			System.out.println("Establish connection with DB server");
			stmt=con.createStatement();
			stmt.executeUpdate(inquery);//only execute DML queries
										//return type integer
			System.out.println("Data inserted to DB successfully");
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
