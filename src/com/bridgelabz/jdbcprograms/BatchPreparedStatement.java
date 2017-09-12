package com.bridgelabz.jdbcprograms;

import java.sql.*;

public class BatchPreparedStatement {

	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement pstmt=null;
		PreparedStatement pstmt1=null;
		String inqry="insert into bridgelabz.student values (10,'ratan','civil')";
		String delqry="delete from bridgelabz.user where id=2";
		try{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver class loaded & Regestered");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			System.out.println("Connection Established with DB server");
			pstmt=con.prepareStatement(inqry);
			pstmt.addBatch();
			int arr[]=pstmt.executeBatch();
			for(int i:arr){
				System.out.println(i);
			}
			pstmt1=con.prepareStatement(delqry);
			pstmt1.addBatch();
			int arr1[]=pstmt1.executeBatch();
			for(int j:arr1){
				System.out.println(j);
			}
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
