package com.bridgelabz.jdbcprograms;

import java.sql.*;

public class SelectPreparedQuery {

	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String qry="Select * from bridgelabz.student";
		try{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver is loading and registered...");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			pstmt=con.prepareStatement(qry);
			rs=pstmt.executeQuery();
			//for multiple data use while loop
			while(rs.next()){
				int id=rs.getInt("id");
				String name=rs.getString(2);
				String branch=rs.getString(3);
				System.out.println(id+" "+name+" "+branch);
			}
			
			//for single data use if condtion
			/*if(rs.next()){
				int id=rs.getInt("id");
				String name=rs.getString(2);
				String branch=rs.getString(3);
				System.out.println(id+" "+name+" "+branch);
			}*/
		}catch(ClassNotFoundException | SQLException e){
			e.printStackTrace();
		}finally{
			if(rs!=null){
				try{
					rs.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
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
