package com.bridgelabz.jdbcprograms;

import java.sql.*;

public class InsertMultipleRecords {

	public static void main(String[] args) {
		Connection con=null;
		Statement stmt=null;
		String query1="insert into bridgelabz.student values(1,'Pooja','cse')";
		String query2="insert into bridgelabz.student values(3,'Nita','mech')";
		String query3="insert into bridgelabz.student values(4,'Tina','civil')";
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			stmt=con.createStatement();
			stmt.executeUpdate(query1);
			stmt.executeUpdate(query2);
			stmt.executeUpdate(query3);
			System.out.println("Datas are inserted into db");
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
