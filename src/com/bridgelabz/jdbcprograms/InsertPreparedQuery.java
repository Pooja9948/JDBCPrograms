package com.bridgelabz.jdbcprograms;

import java.sql.*;

public class InsertPreparedQuery {

	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement pstmt=null;//interface
		String qry="insert into bridgelabz.student values(?,?,?)";//its a parameter which holds dynamic values at the runtime.
		try{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver class loaded & Regestered");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			System.out.println("Connection Established with DB server");
			pstmt=con.prepareStatement(qry);//support once and execute many times
			System.out.println("Platform created");
			pstmt.setInt(1, 5);//return type of setXXX is void
			pstmt.setString(2, "pinky");
			pstmt.setString(3, "ece");
			pstmt.executeUpdate();
			
			pstmt.setInt(1, 6); 
			pstmt.setString(2, "chinky");
			pstmt.setString(3, "eee");
			pstmt.executeUpdate();
			
			pstmt.setInt(1, 7);
			pstmt.setString(2, "sonu");
			pstmt.setString(3, "eice");
			pstmt.executeUpdate();
			System.out.println("Data Inserted into DB successfully");
		}catch(ClassNotFoundException | SQLException e){
			e.printStackTrace();
		}finally{
			if(pstmt!=null){
				try{
					pstmt.close();
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
