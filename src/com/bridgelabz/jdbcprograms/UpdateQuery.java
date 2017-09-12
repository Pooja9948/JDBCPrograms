package com.bridgelabz.jdbcprograms;

import java.sql.*;

public class UpdateQuery {

	public static void main(String[] args) {
		Connection con=null;
		Statement stmt=null;
		String upquery="update bridgelabz.student set name='nayak' where id=1";
		try{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver is loading and registered...");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			stmt=con.createStatement();
			stmt.executeUpdate(upquery);
			System.out.println("Student details is updated");
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
